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
		im.process(test);
		assertEquals("test",test);
	}

	@Test(expected=IllegalArgumentException.class)
	public void testIllegalFirstCharacterInput() {
		test = ":test";
		im.process(test);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalLastCharacterInput() {
		test = "test:";
		im.process(test);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testIllegalMiddleCharacterInput() {
		test = "te:st";
		im.process(test);
	}

}
