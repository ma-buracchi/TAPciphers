package it.buracchi.ciphers;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class Substitution {

	private BiMap<Character, Character> convertingTable;
	private StringBuilder res;
	private InputManager im;

	public Substitution(String newAlphabet) {
		im = new InputManager();
		setupConvertingTable(im.checkAlphabet(newAlphabet));
		res = new StringBuilder();
	}

	private void setupConvertingTable(String newAlphabet) {
		convertingTable = HashBiMap.create();
		for (int i = 0; i < newAlphabet.length(); i++) {
			char a = (char) (i + 97);
			convertingTable.put(a, newAlphabet.charAt(i));
		}
	}

	public String code(String msg, boolean coding) {
		String message = im.process(msg);
		if (coding) {
			for (int i = 0; i < message.length(); i++) {
				res.append(convertingTable.get(message.charAt(i)));
			}
		} else {
			for (int i = 0; i < message.length(); i++) {
				res.append(convertingTable.inverse().get(message.charAt(i)));
			}
		}
		return res.toString();
	}

}
