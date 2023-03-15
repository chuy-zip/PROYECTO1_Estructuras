import java.util.ArrayList;

public class Method {
	
	private String MethodName;
	private ArrayList<Token> Parameters;
	private ArrayList<Token> Code;
	
	public Method(String name, ArrayList<Token> param, ArrayList<Token> TokenList){
		
		 MethodName = name;
		 Parameters = param;
		 Code = TokenList;
		
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
	
	

}
