import java.util.ArrayList;
import java.util.Stack;

/**
 * Class that provides basic mathematical operations for the LISP language.
 */
public class LISPOperations {
	
	 /**
     * Method that adds two numbers.
     * 
     * @param num1 the first number to add
     * @param num2 the second number to add
     * @return a token that represents the sum of num1 and num2
     */	
public Token<Float> Add(Token<Float> num1, Token<Float> num2){
		
		float result = num1.getValue() + num2.getValue();
		Token<Float> resultToken = new Token<>("NUMBER", result);
				
		return resultToken;
		
	}
	
	/**
	 * Method that subtracts two numbers.
	 * 
	 * @param num1 the number to subtract from
	 * @param num2 the number to subtract from num1
	 * @return a token that represents the subtraction of num2 from num1
	 */
	public Token<Float> Subtract(Token<Float> num1, Token<Float> num2){
		
		float result = num1.getValue() - num2.getValue();
		Token<Float> resultToken = new Token<>("NUMBER", result);
				
		return resultToken;
		
	}
	
	/**
     * Method that divides two numbers.
     * 
     * @param num1 the numerator
     * @param num2 the denominator
     * @return a token that represents the quotient of num1 and num2
     */
	public Token<Float> Divide(Token<Float> num1, Token<Float> num2){
		
		float result = num1.getValue() / num2.getValue();
		Token<Float> resultToken = new Token<>("NUMBER", result);
				
		return resultToken;
		
	}
	
	/**
     * Method that multiplies two numbers.
     * 
     * @param num1 the first factor
     * @param num2 the second factor
     * @return a token that represents the product of num1 and num2
     */
	public Token<Float> Multiply(Token<Float> num1, Token<Float> num2){
		
		float result = num1.getValue() * num2.getValue();
		Token<Float> resultToken = new Token<>("NUMBER", result);
				
		return resultToken;
		
	}
	
}
