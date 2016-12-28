package it.buracchi.ciphers;

public class OneTimePad {
	
	private String key;
	private String message;

	public OneTimePad(String msg) {
		this.message = msg;
	}

	public String getKey() {
		return key;
	}

}
