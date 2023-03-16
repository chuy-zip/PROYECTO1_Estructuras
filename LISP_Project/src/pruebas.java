
public class pruebas {
	
	public class DefunEvalTest extends TestCase {

	    private DefunEval defunEval;
	    
	    protected void setUp() {
	        defunEval = new DefunEval();
	    }
	    
	    protected void tearDown() {
	        defunEval = null;
	    }
	    
	    @Test
	    public void testEvaluate() {
	        ArrayList<Token> tokenList1 = new ArrayList<>();
	        tokenList1.add(new Token<String>(Tokenizer.OPEN_PAR, "("));
	        tokenList1.add(new Token<String>(Tokenizer.NUMBER, "1"));
	        tokenList1.add(new Token<String>(Tokenizer.NUMBER, "2"));
	        tokenList1.add(new Token<String>(Tokenizer.CLOSE_PAR, ")"));
	        Token result1 = defunEval.Evaluate(tokenList1);
	        assertEquals(new Token<String>(Tokenizer.NUMBER, "2"), result1);
	        
	        ArrayList<Token> tokenList2 = new ArrayList<>();
	        tokenList2.add(new Token<String>(Tokenizer.OPEN_PAR, "("));
	        tokenList2.add(new Token<String>(Tokenizer.NUMBER, "3"));
	        tokenList2.add(new Token<String>(Tokenizer.NUMBER, "4"));
	        tokenList2.add(new Token<String>(Tokenizer.NUMBER, "5"));
	        tokenList2.add(new Token<String>(Tokenizer.CLOSE_PAR, ")"));
	        Token result2 = defunEval.Evaluate(tokenList2);
	        assertEquals(new Token<String>(Tokenizer.NUMBER, "5"), result2);
	    }
	}

	import org.junit.Test;
	import static org.junit.Assert.*;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Stack;

	public class LISPEvaluatorTest {

	    private final LISPOperations operator = new LISPOperations();
	    private final Tokenizer tokenizer = new Tokenizer();
	    private final HashMap<String, Method> createdMethods = new HashMap<>();

	    @Test
	    public void testEvaluateExpression() {
	        ArrayList<Token> expression = tokenizer.tokenize("(+ 2 3)");
	        Token result = new LISPEvaluator().evaluateExpression(expression, operator, tokenizer, createdMethods);
	        assertEquals(result.getValue(), 5f);
	    }
	}

	import org.junit.Test;
	import static org.junit.Assert.assertEquals;

	public class LISPOperationsTest {

	    private final LISPOperations lispOperations = new LISPOperations();
	    private final float DELTA = 0.0001f; // Error maximo permitido

	    @Test
	    public void testAdd() {
	        Token<Float> num1 = new Token<>("NUMBER", 3.5f);
	        Token<Float> num2 = new Token<>("NUMBER", 2.0f);
	        Token<Float> result = lispOperations.Add(num1, num2);
	        assertEquals(5.5f, result.getValue(), DELTA);
	    }

	    @Test
	    public void testSubtract() {
	        Token<Float> num1 = new Token<>("NUMBER", 3.5f);
	        Token<Float> num2 = new Token<>("NUMBER", 2.0f);
	        Token<Float> result = lispOperations.Subtract(num1, num2);
	        assertEquals(1.5f, result.getValue(), DELTA);
	    }

	    @Test
	    public void testDivide() {
	        Token<Float> num1 = new Token<>("NUMBER", 3.5f);
	        Token<Float> num2 = new Token<>("NUMBER", 2.0f);
	        Token<Float> result = lispOperations.Divide(num1, num2);
	        assertEquals(1.75f, result.getValue(), DELTA);
	    }

	    @Test
	    public void testMultiply() {
	        Token<Float> num1 = new Token<>("NUMBER", 3.5f);
	        Token<Float> num2 = new Token<>("NUMBER", 2.0f);
	        Token<Float> result = lispOperations.Multiply(num1, num2);
	        assertEquals(7.0f, result.getValue(), DELTA);
	    }
	}

	import static org.junit.Assert.assertEquals;

	import java.util.ArrayList;

	import org.junit.Before;
	import org.junit.Test;

