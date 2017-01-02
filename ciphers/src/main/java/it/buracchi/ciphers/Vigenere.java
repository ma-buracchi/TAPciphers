package it.buracchi.ciphers;

import static it.buracchi.ciphers.Constants.*;

public class Vigenere {

	private Parser im;
	private String key;

	public Vigenere(Parser parser, String key) {
		im = parser;
		this.key = im.process(key);
	}

	public String getKey() {
		return key;
	}

	public String code(String msg) {
		String message = im.process(msg);
		if (key.length() < message.length()) {
			key = extendKey(key, message.length());
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			int m = (int) (message.charAt(i)) - ASCII_OFFSET;
			int k = (int) (key.charAt(i)) - ASCII_OFFSET;
			result.append((char) (((m + k) % ALPHABET_LENGTH) + ASCII_OFFSET));
		}
		return result.toString();
	}

	public String decode(String msg) {
		String message = im.process(msg);
		if (key.length() < message.length()) {
			key = extendKey(key, message.length());
		}
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			int m = (int) (message.charAt(i)) - ASCII_OFFSET;
			int k = (int) (key.charAt(i)) - ASCII_OFFSET;
			result.append((char) (((m - k + ALPHABET_LENGTH) % ALPHABET_LENGTH) + ASCII_OFFSET));
		}
		return result.toString();
	}

	private static String extendKey(String key, int l) {
		if (key.isEmpty()) {
			throw new IllegalArgumentException("Key must be longer than 0");
		}
		StringBuilder k = new StringBuilder();
		while (k.length() < l) {
			k.append(key);
		}
		return k.toString();
	}

}
