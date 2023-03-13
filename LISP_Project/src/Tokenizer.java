import java.util.ArrayList;

public class Tokenizer {
	
	final String OPEN_PAR = "OPEN_PAR";
	final String NUMBER = "NUMBER";
	final String CLOSE_PAR = "CLOSE_PAR";
	final String ADDING_OPERATOR = "ADDING_OPERATOR";
	final String SUBTRACTING_OPERATOR = "SUBTRACTING_OPERATOR";
	final String MULTIPLYING_OPERATOR = "MULTIPLYING_OPERATOR";
	final String DIVIDING_OPERATOR = "DIVIDING_OPERATOR";
	final String QUOTE = "QUOTE";
	final String STRING = "STRING";
	final String ATOM = "ATOM";
	final String ATOM_T = "ATOM_T";
	final String ATOM_NIL = "ATOM_NIL";
	final String EMPTY_LIST = "EMPTY LIST";
	final String LIST = "LIST";
	
	//Variables that are considered atoms are also number and string
	
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
				Token<Float> newToken = new Token<Float>(NUMBER, Ftoken);
				TokenList.add(newToken);
			}
			
			else if(token.equals( "'" ) || token.equals("quote")) {

				Token<String> newToken = new Token<String>(QUOTE, "'");
				TokenList.add(newToken);
			}
			else if(token.equalsIgnoreCase( "atom" )) {
				Token<String> newToken = new Token<String>(ATOM, "atom");
				TokenList.add(newToken);
			}
			
			else if(token.equalsIgnoreCase( "T" )) {
				Token<Boolean> newToken = new Token<Boolean>(ATOM_T, true);
				TokenList.add(newToken);
			}
			
			else if(token.equalsIgnoreCase( "NIL" )) {
				Token<Boolean> newToken = new Token<Boolean>(ATOM_NIL, false);
				TokenList.add(newToken);
			}
			
			else if(token.equalsIgnoreCase( "()" )) {
				Token<String[]> newToken = new Token<String[]>(EMPTY_LIST, new String[0]);
				TokenList.add(newToken);
			}
			
			else {
				Token<String> newToken = new Token<>(STRING, token);
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
