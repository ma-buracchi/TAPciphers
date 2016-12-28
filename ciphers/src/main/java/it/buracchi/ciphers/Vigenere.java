package it.buracchi.ciphers;

public class Vigenere {

	public static final int ASCII_OFFSET = 97;
	public static final int ALPHABET_LENGTH = 26;
	private String key;
	private String message;

	public Vigenere(String key, String msg) {
		InputManager im = new InputManager();
		this.message = im.process(msg);
		this.key = extendKey(im.process(key), message.length());
	}

	private static String extendKey(String key, int l) {
		StringBuilder k = new StringBuilder();
		while (k.length() <= l) {
			k.append(key);
		}
		return k.toString();
	}

	public String getKey() {
		return key;
	}

	public String code() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			int m = (int) (message.charAt(i)) - ASCII_OFFSET;
			int k = (int) (key.charAt(i)) - ASCII_OFFSET;
			result.append((char) (((m + k) % ALPHABET_LENGTH) + ASCII_OFFSET));
		}
		return result.toString();
	}

	public String decode() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			int m = (int) (message.charAt(i)) - ASCII_OFFSET;
			int k = (int) (key.charAt(i)) - ASCII_OFFSET;
			result.append((char) (((m - k + ALPHABET_LENGTH) % ALPHABET_LENGTH) + ASCII_OFFSET));
		}
		return result.toString();
	}

}
