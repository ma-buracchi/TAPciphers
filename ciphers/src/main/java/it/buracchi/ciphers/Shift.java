package it.buracchi.ciphers;

public class Shift {

	private String message;

	public String code(String msg, int shiftPosition, boolean coding) {
		processMessage(msg);
		StringBuilder result = new StringBuilder();
		if (coding) {
			for (int i = 0; i < message.length(); i++) {
				result.append((char) (((message.charAt(i) - 97 + shiftPosition) % 26) + 97));
			}
		} else {
			for (int i = 0; i < message.length(); i++) {
				result.append((char) (((message.charAt(i) - 97 - shiftPosition + 26) % 26) + 97));
			}
		}
		return result.toString();
	}

	private void processMessage(String msg) {
		InputManager im = new InputManager();
		message = im.process(msg);
	}

}
