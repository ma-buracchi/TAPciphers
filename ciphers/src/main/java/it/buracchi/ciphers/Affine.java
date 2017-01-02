package it.buracchi.ciphers;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class Affine {

	private Parser parser;
	private BiMap<Integer, Integer> invertingTable;

	public Affine(Parser p) {
		parser = p;
		setInverse();
	}

	public String coding(String msg, int a, int b) {
		String message = parser.process(msg);
		if(invertingTable.containsKey(a)){
			StringBuilder res = new StringBuilder();
			for(Character c : message.toCharArray()){
				int letter = (int)(c)-97;
				res.append((char)(((a*letter+b)%26)+97));
			}
			return res.toString();
		} else {
			throw new IllegalArgumentException("Coefficient 'a' must be choosen between 1,3,5,7,11,17,25");
		}
	}
	
	private void setInverse() {
		invertingTable = HashBiMap.create();
		invertingTable.put(1, 1);
		invertingTable.put(3, 9);
		invertingTable.put(5, 21);
		invertingTable.put(7, 15);
		invertingTable.put(11, 19);
		invertingTable.put(17, 23);
		invertingTable.put(25, 25);
	}

}
