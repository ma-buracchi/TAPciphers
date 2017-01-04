package it.buracchi.ciphers;

public class Enigma {
	
	private Plugboard plug;
	private Rotor fast;
	private Rotor med;
	private Rotor slow;
	private Reflector ref;
	private Parser parser;
	
	public Enigma(Parser parser, Plugboard plug, Rotor fast, Rotor med, Rotor slow, Reflector ref) {
		this.parser = parser;
		this.plug = plug;
		this.fast = fast;
		this.med = med;
		this.slow = slow;
		this.ref = ref;
	}

	public String coding(String msg) {
		String message = parser.process(msg);
		StringBuilder res = new StringBuilder();
		for(char c : message.toCharArray()){
			char temp;
			temp = plug.switching(c);
			temp = fast.firstCoding(temp);
			temp = med.firstCoding(temp);
			temp = slow.firstCoding(temp);
			temp = ref.reflecting(temp);
			temp = slow.secondCoding(temp);
			temp = med.secondCoding(temp);
			temp = fast.secondCoding(temp);
			temp = plug.switching(temp);
			res.append(temp);
		}
		return res.toString();
	}

}
