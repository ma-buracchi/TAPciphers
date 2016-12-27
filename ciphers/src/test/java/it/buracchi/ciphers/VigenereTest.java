package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VigenereTest {

	private Vigenere vigenere;
	private boolean coding;
	private boolean decoding;
	
	@Before
	public void setup(){
		coding = true;
		decoding = false;
	}

	@Test
	public void testKeyExtension() {
		vigenere = new Vigenere("test","testmessage");
		assertEquals("testtesttest", vigenere.getKey());
	}
	
	@Test
	public void testKeyWithSpecialCharacters() {
		vigenere = new Vigenere("t<e!s{t","testmessage");
		assertEquals("testtesttest", vigenere.getKey());
	}
	
	@Test
	public void testKeyWithUppercaseCharacters() {
		vigenere = new Vigenere("tESt","testmessage");
		assertEquals("testtesttest", vigenere.getKey());
	}
	
	@Test
	public void testCoding() {
		vigenere = new Vigenere("test","testmessage");
		assertEquals("mikmfikltkw", vigenere.code(coding));
	}
	
	@Test
	public void testCodingStrangeString() {
		vigenere = new Vigenere("test","a strange string with spaces,UPPERCASE, spaces and sp3c1al characters!!");
		assertEquals("twlktryxlxjbgkobmlkitgwlnthxkgslxwhtviktghkivedvaejtvxwkl", vigenere.code(coding));
	}
	
	@Test
	public void testDecoding() {
		vigenere = new Vigenere("test","mikmfikltkw");
		assertEquals("testmessage", vigenere.code(decoding));
	}
	
	@Test
	public void testDecodingStrangeString() {
		vigenere = new Vigenere("test","twlktryxlxjbgkobmlkitgwlnthxkgslxwhtviktghkivedvaejtvxwkl");
		assertEquals("astrangestringwithspacesuppercasespacesandspcalcharacters", vigenere.code(decoding));
	}
	
	

}
