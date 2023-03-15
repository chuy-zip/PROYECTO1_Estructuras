import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
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
		LISPEvaluator Evaluator = new LISPEvaluator();
		
		HashMap<String, Object> CreatedMethods = new HashMap<String, Object>();
		MethodParser MethodCreator = new MethodParser();
		
        Stack.push(CurrentExpression);
		
		boolean IsQuoted = false;
		boolean InDefun = false;
		
		for (Token token : TokenList) {
			
			if( token.getTokenType().equals(Tokenizer.DEFUN)) {
				InDefun = true; // Setting flag so the interpreter knows every character must be in the defun
				MethodCreator.setOpenParQty(1);
				
			}
			
			else if( InDefun ) {
				
				
				if (token.getTokenType().equals(Tokenizer.OPEN_PAR)) {
					MethodCreator.setOpenParQty( MethodCreator.getOpenParQty() + 1);
					
				}
				
				else if(token.getTokenType().equals(Tokenizer.CLOSE_PAR)) {
					MethodCreator.setCloseParQTty( MethodCreator.getCloseParQTty() + 1);
				}
				
				else if(MethodCreator.getOpenParQty()  == 1) {//Its going to read the name of the method if there is only the first parenthesis
					System.out.println("Nombre del metodo:" + token.getValue());
				}
				
				else if(MethodCreator.getOpenParQty()  == 2 && MethodCreator.getCloseParQTty() == 0) { //This means the reader is in the parameters of the function
					System.out.println("Parametro" + token.getValue());
				}
			
				if(!MethodCreator.SameQtyOfParenthesis() && MethodCreator.getCloseParQTty() >= 1) {
					System.out.println("Agregando: " + token.getValue());
				}
				
				if(MethodCreator.SameQtyOfParenthesis()) {
					System.out.println("Misma cantidad de parentesis");
					InDefun = false;
				}
				
			}
			
			else if (token.getTokenType().equals(Tokenizer.OPEN_PAR) && IsQuoted == false ) {
				ArrayList<Token> ListExpression = new ArrayList<>();
	            Stack.push(ListExpression);
			}
			
			
			
			else if(token.getTokenType().equals(Tokenizer.CLOSE_PAR) && IsQuoted == false) {
				ArrayList<Token> EvaluatedList = Stack.pop();
				Stack.peek().add(Evaluator.evaluateExpression(EvaluatedList, Operator, Tokenizer));
				
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
	
public static String[] FileReader() {
		
	String MyFile = "src/LISP.txt";
	String CompleteLine = "";
	String Currentline = ""; 	
		
	try {
		BufferedReader reader = new BufferedReader(new FileReader(MyFile));
		while((Currentline = reader.readLine())!=null) {
			int semicolonIndex = CompleteLine.indexOf(';');
		    if (semicolonIndex >= 0) {
		        CompleteLine = CompleteLine.substring(0, semicolonIndex);
		    }
		    
			CompleteLine += Currentline; 
		}
			
		} catch (Exception e) {
			System.out.println("Error al leer el archivo");
		}
		
	
	CompleteLine = CompleteLine.replace("\t", " ");
	System.out.println(CompleteLine);
		
	String[] List = CompleteLine.split(" "); 
	
	return List;
	
	}
}
