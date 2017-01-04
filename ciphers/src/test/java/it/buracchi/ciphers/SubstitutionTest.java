package it.buracchi.ciphers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class SubstitutionTest {

	private Substitution sub;
	private Parser parser;
	private String newAlphabet;

	@Before
	public void setup() {
		parser = mock(Parser.class);
		newAlphabet = "qwertyuiopasdfghjklzxcvbnm";
		when(parser.checkAlphabet(newAlphabet)).thenReturn(newAlphabet);
		sub = new Substitution(parser, newAlphabet);
	}

	@Test
	public void testCoding() {
		when(parser.process("test")).thenReturn("test");
		assertEquals("ztlz", sub.coding("test"));
	}

	@Test
	public void testCodingEmptyString() {
		when(parser.process("")).thenReturn("");
		assertEquals("", sub.coding(""));
	}

	@Test
	public void testDecoding() {
		when(parser.process("ztlz")).thenReturn("ztlz");
		assertEquals("test", sub.decoding("ztlz"));
	}

	@Test
	public void testDecodingEmptyString() {
		when(parser.process("")).thenReturn("");
		assertEquals("", sub.decoding(""));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNewAlphabetShorterThenTwentySixLetters() {
		newAlphabet = "qwertyuiopasdfghj";
		when(parser.checkAlphabet(newAlphabet)).thenThrow(new IllegalArgumentException());
		sub = new Substitution(parser, newAlphabet);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNewAlphabetLongerThenTwentySixLetters() {
		newAlphabet = "qwertyuiopasdfghjklzxcvbnmqwerty";
		when(parser.checkAlphabet(newAlphabet)).thenThrow(new IllegalArgumentException());
		sub = new Substitution(parser, newAlphabet);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNewAlphabetWithIllegalCharacter() {
		newAlphabet = "qwertyuiopa?dfghjklzxcvbnm";
		when(parser.checkAlphabet(newAlphabet)).thenThrow(new IllegalArgumentException());
		sub = new Substitution(parser, newAlphabet);
	}

}
