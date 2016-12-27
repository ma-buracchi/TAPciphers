package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SubstitutionTest {

	private Substitution sub;
	private String test;
	private String newAlphabet;
	private boolean coding;
	private boolean decoding;

	@Before
	public void setup() {
		newAlphabet = "qwertyuiopasdfghjklzxcvbnm";
		sub = new Substitution(newAlphabet);
		coding = true;
		decoding = false;
	}

	@Test
	public void testCoding() {
		test = "test";
		assertEquals("ztlz", sub.code(test,coding));
	}

	@Test
	public void testCodingStrangeString() {
		test = "a strange string with spaces,UPPERCASE, spaces and sp3c1al characters!!";
		assertEquals("qlzkqfutlzkofuvozilhqetlxhhtkeqltlhqetlqfrlheqseiqkqeztkl", sub.code(test,coding));
	}
	
	@Test
	public void testDecoding() {
		test = "ztlz";
		assertEquals("test", sub.code(test,decoding));
	}

	@Test
	public void testDecodingStrangeString() {
		test = "qlzkqfutlzkofuvozilhqetlxhhtkeqltlhqetlqfrlheqseiqkqeztkl";
		assertEquals("astrangestringwithspacesuppercasespacesandspcalcharacters", sub.code(test,decoding));
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNewAlphabetShorterThenTwentySixLetters() {
		newAlphabet = "qwertyuiopasdfghj";
		sub = new Substitution(newAlphabet);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNewAlphabetLongerThenTwentySixLetters() {
		newAlphabet = "qwertyuiopasdfghjklzxcvbnmqwerty";
		sub = new Substitution(newAlphabet);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testNewAlphabetWithIllegalCharacter() {
		newAlphabet = "qwertyuiopa?dfghjklzxcvbnm";
		sub = new Substitution(newAlphabet);
	}
	
}
