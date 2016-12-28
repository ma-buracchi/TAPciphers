package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VigenereTest {

	private Vigenere vigenere;
	
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
		assertEquals("mikmfikltkw", vigenere.code());
	}
	
	@Test
	public void testCodingStrangeString() {
		vigenere = new Vigenere("test","a strange string with spaces,UPPERCASE, spaces and sp3c1al characters!!");
		assertEquals("twlktryxlxjbgkobmlkitgwlnthxkgslxwhtviktghkivedvaejtvxwkl", vigenere.code());
	}
	
	@Test
	public void testDecoding() {
		vigenere = new Vigenere("test","mikmfikltkw");
		assertEquals("testmessage", vigenere.decode());
	}
	
	@Test
	public void testDecodingStrangeString() {
		vigenere = new Vigenere("test","twlktryxlxjbgkobmlkitgwlnthxkgslxwhtviktghkivedvaejtvxwkl");
		assertEquals("astrangestringwithspacesuppercasespacesandspcalcharacters", vigenere.decode());
	}
	
	

}
