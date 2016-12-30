package it.buracchi.ciphers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class OneTimePadTest {

	private OneTimePad otp;
	private Parser parser;

	@Before
	public void setup() {
		parser = mock(Parser.class);
	}

	@Test
	public void testRandomKeyAutoCreation() {
		when(parser.process("testmessage")).thenReturn("testmessage");
		otp = new OneTimePad(parser);
		otp.code("testmessage");
		assertNotEquals("", otp.getKey());
		
	}

	@Test
	public void testRandomAutoCreatedKeyLength() {
		when(parser.process("testmessage")).thenReturn("testmessage");
		otp = new OneTimePad(parser);
		otp.code("testmessage");
		assertEquals("testmessage".length(), otp.getKey().length());
	}
	
	@Test
	public void testPassingKey() {
		when(parser.process("test")).thenReturn("test");
		when(parser.process("00000011110110101100")).thenReturn("00000011110110101100");
		otp = new OneTimePad(parser, "00000011110110101100");
		otp.code("test");
		assertEquals("00000011110110101100", otp.getKey());
	}
	
	

}
