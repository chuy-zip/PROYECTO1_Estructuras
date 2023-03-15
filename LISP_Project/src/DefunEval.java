import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class DefunEval {
	
	public Token Evaluate(ArrayList<Token> TokenList){
		
		Tokenizer Tokenizer = new Tokenizer();
		LISPOperations Operator = new LISPOperations();
	
		Stack<ArrayList<Token>> Stack = new Stack<>();
		ArrayList<Token> CurrentExpression = new ArrayList<>();
		LISPEvaluator Evaluator = new LISPEvaluator();
		
		HashMap<String, Method> CreatedMethods = new HashMap<String, Method>();
		MethodParser MethodCreator = new MethodParser();
		String CreatedMethodName = ""; 
		
        Stack.push(CurrentExpression);
		
		boolean IsQuoted = false;
		boolean InDefun = false;
		
		for (Token token : TokenList) {
		
			if (token.getTokenType().equals(Tokenizer.OPEN_PAR) && IsQuoted == false ) {
				ArrayList<Token> ListExpression = new ArrayList<>();
	            Stack.push(ListExpression);
			}
			
			
			else if(token.getTokenType().equals(Tokenizer.CLOSE_PAR) && IsQuoted == false) {
				ArrayList<Token> EvaluatedList = Stack.pop();
				Stack.peek().add(Evaluator.evaluateExpression(EvaluatedList, Operator, Tokenizer, CreatedMethods));
				
			} 
			else if(token.getTokenType().equals(Tokenizer.QUOTE)) {
				
				IsQuoted = true;
			}
			
			else if(IsQuoted == true) {
				
				if( TokenList.indexOf(token) + 1 < TokenList.size()) {
					token.setTokenType(Tokenizer.STRING);
					Stack.peek().add(token);
				}
				
				else {
					
					IsQuoted = false;
					String QuotedExpresion = "";
					for (Token token2 : Stack.peek()) {
						QuotedExpresion += token2.getValue() + " ";
					}
					Stack.pop();
					QuotedExpresion = QuotedExpresion.trim();
					Stack.peek().add(new Token<String>(Tokenizer.STRING, QuotedExpresion));
				}
			}
			
			
			else {
	            // push any other operation tokens
	            Stack.peek().add(token);
	        }
			
		}
		
		Token result = Stack.pop().get(0);
		return result;
		
	}

}
