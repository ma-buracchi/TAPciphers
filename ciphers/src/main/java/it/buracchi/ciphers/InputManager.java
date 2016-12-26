package it.buracchi.ciphers;

public class InputManager {

	public void process(String msg) {
		if (argumentsCheck(msg)) {
			throw new IllegalArgumentException("a-z are the only available characters");
		}
	}

	private boolean argumentsCheck(String msg) {
		for (int i = 0; i < msg.length(); i++) {
			if ((int) (msg.charAt(i)) < 97 || (int) (msg.charAt(i)) > 122) {
				return true;
			}
		}
		return false;
	}

}
