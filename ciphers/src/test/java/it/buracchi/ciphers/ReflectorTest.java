package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReflectorTest {

	Reflector reflector;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testBReflectorCoding() {
		reflector = new Reflector("B");
		assertEquals('y', reflector.coding('a'));
	}

	@Test
	public void testCReflectorCoding() {
		reflector = new Reflector("C");
		assertEquals('f', reflector.coding('a'));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWrongReflectorCoding() {
		reflector = new Reflector("K");
	}

}
