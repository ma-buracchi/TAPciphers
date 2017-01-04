package it.buracchi.ciphers;

import static it.buracchi.ciphers.Constants.*;

public class Shift {

	private Parser parser;

	public Shift(Parser p) {
		this.parser = p;
	}

	public String coding(String msg, int shiftPosition) {
		String message = parser.process(msg);
		StringBuilder result = new StringBuilder();
		for (Character c : message.toCharArray()) {
			result.append((char) (((c - ASCII_OFFSET + shiftPosition) % ALPHABET_LENGTH) + ASCII_OFFSET));
		}
		return result.toString();
	}

	public String decoding(String msg, int shiftPosition) {
		String message = parser.process(msg);
		StringBuilder result = new StringBuilder();
		for (Character c : message.toCharArray()) {
			result.append(
					(char) (((c - ASCII_OFFSET - shiftPosition + ALPHABET_LENGTH) % ALPHABET_LENGTH) + ASCII_OFFSET));
		}
		return result.toString();
	}

}
