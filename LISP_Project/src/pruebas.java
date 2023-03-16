

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import junit.framework.TestCase;

public class pruebas extends TestCase{

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
	        tokenList1.add(new Token<String>("OPEN_PAR" , "("));
	        tokenList1.add(new Token<String>("NUMBER", "1"));
	        tokenList1.add(new Token<String>("NUMBER", "2"));
	        tokenList1.add(new Token<String>("CLOSE_PAR", ")"));
	        Token result1 = defunEval.Evaluate(tokenList1);
	        assertEquals(new Token<String>("NUMBER", "2").getValue(), result1.getValue());
	        
	        ArrayList<Token> tokenList2 = new ArrayList<>();
	        tokenList2.add(new Token<String>( "OPEN_PAR" , "("));
	        tokenList2.add(new Token<String>( "NUMBER" , "3"));
	        tokenList2.add(new Token<String>( "NUMBER", "4"));
	        tokenList2.add(new Token<String>( "NUMBER", "5"));
	        tokenList2.add(new Token<String>( "CLOSE_PAR", ")"));
	        Token result2 = defunEval.Evaluate(tokenList2);
	        assertEquals(new Token<String>( "NUMBER", "5").getValue(), result2.getValue());
	    }
	    
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
	    

	    private final LISPOperations operator = new LISPOperations();
	    private final Tokenizer tokenizer = new Tokenizer();
	    private final HashMap<String, Method> createdMethods = new HashMap<>();
	    String[] input = { "+", "2", "3"};
	    // The evaluator never has open or closed parenthesis, just complete expressions
	    @Test
	    public void testEvaluateExpression() {
	        ArrayList<Token> expression = tokenizer.StringToTokens(input);
	        Token result = new LISPEvaluator().evaluateExpression(expression, operator, tokenizer, createdMethods);
	        assertEquals(result.getValue(), 5f);
	    }
	    
	    String[] input2 = { "=", "2", "3"};
	    @Test
	    public void testConditionals() {
	    	ArrayList<Token> expression = tokenizer.StringToTokens(input2);
	    	Token result2 = new LISPEvaluator().evaluateExpression(expression, operator, tokenizer, createdMethods);
	    	System.out.println("Result: " + result2.getValue());
	    	assertEquals(result2.getValue(), false);
	    	
	    }
	    
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












