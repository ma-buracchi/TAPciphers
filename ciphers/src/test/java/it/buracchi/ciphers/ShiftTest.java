package it.buracchi.ciphers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class ShiftTest {

	private Shift shift;
	private Parser parser;
	
	@Before
	public void setup() {
		parser = mock(Parser.class);
		shift = new Shift(parser);
	}
	
	@Test
	public void testCreation() {
		assertEquals("", shift.getMessage());
	}

	@Test
	public void testShiftCodingZeroPosition() {
		when(parser.process("test")).thenReturn("test");
		assertEquals("test", shift.code("test", 0));
	}

	@Test
	public void testShiftCodingOnePosition() {
		when(parser.process("test")).thenReturn("test");
		assertEquals("uftu", shift.code("test", 1));
	}

	@Test
	public void testShiftCodingTwentySixPosition() {
		when(parser.process("test")).thenReturn("test");
		assertEquals("test", shift.code("test", 26));
	}

	@Test
	public void testShiftCodingTwentySevenPosition() {
		when(parser.process("test")).thenReturn("test");
		assertEquals("uftu", shift.code("test", 27));
	}

	@Test
	public void testShiftCodingNegativePosition() {
		when(parser.process("uftu")).thenReturn("uftu");
		assertEquals("test", shift.code("uftu", -1));
	}
	
	@Test
	public void testShiftCodingEmptyString() {
		when(parser.process("")).thenReturn("");
		assertEquals("", shift.code("", 1));
	}
	
	@Test
	public void testShiftCodingStrangeString() {
		when(parser.process("T3es T1!")).thenReturn("test");
		assertEquals("test", shift.code("T3es T1!", 0));
	}
	
	@Test
	public void testShiftDecodingZeroPosition() {
		when(parser.process("test")).thenReturn("test");
		assertEquals("test", shift.decode("test", 0));
	}
	
	@Test
	public void testShiftDecodingOnePosition() {
		when(parser.process("uftu")).thenReturn("uftu");
		assertEquals("test", shift.decode("uftu", 1));
	}
	
	@Test
	public void testShiftDecodingTwentySixPosition() {
		when(parser.process("test")).thenReturn("test");
		assertEquals("test", shift.decode("test", 26));
	}
	
	@Test
	public void testShiftDecodingTwentySevenPosition() {
		when(parser.process("uftu")).thenReturn("uftu");
		assertEquals("test", shift.decode("uftu", 27));
	}
	
	@Test
	public void testShiftDecodingNegativePosition() {
		when(parser.process("sdrs")).thenReturn("sdrs");
		assertEquals("test", shift.decode("sdrs", -1));
	}
	
	@Test
	public void testShiftDecodingEmptyString() {
		when(parser.process("")).thenReturn("");
		assertEquals("", shift.code("", 1));
	}
	
	@Test
	public void testShiftDecodingStrangeString() {
		when(parser.process("T3es T1!")).thenReturn("test");
		assertEquals("test", shift.code("T3es T1!", 0));
	}

}
