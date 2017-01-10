package it.buracchi.ciphers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;

public class OneTimePadTest {

	private OneTimePad otp;
	private Mapper<Character, String> converter;
	private Parser parser;
	private String[] huffman = { "0100", "011111", "11110", "01010", "000", "10110", "011100", "1101", "0010",
			"101111100", "1011110", "01011", "10100", "0011", "0110", "011110", "101111110", "1110", "1100", "100",
			"11111", "101110", "10101", "101111101", "011101", "101111111" };
	private String string_a_BinaryRepresentation = "0100";
	private String string_test_BinaryRepresentation = "1000001100100";
	private String shortKey = "0001";
	private String longKey = "0001011100101";
	private String string_a_CodedWithShortKey = "0101";
	private String string_test_CodedWithLongKey = "1001010000001";

	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		parser = mock(Parser.class);
		converter = mock(Mapper.class);
		when(parser.process("a")).thenReturn("a");
		when(parser.process("test")).thenReturn("test");
		when(parser.process(string_a_BinaryRepresentation)).thenReturn(string_a_BinaryRepresentation);
		when(parser.process(string_test_BinaryRepresentation)).thenReturn(string_test_BinaryRepresentation);
		when(parser.process(shortKey)).thenReturn(shortKey);
		when(parser.checkKey(shortKey, 4)).thenReturn(shortKey);
		when(parser.process(longKey)).thenReturn(longKey);
		when(parser.checkKey(longKey, 13)).thenReturn(longKey);
		when(parser.process(string_a_CodedWithShortKey)).thenReturn(string_a_CodedWithShortKey);
		/*for(int i = 0; i < 26; i++){
			when(converter.addEntry((char)(i+97), huffman[i])).thenReturn();
		}*/
		otp = new OneTimePad(parser, converter, huffman);
	}

	@Test
	public void testCreatedKeyOneCharachterLength() {
		assertEquals(string_a_BinaryRepresentation.length(), otp.createKey(string_a_BinaryRepresentation).length());
	}

	@Test
	public void testCreatedLongerThanKeyOneCharachterLength() {
		assertEquals(string_test_BinaryRepresentation.length(),
				otp.createKey(string_test_BinaryRepresentation).length());
	}

	@Test
	public void testFromStringToBinary() {
		when(converter.getValueFromKey('a')).thenReturn("0100");
		assertEquals(string_a_BinaryRepresentation, otp.fromStringToBinary("a"));
	}

	@Test
	public void testFromStringToBinaryLongerString() {
		when(converter.getValueFromKey('t')).thenReturn("100");
		when(converter.getValueFromKey('e')).thenReturn("000");
		when(converter.getValueFromKey('s')).thenReturn("1100");
		assertEquals(string_test_BinaryRepresentation, otp.fromStringToBinary("test"));
	}

	@Test
	public void testFromBinaryToString() {
		when(converter.containsValue("0100")).thenReturn(true);
		when(converter.getKeyFromValue("0100")).thenReturn('a');
		assertEquals("a", otp.fromBinaryToString(string_a_BinaryRepresentation));
	}

	@Test
	public void testFromBinaryToStringLongerString() {
		when(converter.containsValue("100")).thenReturn(true);
		when(converter.containsValue("000")).thenReturn(true);
		when(converter.containsValue("1100")).thenReturn(true);
		when(converter.getKeyFromValue("100")).thenReturn('t');
		when(converter.getKeyFromValue("000")).thenReturn('e');
		when(converter.getKeyFromValue("1100")).thenReturn('s');
		assertEquals("test", otp.fromBinaryToString(string_test_BinaryRepresentation));
	}

	@Test
	public void testCoding() {
		assertEquals(string_a_CodedWithShortKey, otp.coding(string_a_BinaryRepresentation, shortKey));
	}

	@Test
	public void testCodingLongerString() {
		assertEquals(string_test_CodedWithLongKey, otp.coding(string_test_BinaryRepresentation, longKey));
	}

	@Test
	public void testDecoding() {
		assertEquals(string_a_BinaryRepresentation, otp.coding(string_a_CodedWithShortKey, shortKey));
	}

	@Test
	public void testDecodingLongerString() {
		assertEquals(string_test_BinaryRepresentation, otp.coding(string_test_CodedWithLongKey, longKey));
	}

}
