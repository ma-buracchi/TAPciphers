package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ShiftTest {

	private Shift shift;
	private String test;
	boolean coding;
	boolean decoding;

	@Before
	public void setup() {
		shift = new Shift();
		test = "test";
		coding = true;
		decoding = false;
	}

	@Test
	public void testShiftCodingZeroPosition() {
		assertEquals("test", shift.code(test, 0, coding));
	}

	@Test
	public void testShiftCodingOnePosition() {
		assertEquals("uftu", shift.code(test, 1, coding));
	}

	@Test
	public void testShiftCodingTwentySixPosition() {
		assertEquals("test", shift.code(test, 26, coding));
	}

	@Test
	public void testShiftCodingTwentySevenPosition() {
		assertEquals("uftu", shift.code(test, 27, coding));
	}

	@Test
	public void testShiftCodingNegativePosition() {
		assertEquals("sdrs", shift.code(test, -1, coding));
	}
	
	@Test
	public void testShiftDecodingZeroPosition() {
		assertEquals(test, shift.code("test", 0, decoding));
	}
	
	@Test
	public void testShiftDecodingOnePosition() {
		assertEquals(test, shift.code("uftu", 1, decoding));
	}
	
	@Test
	public void testShiftDecodingTwentySixPosition() {
		assertEquals(test, shift.code("test", 26, decoding));
	}
	
	@Test
	public void testShiftDecodingTwentySevenPosition() {
		assertEquals(test, shift.code("uftu", 27, decoding));
	}
	
	@Test
	public void testShiftDecodingNegativePosition() {
		assertEquals(test, shift.code("sdrs", -1, decoding));
	}

}
