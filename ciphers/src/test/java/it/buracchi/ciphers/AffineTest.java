package it.buracchi.ciphers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class AffineTest {

	private Affine affine;
	private Parser parser;

	private Mapper<Integer, Integer> mapper;

	@Before
	public void setUp() throws Exception {
		parser = mock(Parser.class);
		mapper = mock(Mapper.class);
		when(mapper.getValueFromKey(3)).thenReturn(9);
		when(mapper.containsKey(3)).thenReturn(true);
		affine = new Affine(parser, mapper);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCodingWithWrongCoefficient() {
		when(mapper.getValueFromKey(2))
				.thenThrow(new IllegalArgumentException("Coefficient 'a' must be choosen between 1,3,5,7,11,17,25"));
		affine.coding("test", 2, 5);
	}

	@Test
	public void testCoding() {
		when(parser.process("a")).thenReturn("a");
		assertEquals("f", affine.coding("a", 3, 5));
	}

	@Test
	public void testCodingLongerString() {
		when(parser.process("test")).thenReturn("test");
		assertEquals("krhk", affine.coding("test", 3, 5));
	}

	@Test
	public void testCodingEmptyString() {
		when(parser.process("")).thenReturn("");
		assertEquals("", affine.coding("", 3, 5));
	}

	@Test
	public void testDecoding() {
		when(parser.process("f")).thenReturn("f");
		assertEquals("a", affine.decoding("f", 3, 5));
	}

	@Test
	public void testDecodingLongerString() {
		when(parser.process("krhk")).thenReturn("krhk");
		assertEquals("test", affine.decoding("krhk", 3, 5));
	}

	@Test
	public void testDecodingEmptyString() {
		when(parser.process("")).thenReturn("");
		assertEquals("", affine.decoding("", 3, 5));
	}

}
