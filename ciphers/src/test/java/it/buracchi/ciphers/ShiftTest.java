package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShiftTest {

	private Shift shift;

	@Before
	public void setup() {
		shift = new Shift();
	}

	@Test
	public void testShiftCodingZeroPosition() {
		String test = "test";
		assertEquals(test,shift.code(test, 0));
	}

}
