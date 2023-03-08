import java.util.ArrayList;

public class Tokenizer {
	
	final String OPEN_PAR = "OPEN_PAR";
	final String ATOM = "ATOM";
	final String CLOSE_PAR = "CLOSE_PAR";
	final String ADDING_OPERATOR = "ADDING_OPERATOR";
	final String SUBTRACTING_OPERATOR = "SUBTRACTING_OPERATOR";
	final String MULTIPLYING_OPERATOR = "MULTIPLYING_OPERATOR";
	final String DIVIDING_OPERATOR = "DIVIDING_OPERATOR";
	
	public ArrayList<Token> StringToTokens(String[] ProgramString) {
		ArrayList<Token> TokenList = new ArrayList<>();
		
		for (String token : ProgramString) {
			
			if(token.equals("(")) {
				Token<String> newToken = new Token<>(OPEN_PAR , "(");
				TokenList.add(newToken);
				
			}
			
			else if(token.equals(")")) {
				Token<String> newToken = new Token<>(CLOSE_PAR, ")");
				TokenList.add(newToken);
			}
			
			else if (token.equals("+")) {
			    Token<String> newToken = new Token<>(ADDING_OPERATOR, "+");
			    TokenList.add(newToken);
			}

			else if (token.equals("-")) {
			    Token<String> newToken = new Token<>(SUBTRACTING_OPERATOR, "-");
			    TokenList.add(newToken);
			}

			else if (token.equals("*")) {
			    Token<String> newToken = new Token<>(MULTIPLYING_OPERATOR, "*");
			    TokenList.add(newToken);
			}

			else if (token.equals("/")) {
			    Token<String> newToken = new Token<>(DIVIDING_OPERATOR, "/");
			    TokenList.add(newToken);
			}
			
			else if(isNumeric(token)) {
				Float Ftoken = Float.parseFloat(token);
				Token<Float> newToken = new Token<Float>(ATOM, Ftoken);
				TokenList.add(newToken);
			}
		}
		
		return TokenList;
		
	}
	
	public boolean isNumeric(String str) { 
		  try {  
		    Double.parseDouble(str);  
		    return true;
		  } catch(NumberFormatException e){  
		    return false;  
		  }  
		}

}
