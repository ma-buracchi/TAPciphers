package it.buracchi.ciphers;

public class Constants {

	public static final int NEGATIVE_AVOIDING = (int) Math.pow(26, 2);
	public static final int ASCII_OFFSET = 97;
	public static final int ALPHABET_LENGTH = 26;
	public static final int[] RELATIVELY_PRIME_TO_26 = { 1, 3, 5, 7, 11, 17, 25 };
	public static final int[] INVERSE_MOD_26 = { 1, 9, 21, 15, 19, 23, 25 };
	public static final int ASCII_A_LOWERCASE = 65;
	public static final int ASCII_Z = 122;
	public static final int ASCII_0 = 48;
	public static final int ASCII_1 = 49;
	public static final int ALPHABET_CAP = 27;
	public static final int CHARACTER_LENGTH_IN_BIT = 5;
	
	private Constants() {
		throw new UnsupportedOperationException("Utility class");
	}

}
