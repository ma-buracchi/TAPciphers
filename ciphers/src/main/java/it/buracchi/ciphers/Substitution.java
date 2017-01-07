package it.buracchi.ciphers;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import static it.buracchi.ciphers.Constants.*;

import java.util.stream.IntStream;

public class Substitution {

	private BiMap<Character, Character> convertingTable;
	private StringBuilder res;
	private Parser parser;

	public Substitution(Parser p, String newAlphabet) {
		this.parser = p;
		setupConvertingTable(parser.checkAlphabet(newAlphabet));
		res = new StringBuilder();
	}

	private void setupConvertingTable(String newAlphabet) {
		convertingTable = HashBiMap.create();
		IntStream.range(0, ALPHABET_LENGTH).forEach(n -> {
			char a = (char) (n + ASCII_OFFSET);
			convertingTable.put(a, newAlphabet.charAt(n));
		});
	}

	public String coding(String msg) {
		String message = parser.process(msg);
		for (int i = 0; i < message.length(); i++) {
			res.append(convertingTable.get(message.charAt(i)));
		}
		return res.toString();
	}

	public String decoding(String msg) {
		String message = parser.process(msg);
		for (int i = 0; i < message.length(); i++) {
			res.append(convertingTable.inverse().get(message.charAt(i)));
		}
		return res.toString();
	}

}
