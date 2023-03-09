import java.util.ArrayList;
import java.util.Stack;

public class LISPOperations {
public Token<Float> Add(Token<Float> num1, Token<Float> num2){
		
		float result = num1.getValue() + num2.getValue();
		Token<Float> resultToken = new Token<>("ATOM", result);
				
		return resultToken;
		
	}
	
	public Token<Float> Subtract(Token<Float> num1, Token<Float> num2){
		
		float result = num1.getValue() - num2.getValue();
		Token<Float> resultToken = new Token<>("ATOM", result);
				
		return resultToken;
		
	}
	
	public Token<Float> Divide(Token<Float> num1, Token<Float> num2){
		
		float result = num1.getValue() / num2.getValue();
		Token<Float> resultToken = new Token<>("ATOM", result);
				
		return resultToken;
		
	}
	
	public Token<Float> Multiply(Token<Float> num1, Token<Float> num2){
		
		float result = num1.getValue() * num2.getValue();
		Token<Float> resultToken = new Token<>("ATOM", result);
				
		return resultToken;
		
	}
	
	public Token<String> QuoteConverter(ArrayList<Token> List, Tokenizer tokenizer) {
		
		Stack<Token> StackQuote = new Stack<Token>();
		
		for (Token token2 : List) {
			StackQuote.push(token2);	
		}
		
		StackQuote.pop(); // removing last parenthesis
		
		 ArrayList<String> QuoteList = new ArrayList<>();
		
		while(!StackQuote.peek().getTokenType().equals(tokenizer.QUOTE)) {
			QuoteList.add("" + StackQuote.pop().getValue()); 
		}
		
		String QuotedString = "";
		
		for (int i = QuoteList.size() - 1; i >= 0; i--) {
            QuotedString += QuoteList.get(i) + " ";
        }
		
		Token<String> newToken = new Token<>(tokenizer.STRING, QuotedString);
		
		return newToken;
	}
}
