
public class LISPOperations {
public Token<Float> Add(Token<Float> num1, Token<Float> num2){
		
		float result = num1.getValue() + num2.getValue();
		Token<Float> resultToken = new Token<>("ATOM", result);
				
		return resultToken;
		
	}
	
	public Token<Float> Subtract(Token<Float> num1, Token<Float> num2){
		
		float result = num2.getValue() - num1.getValue();
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
}
