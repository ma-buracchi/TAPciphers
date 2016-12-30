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
		assertEquals("test".length(), otp.createKey("test".length()).length()/CHARACTER_LENGTH_IN_BIT);
	}
	
	@Test
	public void testAutomaticKeyCreation() {
		when(parser.process("test")).thenReturn("test");
		otp = new OneTimePad(parser);
		otp.code("test");
		assertNotNull(otp.getKey());
	}

	@Test
	public void testAutomaticCreatedKeyLength() {
		when(parser.process("test")).thenReturn("test");
		otp = new OneTimePad(parser);
		otp.code("test");
		assertEquals("test".length(), otp.getKey().length()/CHARACTER_LENGTH_IN_BIT);
	}

	@Test
	public void testPassingKey() {
		when(parser.process("test")).thenReturn("test");
		when(parser.process("00000011110110101100")).thenReturn("00000011110110101100");
		otp = new OneTimePad(parser, "00000011110110101100");
		otp.code("test");
		assertEquals("00000011110110101100", otp.getKey());
	}

	@Test
	public void testCodingWithKey() {
		when(parser.process("c")).thenReturn("c");
		String key = "00001";
		otp = new OneTimePad(parser);
		otp.setKey(key);
		assertEquals("00011", otp.code("c"));
	}

}
