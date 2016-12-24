package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShiftTest {

	private Shift shift;
	private String test;

	@Before
	public void setup() {
		shift = new Shift();
		test = "test";
	}

	@Test
	public void testShiftCodingZeroPosition() {
		assertEquals("test", shift.code(test, 0));
	}

	@Test
	public void testShiftCodingOnePosition() {
		assertEquals("uftu", shift.code(test, 1));
	}

	@Test
	public void testShiftCodingTwentySixPosition() {
		assertEquals("test", shift.code(test, 26));
	}

	@Test
	public void testShiftCodingTwentySevenPosition() {
		assertEquals("uftu", shift.code(test, 27));
	}

	@Test
	public void testShiftCodingNegativePosition() {
		assertEquals("sdrs", shift.code(test, -1));
	}

}
