package it.buracchi.ciphers;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import static it.buracchi.ciphers.Constants.*;

import java.util.stream.IntStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Substitution {

	private BiMap<Character, Character> convertingTable;
	private Parser parser;
	private Logger logger = LogManager.getLogger(Substitution.class);

	public Substitution(Parser p, String newAlphabet) {
		this.parser = p;
		setupConvertingTable(parser.checkAlphabet(newAlphabet));
	}

	private void setupConvertingTable(String newAlphabet) {
		convertingTable = HashBiMap.create();
		IntStream.range(0, ALPHABET_LENGTH).forEach(n -> {
			char a = (char) (n + ASCII_OFFSET);
			convertingTable.put(a, newAlphabet.charAt(n));
		});
	}

	public String coding(String msg) {
		logger.info("Richiesta di cifratura della stringa '" + msg);
		String message = parser.process(msg);
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			res.append(convertingTable.get(message.charAt(i)));
		}
		logger.info("Il risultato della cifratura è -----> " + res.toString());
		return res.toString();
	}

	public String decoding(String msg) {
		logger.info("Richiesta di decifratura della stringa '" + msg);
		String message = parser.process(msg);
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			res.append(convertingTable.inverse().get(message.charAt(i)));
		}
		logger.info("Il risultato della cifratura è -----> " + res.toString());
		return res.toString();
	}

}
