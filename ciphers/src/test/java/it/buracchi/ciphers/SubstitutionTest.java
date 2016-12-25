package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SubstitutionTest {
	
	private Substitution sub;
	private String test;
	
	@Before
	public void setup(){
		sub = new Substitution();
		test = "test";
	}

	@Test
	public void testSubstitutionCodingZeroPosition() {
		assertEquals("test", sub.code(test, 0));
	}

}
