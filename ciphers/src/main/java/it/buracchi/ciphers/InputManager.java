package it.buracchi.ciphers;

public class InputManager {

	public String process(String msg) {
			return msg.replaceAll("[^A-Za-z]", "").toLowerCase();
	}

}
