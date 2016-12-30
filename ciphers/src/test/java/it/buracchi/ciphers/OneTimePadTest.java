package it.buracchi.ciphers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class OneTimePadTest {

	private OneTimePad otp;
	private Parser parser;
	public static final int CHARACTER_LENGTH_IN_BIT = 5;

	@Before
	public void setup() {
		parser = mock(Parser.class);
	}

	@Test
	public void testKeyCreation() {
		when(parser.process("test")).thenReturn("test");
		otp = new OneTimePad(parser);
		assertNotNull(otp.createKey("test".length()));
	}

	@Test
	public void testCreatedKeyLength() {
		when(parser.process("test")).thenReturn("test");
		otp = new OneTimePad(parser);
		assertEquals("test".length(), otp.createKey("test".length()).length() / CHARACTER_LENGTH_IN_BIT);
	}

	@Test
	public void testCoding() {
		when(parser.process("c")).thenReturn("c");
		when(parser.process("00001")).thenReturn("00001");
		when(parser.checkKey("00001",5)).thenReturn("00001");
		String key = "00001";
		otp = new OneTimePad(parser);
		assertEquals("00011", otp.code("c", key));
	}
	
	@Test
	public void testDecoding() {
		when(parser.process("00011")).thenReturn("00011");
		when(parser.process("00001")).thenReturn("00001");
		String key = "00001";
		otp = new OneTimePad(parser);
		assertEquals("c", otp.decode("00011", key));
	}

}
