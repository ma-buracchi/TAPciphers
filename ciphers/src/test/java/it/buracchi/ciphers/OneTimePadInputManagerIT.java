package it.buracchi.ciphers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class OneTimePadInputManagerIT {

	private OneTimePad otp;
	private Parser parser;
	private String string_a_BinaryRepresentation = "0100";
	private String string_test_BinaryRepresentation = "1000001100100";
	private String shortKey = "0001";
	private String longKey = "0001011100101";
	private String string_a_CodedWithShortKey = "0101";
	private String string_test_CodedWithLongKey = "1001010000001";

	@Before
	public void setup() {
		parser = new InputManager();
		otp = new OneTimePad(parser);
	}

	@Test
	public void testCreatedKeyOneCharachterLength() {
		assertEquals(string_a_BinaryRepresentation.length(), otp.createKey(string_a_BinaryRepresentation).length());
	}

	@Test
	public void testCreatedLongerThanKeyOneCharachterLength() {
		assertEquals(string_test_BinaryRepresentation.length(), otp.createKey(string_test_BinaryRepresentation).length());
	}

	@Test
	public void testFromStringToBinary() {
		assertEquals(string_a_BinaryRepresentation, otp.fromStringToBinary("a"));
	}

	@Test
	public void testFromStringToBinaryLongerString() {
		assertEquals(string_test_BinaryRepresentation, otp.fromStringToBinary("test"));
	}

	@Test
	public void testFromBinaryToString() {
		assertEquals("a", otp.fromBinaryToString(string_a_BinaryRepresentation));
	}

	@Test
	public void testFromBinaryToStringLongerString() {
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
