/**
 * A class representing a token with a given type and value.
 * @param <T> the type of the token's value
 */
public class Token<T> {
	
	private String TokenType;
	
	private T Value;
	
	/**
	 * Constructs a token with the given type and value.
	 * @param type the type of the token
	 * @param val the value of the token
	 */
	public Token(String type, T val) {
		this.TokenType = type;
		this.Value = val;
	}

	/**
	 * Returns the type of the token.
	 * @return the type of the token
	 */
	public String getTokenType() {
		return TokenType;
	}

	/**
	 * Sets the type of the token.
	 * @param tokenType the new type of the token
	 */
	public void setTokenType(String tokenType) {
		TokenType = tokenType;
	}

	/**
	 * Returns the value of the token.
	 * @return the value of the token
	 */
	public T getValue() {
		return Value;
	}

	/**
	 * Sets the value of the token.
	 * @param value the new value of the token
	 */
	public void setValue(T value) {
		Value = value;
	}
	
	
}
