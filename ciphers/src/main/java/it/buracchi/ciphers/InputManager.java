package it.buracchi.ciphers;

public class InputManager {

	public String process(String msg) {
		if (argumentsCheck(msg)) {
			return msg.replaceAll("[^A-Za-z]", "").toLowerCase();
		} else {
			throw new IllegalArgumentException("a-z are the only available characters");
		}
	}

	private boolean argumentsCheck(String msg) {
		for (int i = 0; i < msg.length(); i++) {
			if ((int) (msg.charAt(i)) < 97 || (int) (msg.charAt(i)) > 122) {
				return false;
			}
		}
		return true;
	}

}
