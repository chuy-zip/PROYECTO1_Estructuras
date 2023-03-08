
public class Token<T> {
	
	private String TokenType;
	
	private T Value;
	
	public Token(String type, T val) {
		this.TokenType = type;
		this.Value = val;
	}

	public String getTokenType() {
		return TokenType;
	}

	public void setTokenType(String tokenType) {
		TokenType = tokenType;
	}

	public T getValue() {
		return Value;
	}

	public void setValue(T value) {
		Value = value;
	}
	
	
}
