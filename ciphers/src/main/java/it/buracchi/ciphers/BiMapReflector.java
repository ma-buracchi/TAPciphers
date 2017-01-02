package it.buracchi.ciphers;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import static it.buracchi.ciphers.Constants.*;

public class BiMapReflector implements Reflector {

	private BiMap<Character, Character> configuration;

	public BiMapReflector(String name) {
		if ("B".equals(name)) {
			setupRef("yruhqsldpxngokmiebfzcwvjat");
		} else if ("C".equals(name)){
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

	@Override
	public char reflecting(char letter) {
		return configuration.get(letter);
	}

}
