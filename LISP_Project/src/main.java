import java.io.BufferedReader;
import java.io.FileReader;

public class main {
	public static void main(String[] args) {
		
		System.out.println("INTERPRETE LISP");
		
		String[] Program = Tokenizer();
		
		for (int i = 0; i < Program.length; i++) {
			System.out.println("|||" + Program[i]);
		}
		
	}
	
	public static String[] Tokenizer() {
		
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
		
		CompleteLine = CompleteLine.replaceAll("\\s","");
		
		String[] List = CompleteLine.split(""); 
	
		return List;
	}
}
