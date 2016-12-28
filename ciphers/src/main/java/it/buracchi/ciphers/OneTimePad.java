package it.buracchi.ciphers;

import java.text.ParseException;
import java.util.Random;

public class OneTimePad {
	
	private String key;
	private String message;
	private Random generator = new Random();
	
	public OneTimePad(String msg) {
		this.message = msg;
		this.key = createKey();
	}
	
	public String getKey() {
		return key;
	}

	private String createKey() {
		StringBuilder k = new StringBuilder();
		for(Character c : message.toCharArray()){
			k.append(generator.nextInt(2));
		}
		return k.toString();
	}

}
