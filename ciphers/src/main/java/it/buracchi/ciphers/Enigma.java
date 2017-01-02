package it.buracchi.ciphers;

public class Enigma {
	
	private Plugboard plug;
	private Rotor fast;
	private Rotor med;
	private Rotor slow;
	private Reflector ref;
	
	public Enigma(Plugboard plug, Rotor fast, Rotor med, Rotor slow, Reflector ref) {
		this.plug = plug;
		this.fast = fast;
		this.med = med;
		this.slow = slow;
		this.ref = ref;
	}

}
