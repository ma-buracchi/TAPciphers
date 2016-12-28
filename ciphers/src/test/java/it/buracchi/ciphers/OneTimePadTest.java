package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OneTimePadTest {
	
	private OneTimePad otp;

	@Before
	public void setUp() {
		otp = new OneTimePad("test");
	}

	@Test
	public void testKeyAutoCreation() {
		otp.getKey();
	}

}
