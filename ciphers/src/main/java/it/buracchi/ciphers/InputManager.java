package it.buracchi.ciphers;

public class InputManager {

	public void process(String msg) {
		argumentsCheck(msg);
	}

	private void argumentsCheck(String msg) {
		for (int i = 0; i < msg.length(); i++) {
			if ((int) (msg.charAt(i)) < 97 || (int) (msg.charAt(i)) > 122) {
				throw new IllegalArgumentException("a-z are the only available characters");
			} 
		}
	}

}
