import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class DefunMethodTests {
	
	private MethodParser methodParser;
	
	@Before
	public void setUp() {
		methodParser = new MethodParser();
	}
	
	@Test
	public void testSameQtyOfParenthesisWhenEqualQty() {
		methodParser.setCloseParQTty(3);
		methodParser.setOpenParQty(3);
		
		assertTrue(methodParser.SameQtyOfParenthesis());
	}
	
	@Test
	public void testSameQtyOfParenthesisWhenDifferentQty() {
		methodParser.setCloseParQTty(5);
		methodParser.setOpenParQty(3);
		
		assertFalse(methodParser.SameQtyOfParenthesis());
	}
	
	@Test
	public void testResetCounters() {
		methodParser.setCloseParQTty(5);
		methodParser.setOpenParQty(3);
		
		methodParser.ResetCounters();
		
		assertEquals(0, methodParser.getCloseParQTty());
		assertEquals(0, methodParser.getOpenParQty());
	}
	
	private Method method;
	private ArrayList<Token> parameters;
	private ArrayList<Token> code;
	private ArrayList<Token> givenParameters;
	
	@Before
	public void setUp2() {
		method = new Method("testMethod");
		parameters = new ArrayList<Token>();
		code = new ArrayList<Token>();
		givenParameters = new ArrayList<Token>();
		
		parameters.add(new Token("STRING", "x"));
		parameters.add(new Token("STRING", "y"));
		
		code.add(new Token("OPEN_PAR", "("));
		code.add(new Token("STRING", "x"));
		code.add(new Token("STRING", "y"));
		code.add(new Token("OPEN_PAR", ")"));

		
		givenParameters.add(new Token("NUMBER", 5));
		givenParameters.add(new Token("NUMBER", 3));
		
		method.setParameters(parameters);
		method.setCode(code);
		method.setGivenParameters(givenParameters);
	}
	
	@Test
	public void testReplaceParameters() {
		method.ReplaceParameters();
		
		ArrayList<Token> expectedCode = new ArrayList<Token>();
		expectedCode.add(new Token("OPEN_PAR", "("));
		expectedCode.add(new Token("STRING", 5));
		expectedCode.add(new Token("STRING", 3));
		expectedCode.add(new Token("OPEN_PAR", ")"));
		
		assertEquals(expectedCode.get(1).getValue(), method.getCode().get(1).getValue());
	}
	
	@Test
	public void testNoParameters() {
		method.setParameters(new ArrayList<Token>());
		method.ReplaceParameters();
		
		assertEquals(code, method.getCode());
	}

	

}
