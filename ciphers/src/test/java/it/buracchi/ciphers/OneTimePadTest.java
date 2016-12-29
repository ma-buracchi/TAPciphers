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
		when(parser.process("")).thenReturn("");
		otp = new OneTimePad(parser, "");
		otp.code("testmessage");
		assertNotEquals("", otp.getKey());
		
	}

	@Test
	public void testRandomAutoCreatedKeyLength() {
		when(parser.process("testmessage")).thenReturn("testmessage");
		when(parser.process("")).thenReturn("");
		otp = new OneTimePad(parser, "");
		otp.code("testmessage");
		assertEquals(otp.getKey().length(), "testmessage".length());
	}

}
