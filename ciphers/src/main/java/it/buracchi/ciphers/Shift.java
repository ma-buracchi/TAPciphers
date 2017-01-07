package it.buracchi.ciphers;

import static it.buracchi.ciphers.Constants.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Shift {

	private Parser parser;
	private static final Logger logger = LogManager.getLogger(Shift.class);

	public Shift(Parser p) {
		this.parser = p;
	}

	public String coding(String msg, int shiftPosition) {
		logger.info("Richiesta di cifratura della stringa '" + msg + "' con a = " + shiftPosition);
		String message = parser.process(msg);
		StringBuilder result = new StringBuilder();
		for (Character c : message.toCharArray()) {
			result.append((char) (((c - ASCII_OFFSET + shiftPosition) % ALPHABET_LENGTH) + ASCII_OFFSET));
		}
		logger.info("Il risultato della cifratura è -----> " + result.toString());
		return result.toString();
	}

	public String decoding(String msg, int shiftPosition) {
		logger.info("Richiesta di decifratura della stringa '" + msg + "' con a = " + shiftPosition);
		String message = parser.process(msg);
		StringBuilder result = new StringBuilder();
		for (Character c : message.toCharArray()) {
			result.append(
					(char) (((c - ASCII_OFFSET - shiftPosition + ALPHABET_LENGTH) % ALPHABET_LENGTH) + ASCII_OFFSET));
		}
		logger.info("Il risultato della decifratura è -----> " + result.toString());
		return result.toString();
	}

}
