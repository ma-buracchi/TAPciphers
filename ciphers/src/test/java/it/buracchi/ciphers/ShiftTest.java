package it.buracchi.ciphers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class ShiftTest {

	private Shift shift;
	private String test;
	private Parser parser;
	
	@Before
	public void setup() {
		parser = mock(Parser.class);
		shift = new Shift(parser);
	}
	
	@Test
	public void testCreation() {
		test = "test";
		assertEquals("", shift.getMessage());
	}

	@Test
	public void testShiftCodingZeroPosition() {
		test = "test";
		when(parser.process(test)).thenReturn("test");
		assertEquals(test, shift.code(test, 0));
	}

	@Test
	public void testShiftCodingOnePosition() {
		test = "test";
		when(parser.process(test)).thenReturn("test");
		assertEquals("uftu", shift.code(test, 1));
	}

	@Test
	public void testShiftCodingTwentySixPosition() {
		test = "test";
		when(parser.process(test)).thenReturn("test");
		assertEquals("test", shift.code(test, 26));
	}

	@Test
	public void testShiftCodingTwentySevenPosition() {
		test = "uftu";
		when(parser.process(test)).thenReturn("uftu");
		assertEquals(test, shift.code(test, 27));
	}

	@Test
	public void testShiftCodingNegativePosition() {
		test = "sdrs";
		when(parser.process("sdrs")).thenReturn("sdrs");
		assertEquals(test, shift.code(test, -1));
	}
	
	@Test
	public void testShiftCodingEmptyString() {
		test = "";
		when(parser.process(test)).thenReturn("");
		assertEquals(test, shift.code(test, 1));
	}
	
	@Test
	public void testShiftCodingStrangeString() {
		test = "T3es T1!";
		when(parser.process(test)).thenReturn("test");
		assertEquals("test", shift.code(test, 0));
	}
	
	@Test
	public void testShiftDecodingZeroPosition() {
		test = "test";
		when(parser.process(test)).thenReturn("test");
		assertEquals(test, shift.decode("test", 0));
	}
	
	@Test
	public void testShiftDecodingOnePosition() {
		test = "test";
		when(parser.process("uftu")).thenReturn("uftu");
		assertEquals(test, shift.decode("uftu", 1));
	}
	
	@Test
	public void testShiftDecodingTwentySixPosition() {
		test = "test";
		when(parser.process("test")).thenReturn("test");
		assertEquals(test, shift.decode("test", 26));
	}
	
	@Test
	public void testShiftDecodingTwentySevenPosition() {
		test = "test";
		when(parser.process("uftu")).thenReturn("uftu");
		assertEquals(test, shift.decode("uftu", 27));
	}
	
	@Test
	public void testShiftDecodingNegativePosition() {
		test = "test";
		when(parser.process("sdrs")).thenReturn("sdrs");
		assertEquals(test, shift.decode("sdrs", -1));
	}
	
	@Test
	public void testShiftDecodingEmptyString() {
		test = "";
		when(parser.process("")).thenReturn("");
		assertEquals(test, shift.code("", 1));
	}
	
	@Test
	public void testShiftDecodingStrangeString() {
		test = "T3es T1!";
		when(parser.process("T3es T1!")).thenReturn("test");
		assertEquals("test", shift.code(test, 0));
	}

}
