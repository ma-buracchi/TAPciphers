package it.buracchi.ciphers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class EnigmaTest {
	
	Enigma enigma;

	@Before
	public void setUp() throws Exception {
		Plugboard plug = mock(Plugboard.class);
		Rotor fast = mock(Rotor.class);
		Rotor med = mock(Rotor.class);
		Rotor slow = mock(Rotor.class);
		Reflector ref = mock(Reflector.class);
		enigma = new Enigma(plug,fast,med,slow,ref);
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
