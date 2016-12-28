package it.buracchi.ciphers;

import java.util.Locale;

public class InputManager {

	public String process(String msg) {
		return msg.replaceAll("[^A-Za-z]", "").toLowerCase(Locale.ENGLISH);
	}

	public String checkAlphabet(String alphabet) {
		if (alphabet.length() != 26) {
			throw new IllegalArgumentException("New alphabet must be 26 characters long");
		}
		for (int i = 0; i < alphabet.length(); i++) {
			if ((int) (alphabet.charAt(i)) < 65 || (int) (alphabet.charAt(i)) > 122) {
				throw new IllegalArgumentException("Letters from A to z are the only available characters");
			}
		}
		return alphabet.toLowerCase(Locale.ENGLISH);
	}

}