	public class MethodTest {
		
		private Method method;
		private ArrayList<Token> parameters;
		private ArrayList<Token> code;
		private ArrayList<Token> givenParameters;
		
		@Before
		public void setUp() {
			method = new Method("testMethod");
			parameters = new ArrayList<Token>();
			code = new ArrayList<Token>();
			givenParameters = new ArrayList<Token>();
			
			parameters.add(new Token("int", "param1"));
			parameters.add(new Token("String", "param2"));
			
			code.add(new Token("int", "x"));
			code.add(new Token("String", "y"));
			code.add(new Token("x"));
			code.add(new Token("+"));
			code.add(new Token("y"));
			code.add(new Token("println"));
			
			givenParameters.add(new Token("5"));
			givenParameters.add(new Token("\"hello\""));
			
			method.setParameters(parameters);
			method.setCode(code);
			method.setGivenParameters(givenParameters);
		}
		
		@Test
		public void testReplaceParameters() {
			method.ReplaceParameters();
			
			ArrayList<Token> expectedCode = new ArrayList<Token>();
			expectedCode.add(new Token("int", "x"));
			expectedCode.add(new Token("String", "y"));
			expectedCode.add(new Token("param1"));
			expectedCode.add(new Token("+"));
			expectedCode.add(new Token("param2"));
			expectedCode.add(new Token("println"));
			
			assertEquals(expectedCode, method.getCode());
		}
		
		@Test
		public void testNoParameters() {
			method.setParameters(new ArrayList<Token>());
			method.ReplaceParameters();
			
			assertEquals(code, method.getCode());
		}
		
	}

	import static org.junit.jupiter.api.Assertions.*;

	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;

	class MethodParserTest {
		private MethodParser methodParser;
		
		@BeforeEach
		void setUp() {
			methodParser = new MethodParser();
		}
		
		@Test
		void testSameQtyOfParenthesisWhenEqualQty() {
			methodParser.setCloseParQTty(3);
			methodParser.setOpenParQty(3);
			
			assertTrue(methodParser.SameQtyOfParenthesis());
		}
		
		@Test
		void testSameQtyOfParenthesisWhenDifferentQty() {
			methodParser.setCloseParQTty(5);
			methodParser.setOpenParQty(3);
			
			assertFalse(methodParser.SameQtyOfParenthesis());
		}
		
		@Test
		void testResetCounters() {
			methodParser.setCloseParQTty(5);
			methodParser.setOpenParQty(3);
			
			methodParser.ResetCounters();
			
			assertEquals(0, methodParser.getCloseParQTty());
			assertEquals(0, methodParser.getOpenParQty());
		}
	}

	import static org.junit.Assert.*;

	import org.junit.Test;

	public class SetQTest {

	    @Test
	    public void testSetAndGet() {
	        SetQ<String, Integer> setq = new SetQ<>();
	        setq.setq("a", 1);
	        setq.setq("b", 2);
	        setq.setq("c", 3);
	        assertEquals(Integer.valueOf(1), setq.get("a"));
	        assertEquals(Integer.valueOf(2), setq.get("b"));
	        assertEquals(Integer.valueOf(3), setq.get("c"));
	    }

	    @Test
	    public void testOverrideValue() {
	        SetQ<String, Integer> setq = new SetQ<>();
	        setq.setq("a", 1);
	        setq.setq("a", 2);
	        assertEquals(Integer.valueOf(2), setq.get("a"));
	    }

	    @Test
	    public void testGetNonexistentKey() {
	        SetQ<String, Integer> setq = new SetQ<>();
	        assertNull(setq.get("nonexistent"));
	    }

	}

	import static org.junit.Assert.assertEquals;

	import org.junit.Test;

	public class TokenTest {
	    
	    @Test
	    public void testGetSetTokenType() {
	        Token<Integer> token = new Token<>("number", 42);
	        assertEquals("number", token.getTokenType());
	        token.setTokenType("int");
	        assertEquals("int", token.getTokenType());
	    }
	    
	    @Test
	    public void testGetSetValue() {
	        Token<String> token = new Token<>("string", "hello");
	        assertEquals("hello", token.getValue());
	        token.setValue("world");
	        assertEquals("world", token.getValue());
	    }
	}

