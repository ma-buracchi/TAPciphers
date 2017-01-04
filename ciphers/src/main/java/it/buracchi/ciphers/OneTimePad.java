package it.buracchi.ciphers;

import java.security.SecureRandom;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import static it.buracchi.ciphers.Constants.*;

public class OneTimePad {

	private Parser parser;
	private SecureRandom generator;
	private BiMap<Character, String> convert;

	public OneTimePad(Parser p) {
		initializeConvert();
		this.parser = p;
		this.generator = new SecureRandom();
	}

	public String createKey(int l) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < l; i++) {
			result.append(convert.get((char)(generator.nextInt(ALPHABET_LENGTH) + ASCII_OFFSET)));
		}
		return result.toString();
	}

	public String coding(String msg, String k) {
		String message = stringToBin(parser.process(msg));
		String key = parser.checkKey(k, message.length());
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			res.append((int) message.charAt(i) ^ (int) key.charAt(i));
		}
		return res.toString();
	}

	public String decoding(String msg, String k) {
		parser.checkKey(k, msg.length());
		String key = k;
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < msg.length(); i++) {
			int messageChar = Character.getNumericValue(msg.charAt(i));
			int keyChar = Character.getNumericValue(key.charAt(i));
			res.append(messageChar ^ keyChar);
		}
		return binToString(res.toString());
	}

	private String stringToBin(String msg) {
		StringBuilder res = new StringBuilder();
		for (Character c : msg.toCharArray()) {
			res.append(convert.get(c));
		}
		return res.toString();
	}

	private String binToString(String msg) {
		StringBuilder res = new StringBuilder();
		int messageLength = msg.length() / CHARACTER_LENGTH_IN_BIT;
		for (int i = 0; i < messageLength; i++) {
			res.append(convert.inverse()
					.get(msg.substring(i * CHARACTER_LENGTH_IN_BIT, (i + 1) * CHARACTER_LENGTH_IN_BIT)));
		}
		return res.toString();
	}

	private void initializeConvert() {
		convert = HashBiMap.create();
		convert.put('a', "00000");
		convert.put('b', "00001");
		convert.put('c', "00010");
		convert.put('d', "00011");
		convert.put('e', "00100");
		convert.put('f', "00101");
		convert.put('g', "00110");
		convert.put('h', "00111");
		convert.put('i', "01000");
		convert.put('j', "01001");
		convert.put('k', "01010");
		convert.put('l', "01011");
		convert.put('m', "01100");
		convert.put('n', "01101");
		convert.put('o', "01110");
		convert.put('p', "01111");
		convert.put('q', "10000");
		convert.put('r', "10001");
		convert.put('s', "10010");
		convert.put('t', "10011");
		convert.put('u', "10100");
		convert.put('v', "10101");
		convert.put('w', "10110");
		convert.put('x', "10111");
		convert.put('y', "11000");
		convert.put('z', "11001");
	}

}
