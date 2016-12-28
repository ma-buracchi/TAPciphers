package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Test;

public class OneTimePadTest {

	private OneTimePad otp;

	@Test
	public void testRandomKeyAutoCreation() {
		otp = new OneTimePad("testmessage");
		System.out.println(otp.getKey());
		assertNotEquals("", otp.getKey());
	}

	@Test
	public void testRandomAutoCreatedKeyLength() {
		String test = "testmessage";
		otp = new OneTimePad(test);
		System.out.println(otp.getKey());
		assert (otp.getKey().length() == test.length());
	}

}
