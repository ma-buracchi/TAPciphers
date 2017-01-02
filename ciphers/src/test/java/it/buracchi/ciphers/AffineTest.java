package it.buracchi.ciphers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class AffineTest {

	private Affine affine;
	private Parser parser;

	@Before
	public void setUp() throws Exception {
		parser = mock(Parser.class);
		affine = new Affine(parser);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testWrongCoefficient() {
		affine.coding("test", 2, 5);
	}

	@Test
	public void testCoding() {
		when(parser.process("test")).thenReturn("test");
		assertEquals("krhk", affine.coding("test", 3, 5));
	}
	
	

}
