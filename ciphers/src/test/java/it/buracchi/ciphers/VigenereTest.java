package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Test;

public class VigenereTest {

	Vigenere vigenere;

	@Test
	public void testKeyExtension() {
		vigenere = new Vigenere("test","testmessage");
		assertEquals("testtesttest", vigenere.getKey());
	}
	
	@Test
	public void testCoding() {
		vigenere = new Vigenere("test","testmessage");
		assertEquals("mikmfikltkw", vigenere.code(true));
	}
	
	@Test
	public void testDecoding() {
		vigenere = new Vigenere("test","mikmfikltkw");
		assertEquals("testmessage", vigenere.code(false));
	}

}
