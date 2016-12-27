package it.buracchi.ciphers;

public class Vigenere {

	private String key;
	private String message;
	private StringBuilder result;
	private InputManager im;

	public Vigenere(String key, String msg) {
		im = new InputManager();
		this.message = im.process(msg);
		this.key = extendKey(key, msg.length());
		result = new StringBuilder();
	}

	public String getKey() {
		return key;
	}

	public String code() {
		for (int i = 0; i < message.length(); i++) {
			int m = (int) (message.charAt(i)) - 97;
			int k = (int) (key.charAt(i)) - 97;
			result.append((char)(((m+k)%26)+97));
		}
		return result.toString();
	}

	public String decode() {
		for (int i = 0; i < message.length(); i++) {
			int m = (int) (message.charAt(i)) - 97;
			int k = (int) (key.charAt(i)) - 97;
			result.append((char)(((m-k+26)%26)+97));
		}
		return result.toString();
	}

	private String extendKey(String key, int l) {
		StringBuilder k = new StringBuilder();
		while (k.length() <= l) {
			k.append(key);
		}
		return k.toString();
	}

}
