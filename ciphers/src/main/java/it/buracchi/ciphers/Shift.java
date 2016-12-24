package it.buracchi.ciphers;

public class Shift {

	public String code(String msg, int shiftPosition) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < msg.length(); i++) {
			result.append((char) (((msg.charAt(i) - 97 + shiftPosition) % 26) + 97));
		}
		return result.toString();
	}

}
