package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Test;

public class VigenereTest {

	private Vigenere vigenere;
	private boolean coding;
	private boolean decoding;

	@Test
	public void testKeyExtension() {
		vigenere = new Vigenere("test","testmessage");
		assertEquals("testtesttest", vigenere.getKey());
		coding = true;
		decoding = false;
	}
	
	@Test
	public void testCoding() {
		vigenere = new Vigenere("test","testmessage");
		assertEquals("mikmfikltkw", vigenere.code(coding));
	}
	
	@Test
	public void testDecoding() {
		vigenere = new Vigenere("test","mikmfikltkw");
		assertEquals("testmessage", vigenere.code(decoding));
	}

}
