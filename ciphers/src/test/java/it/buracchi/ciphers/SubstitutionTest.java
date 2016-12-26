package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SubstitutionTest {

	private Substitution sub;
	private String test;
	private String newAlphabet;

	@Before
	public void setup() {
		newAlphabet = "qwertyuiopasdfghjklzxcvbnm";
		sub = new Substitution(newAlphabet);
	}

	@Test
	public void testCoding() {
		test = "test";
		assertEquals("ztlz", sub.code(test));
	}

	@Test
	public void testCodingStrangeString() {
		test = "a strange string with spaces,UPPERCASE, spaces and sp3c1al characters!!";
		assertEquals("qlzkqfutlzkofuvozilhqetlxhhtkeqltlhqetlqfrlheqseiqkqeztkl", sub.code(test));
	}

}
