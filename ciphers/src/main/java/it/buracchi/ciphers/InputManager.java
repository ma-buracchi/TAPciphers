package it.buracchi.ciphers;

import java.util.Locale;

public class InputManager {

	public static final int ALPHABET_LENGTH = 26;
	public static final int ASCII_A_LOWERCASE = 65;
	public static final int ASCII_Z = 122;

	public String process(String msg) {
		return msg.replaceAll("[^A-Za-z]", "").toLowerCase(Locale.ENGLISH);
	}

	public String checkAlphabet(String alphabet) {
		if (alphabet.length() != ALPHABET_LENGTH) {
			throw new IllegalArgumentException("New alphabet must be 26 characters long");
		}
		for (char c : alphabet.toCharArray()) {
			if ((int) c < ASCII_A_LOWERCASE || (int) c > ASCII_Z) {
				throw new IllegalArgumentException("Letters from A to z are the only available characters");
			}
		}
		return alphabet.toLowerCase(Locale.ENGLISH);
	}

}
