package it.buracchi.ciphers;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import static it.buracchi.ciphers.Constants.*;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Affine {

	private Parser parser;
	private BiMap<Integer, Integer> invertingTable;
	private static final int[] RELATIVELY_PRIME_TO_26 = { 1, 3, 5, 7, 11, 17, 25 };
	private static final int[] INVERSE_MOD_26 = { 1, 9, 21, 15, 19, 23, 25 };
	private static final Logger logger = LogManager.getLogger(Affine.class);

	public Affine(Parser p) {
		parser = p;
		setInverse();
	}

	public String coding(String msg, int a, int b) {
		logger.info("richiesta di cifratura della stringa '" + msg + "' con parametri a = " + a + " e b = " + b);
		String message = parser.process(msg);
		if (invertingTable.containsKey(a)) {
			StringBuilder res = new StringBuilder();
			for (Character c : message.toCharArray()) {
				int letter = c - ASCII_OFFSET;
				res.append((char) (((a * letter + b) % ALPHABET_LENGTH) + ASCII_OFFSET));
			}
			logger.info("risultato della cifratura -----> " + res.toString());
			return res.toString();
		} else {
			throw new IllegalArgumentException("Coefficient 'a' must be choosen between 1,3,5,7,11,17,25");
		}
	}

	public String decoding(String msg, int a, int b) {
		logger.info("richiesta di decifratura della stringa '" + msg + "' con parametri a = " + a + " e b = " + b);
		String message = parser.process(msg);
		StringBuilder res = new StringBuilder();
		for (Character c : message.toCharArray()) {
			int letter = c - ASCII_OFFSET;
			res.append((char) (((invertingTable.get(a) * (letter - b + NEGATIVE_AVOIDING)) % ALPHABET_LENGTH)
					+ ASCII_OFFSET));
		}
		logger.info("risultato della decifratura -----> " + res.toString());
		return res.toString();
	}

	private void setInverse() {
		invertingTable = HashBiMap.create();
		for (int i = 0; i < RELATIVELY_PRIME_TO_26.length; i++) {
			invertingTable.put(RELATIVELY_PRIME_TO_26[i], INVERSE_MOD_26[i]);
		}
	}

}
