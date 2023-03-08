import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class main {
	public static void main(String[] args) {
		
		System.out.println("INTERPRETE LISP");
		
		Tokenizer Tokenizer = new Tokenizer();
		
		String[] Program = FileReader();
		
		ArrayList<Token> TokenList = Tokenizer.StringToTokens(Program);
		
		for (Token token : TokenList) {
			System.out.println("Type: " + token.getTokenType() + " Value: " + token.getValue());
		}
		
		
		
	}
	
	public static String[] FileReader() {
		
		String MyFile = "src/LISP.txt";
		String CompleteLine = "";
		String Currentline = ""; 	
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(MyFile));
			while((Currentline = reader.readLine())!=null) {
				CompleteLine += Currentline; 
			}
			
		} catch (Exception e) {
			System.out.println("Error al leer el archivo");
		}
		
		String[] List = CompleteLine.split(" "); 
	
		return List;
	}
}
