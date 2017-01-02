package it.buracchi.ciphers;

import java.util.Locale;

public class InputManager implements Parser {

	private static final int ALPHABET_LENGTH = 26;
	private static final int ASCII_A_LOWERCASE = 65;
	private static final int ASCII_Z = 122;
	private static final int ASCII_0 = 48;
	private static final int ASCII_1 = 49;

	@Override
	public String process(String msg) {
		return msg.replaceAll("[^A-Za-z]", "").toLowerCase(Locale.ENGLISH);
	}

	@Override
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

	@Override
	public String checkKey(String key, int l) {
		if (key.length() != l) {
			throw new IllegalArgumentException("Key length and message length must be the same");
		}
		for (Character c : key.toCharArray()) {
			if ((int) c != ASCII_0 && (int) c != ASCII_1) {
				throw new IllegalArgumentException("Key must be composed just by 0 or 1");
			}
		}
		return key;
	}

}
