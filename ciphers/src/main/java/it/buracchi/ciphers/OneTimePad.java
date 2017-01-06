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

	public String createKey(String msg) {
		String message = stringToBin(parser.process(msg));
		StringBuilder key = new StringBuilder();
		while (key.length() < message.length()) {
			key.append(generator.nextInt(BIT_RANGE));
		}
		return key.toString();
	}
	
	public String fromStringToBinary(String msg){
		return stringToBin(parser.process(msg));
	}
	
	public String fromBinaryToString(String message){
		return binToString(message);
	}

	public String coding(String message, String k) {
		parser.checkKey(k, message.length());
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			res.append(Character.getNumericValue(message.charAt(i)) ^ Character.getNumericValue(k.charAt(i)));
		}
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
			if(convert.containsValue(substring.toString())){
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
