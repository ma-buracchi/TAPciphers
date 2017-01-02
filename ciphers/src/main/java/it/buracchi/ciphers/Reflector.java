package it.buracchi.ciphers;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import static it.buracchi.ciphers.Constants.*;

public class Reflector {

	private BiMap<Character, Character> configuration;

	public Reflector(String name) {
		if (name == "B") {
			setupRef("yruhqsldpxngokmiebfzcwvjat");
		} else if (name == "C"){
			setupRef("fvpjiaoyedrzxwgctkuqsbnmhl");
		} else {
			throw new IllegalArgumentException("Wrong reflector selected");
		}
	}

	private void setupRef(String config) {
		configuration = HashBiMap.create();
		for (int i = 0; i < config.length(); i++) {
			configuration.put((char)(i+ASCII_OFFSET), config.charAt(i));
		}
	}

	public char coding(char letter) {
		return configuration.get(letter);
	}

}
