import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Stack;

public class main {
	public static void main(String[] args) {
		
		System.out.println("INTERPRETE LISP");
		
		Tokenizer Tokenizer = new Tokenizer();
		LISPOperations Operator = new LISPOperations();
		
		String[] Program = FileReader();
		ArrayList<Token> TokenList = Tokenizer.StringToTokens(Program);
		Stack<ArrayList<Token>> Stack = new Stack<>();
		ArrayList<Token> CurrentExpression = new ArrayList<>();
        Stack.push(CurrentExpression);
		
		boolean IsQuoted = false;
		
		for (Token token : TokenList) {
			
			if (token.getTokenType().equals(Tokenizer.OPEN_PAR) && IsQuoted == false) {
				ArrayList<Token> ListExpression = new ArrayList<>();
	            Stack.push(ListExpression);
			}
			
			else if(token.getTokenType().equals(Tokenizer.CLOSE_PAR) && IsQuoted == false) {
				ArrayList<Token> EvaluatedList = Stack.pop();
				Stack.peek().add(evaluateExpression(EvaluatedList, Operator, Tokenizer));
				
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
		
		System.out.println(Stack.pop().get(0).getValue());
		
	}
	
	public static <T> Token evaluateExpression(ArrayList<Token> expression, LISPOperations Operator, Tokenizer Tokenizer ) {
	    Stack<Token> stack = new Stack<>();
	    for (Token token : expression) {
	    	stack.push(token);
	    }
	    
	    for (Token token : expression) {
	    	
	        if (token.getTokenType().equals(Tokenizer.ADDING_OPERATOR)) {
	            Token<Float> num2 = stack.pop();
	            Token<Float> num1 = stack.pop();
	            return Operator.Add(num1, num2); // evaluate and push result onto stack
	        } else if (token.getTokenType().equals(Tokenizer.SUBTRACTING_OPERATOR)) {
	            Token<Float> num2 = stack.pop();
	            Token<Float> num1 = stack.pop();
	            return Operator.Subtract(num1, num2); // evaluate and push result onto stack
	        } else if (token.getTokenType().equals(Tokenizer.MULTIPLYING_OPERATOR)) {
	            Token<Float> num2 = stack.pop();
	            Token<Float> num1 = stack.pop();
	            return Operator.Multiply(num1, num2); // evaluate and push result onto stack
	        } else if (token.getTokenType().equals(Tokenizer.DIVIDING_OPERATOR)) {
	            Token<Float> num2 = stack.pop();
	            Token<Float> num1 = stack.pop();
	            return Operator.Divide(num1, num2); // evaluate and push result onto stack
	        } else if(token.getTokenType().equals(Tokenizer.ATOM)) {
	        	Token<Boolean> Item = stack.pop();
	        	String ItemType = Item.getTokenType();
	        	if(ItemType.equals(Tokenizer.ATOM_NIL) || ItemType.equals(Tokenizer.ATOM_T) || ItemType.equals(Tokenizer.NUMBER) || ItemType.equals(Tokenizer.STRING) || ItemType.equals(Tokenizer.EMPTY_LIST) )  {
	        		 Token<Boolean> IsAtom = new Token<Boolean>(Tokenizer.ATOM_T, true);
	        		 return IsAtom;
	        	}
	        	else {
	        		Token<Boolean> NotAtom = new Token<Boolean>(Tokenizer.ATOM_NIL, false);
	        		return NotAtom;
	        		
	        	}	
	        }	else if(token.getTokenType().equals(Tokenizer.EQUALS)) {
	        		Token<T> item1 = stack.pop();
	        		T Item1Val= item1.getValue();
	        		Token<T> item2 = stack.pop();
	        		T Item2Val= item2.getValue();
	        		
	        		if(Item1Val.equals(Item2Val)) {
	        			Token<Boolean> IsSame = new Token<Boolean>(Tokenizer.ATOM_T, true);
		        		return IsSame;
	        		}
	        		else {
		        		Token<Boolean> NotSame = new Token<Boolean>(Tokenizer.ATOM_NIL, false);
		        		return NotSame;
		        	}	
	        	
	        }
	    }
	    
	    return stack.pop(); // return the final result
	}
	
	public static String[] FileReader() {
		
		String MyFile = "src/LISP.txt";
		String CompleteLine = "";
		String Currentline = ""; 	
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(MyFile));
			while((Currentline = reader.readLine())!=null) {
				CompleteLine += Currentline; 
			}
			
		} catch (Exception e) {
			System.out.println("Error al leer el archivo");
		}
		System.out.println(CompleteLine);
		
		String[] List = CompleteLine.split(" "); 
	
		return List;
	}
}
