package it.buracchi.ciphers;

import java.security.SecureRandom;

public class OneTimePad {

	private String key;
	private Parser parser;
	private SecureRandom generator = new SecureRandom();
	public static final int BIT_CAP = 2;

	public OneTimePad(Parser prs, String key) {
		this.parser = prs;
		this.key = prs.process(key);
	}

	public OneTimePad(Parser prs) {
		this.parser = prs;
	}

	public String getKey() {
		return key;
	}

	public String code(String msg) {
		parser.process(msg);
		setupKey(msg);
		StringBuilder res = new StringBuilder();
		return res.toString();
	}

	private void setupKey(String msg) {
		if (key.length() == 0) {
			StringBuilder k = new StringBuilder();
			while (k.length() != msg.length()) {
				k.append(generator.nextInt(BIT_CAP));
			}
			key = k.toString();
		}
	}

}
