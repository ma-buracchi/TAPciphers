package it.buracchi.ciphers;

public class Vigenere {

	private String key;
	private String message;

	public Vigenere(String key, String msg) {
		InputManager im = new InputManager();
		this.message = im.process(msg);
		this.key = extendKey(im.process(key), message.length());
	}
	
	private static String extendKey(String key, int l) {
		StringBuilder k = new StringBuilder();
		while (k.length() <= l) {
			k.append(key);
		}
		return k.toString();
	}

	public String getKey() {
		return key;
	}

	public String code(boolean coding) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < message.length(); i++) {
			int m = (int) (message.charAt(i)) - 97;
			int k = (int) (key.charAt(i)) - 97;
			if(coding){
				result.append((char)(((m+k)%26)+97));
			} else {
				result.append((char)(((m-k+26)%26)+97));
			}
			
		}
		return result.toString();
	}

}