	import java.util.ArrayList;

	public class TokenizerTest {

	    public static void main(String[] args) {

	        Tokenizer tokenizer = new Tokenizer();

	        // Crear la lista de tokens esperados
	        ArrayList<Token> expectedTokens = new ArrayList<>();
	        expectedTokens.add(new Token<>(Tokenizer.OPEN_PAR, "("));
	        expectedTokens.add(new Token<>(Tokenizer.ATOM, "atom"));
	        expectedTokens.add(new Token<>(Tokenizer.STRING, "test"));
	        expectedTokens.add(new Token<>(Tokenizer.NUMBER, 123.45f));
	        expectedTokens.add(new Token<>(Tokenizer.CLOSE_PAR, ")"));

	        // Crear la lista de strings de entrada
	        String[] input = {"(", "atom", "test", "123.45", ")", "extra"};

	        // Llamar al metodo StringToTokens y guardar el resultado
	        ArrayList<Token> generatedTokens = tokenizer.StringToTokens(input);

	        // Comparar los tokens generados con los esperados
	        if (expectedTokens.equals(generatedTokens)) {
	            System.out.println("La prueba unitaria fue exitosa.");
	        } else {
	            System.out.println("La prueba unitaria fallo.");
	            for (int i = 0; i < expectedTokens.size(); i++) {
	                if (!expectedTokens.get(i).equals(generatedTokens.get(i))) {
	                    System.out.println("Token esperado: " + expectedTokens.get(i));
	                    System.out.println("Token generado: " + generatedTokens.get(i));
	                }
	            }
	        }
	    }
	}

	@Test
	public void testStringToTokens() {
	    String program = "(defun factorial (n) (if (<= n 1) 1 (* n (factorial (- n 1)))))";
	    Tokenizer tokenizer = new Tokenizer();
	    ArrayList<Token> tokens = tokenizer.StringToTokens(new String[]{program});
	    assertEquals(19, tokens.size());
	    assertEquals(Tokenizer.OPEN_PAR, tokens.get(0).getTokenType());
	    assertEquals(Tokenizer.DEFUN, tokens.get(1).getTokenType());
	    assertEquals(Tokenizer.VARIABLE, tokens.get(2).getTokenType());
	    assertEquals("factorial", tokens.get(2).getValue());
	    assertEquals(Tokenizer.OPEN_PAR, tokens.get(3).getTokenType());
	    assertEquals(Tokenizer.VARIABLE, tokens.get(4).getTokenType());
	    assertEquals("n", tokens.get(4).getValue());
	    assertEquals(Tokenizer.CLOSE_PAR, tokens.get(5).getTokenType());
	    assertEquals(Tokenizer.OPEN_PAR, tokens.get(6).getTokenType());
	    assertEquals(Tokenizer.IF, tokens.get(7).getTokenType());
	    assertEquals(Tokenizer.OPEN_PAR, tokens.get(8).getTokenType());
	    assertEquals(Tokenizer.LESS_OR_EQUAL, tokens.get(9).getTokenType());
	    assertEquals(Tokenizer.VARIABLE, tokens.get(10).getTokenType());
	    assertEquals("n", tokens.get(10).getValue());
	    assertEquals(Tokenizer.NUMBER, tokens.get(11).getTokenType());
	    assertEquals(1, tokens.get(11).getValue());
	    assertEquals(Tokenizer.CLOSE_PAR, tokens.get(12).getTokenType());
	    assertEquals(1, tokens.get(13).getValue());
	    assertEquals(Tokenizer.OPEN_PAR, tokens.get(14).getTokenType());
	    assertEquals(Tokenizer.TIMES, tokens.get(15).getTokenType());
	    assertEquals(Tokenizer.VARIABLE, tokens.get(16).getTokenType());
	    assertEquals("n", tokens.get(16).getValue());
	    assertEquals(Tokenizer.OPEN_PAR, tokens.get(17).getTokenType());
	    assertEquals(Tokenizer.VARIABLE, tokens.get(18).getTokenType());
	    assertEquals("-", tokens.get(18).getValue());
	}


}
