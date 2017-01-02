package it.buracchi.ciphers;

public class Shift {

	private Parser im;
	private static final int ASCII_OFFSET = 97;
	private static final int ALPHABET_LENGTH = 26;

	public Shift(Parser parser) {
		this.im = parser;
	}

	public String coding(String msg, int shiftPosition) {
		String message = im.process(msg);
		StringBuilder result = new StringBuilder();
		for (Character c : message.toCharArray()) {
			result.append((char) (((c - ASCII_OFFSET + shiftPosition) % ALPHABET_LENGTH) + ASCII_OFFSET));
		}
		return result.toString();
	}

	public String decoding(String msg, int shiftPosition) {
		String message = im.process(msg);
		StringBuilder result = new StringBuilder();
		for (Character c : message.toCharArray()) {
			result.append(
					(char) (((c - ASCII_OFFSET - shiftPosition + ALPHABET_LENGTH) % ALPHABET_LENGTH) + ASCII_OFFSET));
		}
		return result.toString();
	}

}
