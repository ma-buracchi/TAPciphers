package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class InputManagerTest {

	private InputManager im;
	private String test;

	@Before
	public void setup() {
		im = new InputManager();
		test = "";
	}

	@Test
	public void testStringOk() {
		test = "test";
		assertEquals("test", im.process(test));
	}

	@Test
	public void testIllegalCharacterInput() {
		test = "te:st";
		assertEquals("test", im.process(test));
	}

	@Test
	public void testInputWithSpaces() {
		test = "te st ";
		assertEquals("test", im.process(test));
	}

	@Test
	public void testInputWithUppercase() {
		test = "tEsT";
		assertEquals("test", im.process(test));
	}
	
	@Test
	public void testCheckAlphabet() {
		test = "qwertyuiopasdfghjklzxcvbnm";
		assertEquals(test, im.checkAlphabet(test));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCheckAlphabetLongerThenTwentysixCharacters() {
		test = "qwertyuiopasdfghjklzxcvbnmq";
		im.checkAlphabet(test);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCheckAlphabetShorterThenTwentysixCharacters() {
		test = "qwertyuiopasdfghjklzxcvbn";
		im.checkAlphabet(test);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCheckAlphabetWithIllegalCharacterLowerThenASCII65() {
		test = "qwertyuiopa!dfghjklzxcvbnm";
		im.checkAlphabet(test);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCheckAlphabetWithIllegalCharacterHigherThenASCII122() {
		test = "qwertyuiopa}dfghjklzxcvbnm";
		im.checkAlphabet(test);
	}

}
