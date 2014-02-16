package com.hph.finance.account;

import java.util.HashMap;
import java.util.Map;

public class Iban {

	private static Map<String, String> alphaToNum = new HashMap<String, String>();
	private static Map<String, String> numToAlpha = new HashMap<String, String>();
	
	static {
		
		String[] chars = {
				"A","B","C","D","E","F","G","H","I","J","K","L","M",
				"N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
		};
		
		for(int i = 0; i < chars.length; i++) {
			alphaToNum.put(chars[i], (i + 10) + "");
		}
	}
	
	public static int getChecksum() {
		return 0;
	}
	
	public static Iban parse(String iban) {
		return null;
	}
}
