package it.buracchi.ciphers;

public class Shift {

	private String message;
	private Parser im;
	private static final int ASCII_OFFSET = 97;
	private static final int ALPHABET_LENGTH = 26;

	public Shift(Parser parser) {
		this.im = parser;
		this.message = "";
	}
	
	public String getMessage() {
		return message;
	}

	public String code(String msg, int shiftPosition) {
		processMessage(msg);
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			result.append(
					(char) (((message.charAt(i) - ASCII_OFFSET + shiftPosition) % ALPHABET_LENGTH) + ASCII_OFFSET));
		}
		return result.toString();
	}

	public String decode(String msg, int shiftPosition) {
		processMessage(msg);
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			result.append(
					(char) (((message.charAt(i) - ASCII_OFFSET - shiftPosition + ALPHABET_LENGTH) % ALPHABET_LENGTH)
							+ ASCII_OFFSET));
		}
		return result.toString();
	}

	private void processMessage(String msg) {
		message = im.process(msg);
	}

}
