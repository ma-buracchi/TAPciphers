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
		assertEquals("ztlz", sub.code("test"));
	}

	@Test
	public void testCodingStrangeString() {
		when(parser.process("a strange string with spaces,UPPERCASE, spaces and sp3c1al characters!!"))
				.thenReturn("astrangestringwithspacesuppercasespacesandspcalcharacters");
		assertEquals("qlzkqfutlzkofuvozilhqetlxhhtkeqltlhqetlqfrlheqseiqkqeztkl",
				sub.code("a strange string with spaces,UPPERCASE, spaces and sp3c1al characters!!"));
	}

	@Test
	public void testCodingEmptyString() {
		when(parser.process("")).thenReturn("");
		assertEquals("", sub.code(""));
	}

	@Test
	public void testDecoding() {
		when(parser.process("ztlz")).thenReturn("ztlz");
		assertEquals("test", sub.decode("ztlz"));
	}

	@Test
	public void testDecodingStrangeString() {
		when(parser.process("qlzkqfutlzkofuvozilhqetlxhhtkeqltlhqetlqfrlheqseiqkqeztkl"))
				.thenReturn("qlzkqfutlzkofuvozilhqetlxhhtkeqltlhqetlqfrlheqseiqkqeztkl");
		assertEquals("astrangestringwithspacesuppercasespacesandspcalcharacters",
				sub.decode("qlzkqfutlzkofuvozilhqetlxhhtkeqltlhqetlqfrlheqseiqkqeztkl"));
	}

	@Test
	public void testDecodingEmptyString() {
		when(parser.process("")).thenReturn("");
		assertEquals("", sub.decode(""));
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
