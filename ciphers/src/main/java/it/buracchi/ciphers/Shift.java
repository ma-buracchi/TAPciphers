package it.buracchi.ciphers;

public class Shift {

	private InputManager im;
	private String message;

	public String code(String msg, int shiftPosition) {
		processMessage(msg);
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			result.append((char) (((message.charAt(i) - 97 + shiftPosition) % 26) + 97));
		}
		return result.toString();
	}

	public String decode(String msg, int shiftPosition) {
		processMessage(msg);
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			result.append((char) (((message.charAt(i) - 97 - shiftPosition + 26) % 26) + 97));
		}
		return result.toString();
	}
	
	private void processMessage(String msg) {
		im = new InputManager();
		message = im.process(msg);
	}

}
