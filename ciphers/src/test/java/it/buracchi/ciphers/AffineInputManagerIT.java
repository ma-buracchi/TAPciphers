package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AffineInputManagerIT {
	
	private Parser p;
	private Affine affine;

	@Before
	public void setUp() throws Exception {
		p = new InputManager();
		affine = new Affine(p);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testCodingWithWrongCoefficient() {
		affine.coding("test", 2, 5);
	}

	@Test
	public void testCoding() {
		assertEquals("f", affine.coding("a", 3, 5));
	}
	
	@Test
	public void testCodingLongerString() {
		assertEquals("krhk", affine.coding("test", 3, 5));
	}
	
	@Test
	public void testDecoding() {
		assertEquals("a", affine.decoding("f", 3, 5));
	}
	
	@Test
	public void testDecodingLongerString() {
		assertEquals("test", affine.decoding("krhk", 3, 5));
	}

}
