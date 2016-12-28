package it.buracchi.ciphers;

public class Shift {

	private String message;
	public static final int ASCII_OFFSET = 97;
	public static final int ALPHABET_LENGTH = 26;

	public Shift() {
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
		InputManager im = new InputManager();
		message = im.process(msg);
	}

}
