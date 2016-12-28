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
	public void testCreation() {
		assertEquals("", shift.getMessage());
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
	
	@Test
	public void testShiftCodingEmptyString() {
		test = "";
		assertEquals("", shift.code(test, 1));
	}
	
	@Test
	public void testShiftCodingStrangeString() {
		test = "T3es T1!";
		assertEquals("test", shift.code(test, 0));
	}
	
	@Test
	public void testShiftDecodingZeroPosition() {
		assertEquals(test, shift.decode("test", 0));
	}
	
	@Test
	public void testShiftDecodingOnePosition() {
		assertEquals(test, shift.decode("uftu", 1));
	}
	
	@Test
	public void testShiftDecodingTwentySixPosition() {
		assertEquals(test, shift.decode("test", 26));
	}
	
	@Test
	public void testShiftDecodingTwentySevenPosition() {
		assertEquals(test, shift.decode("uftu", 27));
	}
	
	@Test
	public void testShiftDecodingNegativePosition() {
		assertEquals(test, shift.decode("sdrs", -1));
	}

}
