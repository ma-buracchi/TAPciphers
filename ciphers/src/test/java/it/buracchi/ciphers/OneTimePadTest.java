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
		otp = new OneTimePad(parser);
		assertNotNull(otp.createKey("test".length()));
	}

	@Test
	public void testCreatedKeyLength() {
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
		assertEquals("00011", otp.coding("c", key));
	}
	
	@Test
	public void testLongCoding() {
		when(parser.process("cg")).thenReturn("cg");
		when(parser.process("0000100110")).thenReturn("0000100110");
		when(parser.checkKey("0000100110",10)).thenReturn("0000100110");
		String key = "0000100110";
		otp = new OneTimePad(parser);
		assertEquals("0001100000", otp.coding("cg", key));
	}
	
	@Test
	public void testDecoding() {
		when(parser.process("00011")).thenReturn("00011");
		when(parser.process("00001")).thenReturn("00001");
		String key = "00001";
		otp = new OneTimePad(parser);
		assertEquals("c", otp.decoding("00011", key));
	}
	
	@Test
	public void testLongDecoding() {
		when(parser.process("0001100000")).thenReturn("0001100000");
		when(parser.process("0000100110")).thenReturn("0000100110");
		String key = "0000100110";
		otp = new OneTimePad(parser);
		assertEquals("cg", otp.decoding("0001100000", key));
	}

}
