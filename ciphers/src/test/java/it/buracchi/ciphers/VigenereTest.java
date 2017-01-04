package it.buracchi.ciphers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class VigenereTest {

	private Vigenere vigenere;
	private Parser parser;

	@Before
	public void setup() {
		parser = mock(Parser.class);
	}

	@Test
	public void testKeyExtension() {
		when(parser.process("test")).thenReturn("test");
		when(parser.process("testmessage")).thenReturn("testmessage");
		vigenere = new Vigenere(parser, "test");
		vigenere.coding("testmessage");
		assertEquals("testtesttest", vigenere.getKey());
	}

	@Test
	public void testKeyWithSpecialCharacters() {
		when(parser.process("t<e!s{t")).thenReturn("test");
		when(parser.process("testmessage")).thenReturn("testmessage");
		vigenere = new Vigenere(parser, "t<e!s{t");
		vigenere.coding("testmessage");
		assertEquals("testtesttest", vigenere.getKey());
	}

	@Test
	public void testKeyWithUppercaseCharacters() {
		when(parser.process("tESt")).thenReturn("test");
		when(parser.process("testmessage")).thenReturn("testmessage");
		vigenere = new Vigenere(parser, "tESt");
		vigenere.coding("testmessage");
		assertEquals("testtesttest", vigenere.getKey());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyKey() {
		when(parser.process("")).thenReturn("");
		when(parser.process("testmessage")).thenReturn("testmessage");
		vigenere = new Vigenere(parser, "");
		vigenere.coding("testmessage");
	}

	@Test
	public void testCoding() {
		when(parser.process("test")).thenReturn("test");
		when(parser.process("testmessage")).thenReturn("testmessage");
		vigenere = new Vigenere(parser, "test");
		assertEquals("mikmfikltkw", vigenere.coding("testmessage"));
	}

	@Test
	public void testCodingEmptyString() {
		when(parser.process("test")).thenReturn("test");
		when(parser.process("")).thenReturn("");
		vigenere = new Vigenere(parser, "test");
		assertEquals("", vigenere.coding(""));
	}

	@Test
	public void testDecoding() {
		when(parser.process("test")).thenReturn("test");
		when(parser.process("mikmfikltkw")).thenReturn("mikmfikltkw");
		vigenere = new Vigenere(parser, "test");
		assertEquals("testmessage", vigenere.decoding("mikmfikltkw"));
	}

	@Test
	public void testDecodingEmptyString() {
		when(parser.process("test")).thenReturn("test");
		when(parser.process("")).thenReturn("");
		vigenere = new Vigenere(parser, "test");
		assertEquals("", vigenere.decoding(""));
	}

}
