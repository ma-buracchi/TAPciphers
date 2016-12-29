package it.buracchi.ciphers;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class Substitution {

	public static final int ASCII_OFFSET = 97;
	private BiMap<Character, Character> convertingTable;
	private StringBuilder res;
	private Parser im;

	public Substitution(Parser parser, String newAlphabet) {
		im = parser;
		setupConvertingTable(im.checkAlphabet(newAlphabet));
		res = new StringBuilder();
	}

	private void setupConvertingTable(String newAlphabet) {
		convertingTable = HashBiMap.create();
		for (int i = 0; i < newAlphabet.length(); i++) {
			char a = (char) (i + ASCII_OFFSET);
			convertingTable.put(a, newAlphabet.charAt(i));
		}
	}

	public String code(String msg) {
		String message = im.process(msg);
		for (int i = 0; i < message.length(); i++) {
			res.append(convertingTable.get(message.charAt(i)));
		}
		return res.toString();
	}

	public String decode(String msg) {
		String message = im.process(msg);
		for (int i = 0; i < message.length(); i++) {
			res.append(convertingTable.inverse().get(message.charAt(i)));
		}
		return res.toString();
	}

}
