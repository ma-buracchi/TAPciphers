package it.buracchi.ciphers;

public class Vigenere {

	private String key;
	private String msg;
	private StringBuilder res;

	public Vigenere(String key, String msg) {
		this.key = extendKey(key, msg.length());
		this.msg = msg;
	}

	public String getKey() {
		return key;
	}

	public String code(String msg) {
		return res.toString();
	}

	private String extendKey(String key, int l) {
		StringBuilder k = new StringBuilder();
		while (k.length() <= l) {
			k.append(key);
		}
		return k.toString();
	}

}
