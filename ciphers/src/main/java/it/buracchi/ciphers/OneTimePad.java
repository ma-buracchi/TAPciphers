package it.buracchi.ciphers;

import java.security.SecureRandom;

public class OneTimePad {

	private String key;
	private String message;
	private SecureRandom generator = new SecureRandom();
	public static final int BIT_CAP = 2;

	public OneTimePad(String msg) {
		this.message = msg;
		this.key = createKey();
	}

	public String getKey() {
		return key;
	}

	private String createKey() {
		StringBuilder k = new StringBuilder();
		while (k.length() != message.length()) {
			k.append(generator.nextInt(BIT_CAP));
		}
		return k.toString();
	}

}
