package it.buracchi.ciphers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class EnigmaTest {

	private Enigma enigma;
	private Parser parser;

	@Before
	public void setUp() throws Exception {
		parser = mock(Parser.class);
		when(parser.process("a")).thenReturn("a");
		Plugboard plug = mock(Plugboard.class);
		when(plug.switching('a')).thenReturn('a');
		when(plug.switching('n')).thenReturn('n');
		Rotor fast = mock(Rotor.class);
		when(fast.firstCoding('a')).thenReturn('e');
		when(fast.secondCoding('w')).thenReturn('n');
		Rotor med = mock(Rotor.class);
		when(med.firstCoding('e')).thenReturn('s');
		when(med.secondCoding('f')).thenReturn('w');
		Rotor slow = mock(Rotor.class);
		when(slow.firstCoding('s')).thenReturn('g');
		when(slow.secondCoding('l')).thenReturn('f');
		Reflector ref = mock(Reflector.class);
		when(ref.reflecting('g')).thenReturn('l');
		enigma = new Enigma(parser, plug, fast, med, slow, ref);
	}

	@Test
	public void testCoding() {
		assertEquals("n", enigma.coding("a"));
	}

}
