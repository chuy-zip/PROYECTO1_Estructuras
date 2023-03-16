import java.util.ArrayList;

/**
 * This class represents a method, which contains its name, parameters, code, and given parameters.
 */
public class Method {
	
	/** 
	 * The name of each method 
	 */
	private String MethodName;
	private ArrayList<Token> Parameters;
	private ArrayList<Token> Code;
	private ArrayList<Token> GivenParameters;
	
	/**
	* Constructs a new Method object with the specified name.
	* @param name the name of the method
	*/
	public Method(String name){
		
		 MethodName = name;
		 Parameters = new ArrayList<Token>();
		 Code = new ArrayList<Token>();
		 GivenParameters = new ArrayList<Token>();
		
	}

	/**
	* Returns the name of the method.
	* @return the name of the method
	*/
	public String getMethodName() {
		return MethodName;
	}

	/**
	* Sets the name of the method.
	* @param methodName the new name of the method
	*/
	public void setMethodName(String methodName) {
		MethodName = methodName;
	}

	/**
	* Returns the list of tokens representing the parameters of the method.
	* @return the list of tokens representing the parameters of the method
	*/
	public ArrayList<Token> getParameters() {
		return Parameters;
	}

	/**
	* Sets the list of tokens representing the parameters of the method.
	* @param parameters the new list of tokens representing the parameters of the method
	*/
	public void setParameters(ArrayList<Token> parameters) {
		Parameters = parameters;
	}

	/**
	* Returns the list of tokens representing the code of the method.
	* @return the list of tokens representing the code of the method
	*/
	public ArrayList<Token> getCode() {
		return Code;
	}

	/**
	* Sets the list of tokens representing the code of the method.
	* @param code the new list of tokens representing the code of the method
	*/
	public void setCode(ArrayList<Token> code) {
		Code = code;
	}

	/**
	* Returns the list of tokens representing the given parameters of the method.
	* @return the list of tokens representing the given parameters of the method
	*/
	public ArrayList<Token> getGivenParameters() {
		return GivenParameters;
	}

	/**
	* Sets the list of tokens representing the given parameters of the method.
	* @param givenParameters the new list of tokens representing the given parameters of the method
	*/
	public void setGivenParameters(ArrayList<Token> givenParameters) {
		GivenParameters = givenParameters;
	}
	
	/**
	* Replaces the parameters in the code of the method with the given parameters.
	* If there are no initial parameters, the method has no parameters, and the function returns.
	*/
	public void ReplaceParameters() {
		try {
			Parameters.get(0);// If there is no initial position,that means the method has no parameters
			
		} catch (Exception e) {
			return;
		}
		
		for (Token Parameter : Parameters) {
			for (Token token : Code) {
				
				if(token.getValue().equals(Parameter.getValue())) { // If there is a match, the variable will be changed
					Code.set( Code.indexOf(token), GivenParameters.get(Parameters.indexOf(Parameter)) );
					//Now the value of token in the defined function is replaced with the parameter given by the user
				}

			}
			
		}
		
	}

}
