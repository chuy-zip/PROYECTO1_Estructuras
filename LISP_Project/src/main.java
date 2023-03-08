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
		Stack<Token> Stack = new Stack<Token>();
		
		for (Token token : TokenList) {
			if (token.getTokenType().equals(Tokenizer.OPEN_PAR)) {
	            // push open parenthesis onto stack
	            Stack.push(token);
			}
			
			else if(token.getTokenType().equals(Tokenizer.CLOSE_PAR)) {
				ArrayList<Token> ListExpression = new ArrayList<>();
				while(!Stack.peek().getTokenType().equals(Tokenizer.OPEN_PAR)) {
					ListExpression.add(Stack.pop());
				}
				Stack.pop();
				
				 Stack.push(evaluateExpression(ListExpression, Operator, Tokenizer));
			
			} else {
	            // push other tokens onto stack
	            Stack.push(token);
	        }
			
		}
		
		System.out.println(Stack.pop().getValue());
		
	}
	
	public static Token<Float> evaluateExpression(ArrayList<Token> expression, LISPOperations Operator, Tokenizer Tokenizer ) {
	    Stack<Token<Float>> stack = new Stack<>();
	    
	    for (Token token : expression) {
	        if (token.getTokenType().equals(Tokenizer.ATOM)) {
	            stack.push(token); // push number onto stack
	        } else if (token.getTokenType().equals(Tokenizer.ADDING_OPERATOR)) {
	            Token<Float> num2 = stack.pop();
	            Token<Float> num1 = stack.pop();
	            stack.push(Operator.Add(num1, num2)); // evaluate and push result onto stack
	        } else if (token.getTokenType().equals(Tokenizer.SUBTRACTING_OPERATOR)) {
	            Token<Float> num2 = stack.pop();
	            Token<Float> num1 = stack.pop();
	            stack.push(Operator.Subtract(num1, num2)); // evaluate and push result onto stack
	        } else if (token.getTokenType().equals(Tokenizer.MULTIPLYING_OPERATOR)) {
	            Token<Float> num2 = stack.pop();
	            Token<Float> num1 = stack.pop();
	            stack.push(Operator.Multiply(num1, num2)); // evaluate and push result onto stack
	        } else if (token.getTokenType().equals(Tokenizer.DIVIDING_OPERATOR)) {
	            Token<Float> num2 = stack.pop();
	            Token<Float> num1 = stack.pop();
	            stack.push(Operator.Divide(num1, num2)); // evaluate and push result onto stack
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
		
		String[] List = CompleteLine.split(" "); 
	
		return List;
	}
}
