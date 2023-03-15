import java.util.ArrayList;

public class Method {
	
	private String MethodName;
	private ArrayList<Token> Parameters;
	private ArrayList<Token> Code;
	private ArrayList<Token> GivenParameters;
	
	public Method(String name){
		
		 MethodName = name;
		 Parameters = new ArrayList<Token>();
		 Code = new ArrayList<Token>();
		 GivenParameters = new ArrayList<Token>();
		
	}

	public String getMethodName() {
		return MethodName;
	}

	public void setMethodName(String methodName) {
		MethodName = methodName;
	}

	public ArrayList<Token> getParameters() {
		return Parameters;
	}

	public void setParameters(ArrayList<Token> parameters) {
		Parameters = parameters;
	}

	public ArrayList<Token> getCode() {
		return Code;
	}

	public void setCode(ArrayList<Token> code) {
		Code = code;
	}

	public ArrayList<Token> getGivenParameters() {
		return GivenParameters;
	}

	public void setGivenParameters(ArrayList<Token> givenParameters) {
		GivenParameters = givenParameters;
	}
	
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
