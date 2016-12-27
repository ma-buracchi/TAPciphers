package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class VigenereTest {

	Vigenere vigenere;

	@Before
	public void setUp() {
		vigenere = new Vigenere("test","testmessage");
	}

	@Test
	public void testKeyExtension() {
		assertEquals("testtesttest", vigenere.getKey());
	}

}
