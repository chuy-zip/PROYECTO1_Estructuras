import java.util.ArrayList;
import java.util.Stack;

public class LISPOperations {
public Token<Float> Add(Token<Float> num1, Token<Float> num2){
		
		float result = num1.getValue() + num2.getValue();
		Token<Float> resultToken = new Token<>("NUMBER", result);
				
		return resultToken;
		
	}
	
	public Token<Float> Subtract(Token<Float> num1, Token<Float> num2){
		
		float result = num1.getValue() - num2.getValue();
		Token<Float> resultToken = new Token<>("NUMBER", result);
				
		return resultToken;
		
	}
	
	public Token<Float> Divide(Token<Float> num1, Token<Float> num2){
		
		float result = num1.getValue() / num2.getValue();
		Token<Float> resultToken = new Token<>("NUMBER", result);
				
		return resultToken;
		
	}
	
	public Token<Float> Multiply(Token<Float> num1, Token<Float> num2){
		
		float result = num1.getValue() * num2.getValue();
		Token<Float> resultToken = new Token<>("NUMBER", result);
				
		return resultToken;
		
	}
	
}
