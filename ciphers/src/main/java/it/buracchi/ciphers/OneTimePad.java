package it.buracchi.ciphers;

import java.security.SecureRandom;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import static it.buracchi.ciphers.Constants.*;

public class OneTimePad {

	private Parser parser;
	private SecureRandom generator;
	private BiMap<Character, String> convert;
	private static final Logger LOGGER = LogManager.getLogger(OneTimePad.class);

	public OneTimePad(Parser p) {
		initializeConvert();
		this.parser = p;
		this.generator = new SecureRandom();
		BasicConfigurator.resetConfiguration();
		BasicConfigurator.configure();
	}

	public String createKey(String msg) {
		LOGGER.info("Richiesta di creazione di una chiave per permettere la cifratura del messaggio " + msg);
		StringBuilder key = new StringBuilder();
		while (key.length() < msg.length()) {
			key.append(generator.nextInt(BIT_RANGE));
		}
		LOGGER.info("La chiave richiesta è -----> " + key.toString());
		return key.toString();
	}

	public String fromStringToBinary(String msg) {
		LOGGER.info("Richiesta di conversione della stringa " + msg + " in una stringa binaria");
		String res = stringToBin(parser.process(msg));
		LOGGER.info("La stringa binaria risultante è -----> " + res);
		return res;
	}

	public String fromBinaryToString(String message) {
		LOGGER.info("Richiesta di conversione della stringa binaria " + message + " in una stringa alfabetica");
		String res = binToString(message);
		LOGGER.info("La stringa alfabetica risultante è -----> " + res);
		return res;
	}

	public String coding(String message, String k) {
		LOGGER.info("Richiesta di cifratura del messaggio " + message + " utilizzando la chiave " + k);
		parser.checkKey(k, message.length());
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			res.append(Character.getNumericValue(message.charAt(i)) ^ Character.getNumericValue(k.charAt(i)));
		}
		LOGGER.info("Il risultato della cifratura è -----> " + res.toString());
		return res.toString();
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
		StringBuilder substring = new StringBuilder();
		for (char c : msg.toCharArray()) {
			substring.append(c);
			if (convert.containsValue(substring.toString())) {
				res.append(convert.inverse().get(substring.toString()));
				substring.setLength(0);
			}
		}
		return res.toString();
	}

	private void initializeConvert() {
		convert = HashBiMap.create();
		convert.put('a', "0100");
		convert.put('b', "011111");
		convert.put('c', "11110");
		convert.put('d', "01010");
		convert.put('e', "000");
		convert.put('f', "10110");
		convert.put('g', "011100");
		convert.put('h', "1101");
		convert.put('i', "0010");
		convert.put('j', "101111100");
		convert.put('k', "1011110");
		convert.put('l', "01011");
		convert.put('m', "10100");
		convert.put('n', "0011");
		convert.put('o', "0110");
		convert.put('p', "011110");
		convert.put('q', "101111110");
		convert.put('r', "1110");
		convert.put('s', "1100");
		convert.put('t', "100");
		convert.put('u', "11111");
		convert.put('v', "101110");
		convert.put('w', "10101");
		convert.put('x', "101111101");
		convert.put('y', "011101");
		convert.put('z', "101111111");
	}

}
