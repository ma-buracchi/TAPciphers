package it.buracchi.ciphers;

import java.security.SecureRandom;

public class OneTimePad {

	private String key;
	private Parser parser;
	private SecureRandom generator;
	public static final int BIT_CAP = 2;
	public static final int CHARACTER_LENGTH_IN_BIT = 5;
	public static final int ASCII_OFFSET = 97;
	public static final int ALPHABET_LENGTH = 26;
	private String[] convert = { "00000", "00001", "00010", "00011", "00100", "00101", "00110", "00111", "01000",
			"01001", "01010", "01011", "01100", "01101", "01110", "01111", "10000", "10001", "10010", "10011", "10100",
			"10101", "10110", "10111", "11000", "11001" };

	public OneTimePad(Parser prs, String key) {
		this.parser = prs;
		this.generator = new SecureRandom();
		this.key = key;
	}

	public OneTimePad(Parser prs) {
		this.parser = prs;
		this.generator = new SecureRandom();
		this.key = "";
	}

	public String getKey() {
		return key;
	}

	public void setKey(String k) {
		key = k;
	}

	public String code(String msg) {
		String message = stringToBin(parser.process(msg));
		setupKey(message);
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			res.append((int)message.charAt(i)^(int)key.charAt(i));
		}
		return res.toString();
	}

	private String stringToBin(String msg) {
		StringBuilder res = new StringBuilder();
		for (Character c : msg.toCharArray()) {
			res.append(convert[(int)c - ASCII_OFFSET]);
		}
		return res.toString();
	}

	private void setupKey(String msg) {
		if (key.length() == 0) {
			StringBuilder result = new StringBuilder();
			while (result.length() != msg.length()) {
				result.append(generator.nextInt(BIT_CAP));
			}
			key = result.toString();
		} else {
			parser.checkKey(key);
		}
	}

	public String createKey(int l) {
		StringBuilder result = new StringBuilder();
		while (result.length() != l * CHARACTER_LENGTH_IN_BIT) {
			result.append(convert[generator.nextInt(ALPHABET_LENGTH)]);
		}
		return result.toString();
	}
}
