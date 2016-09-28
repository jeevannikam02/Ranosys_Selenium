package com.practice;

import java.util.HashMap;
import java.util.Map;

public class RepetationOfCharacters {

	public static void main(String[] args) {
		String str = "Jeevan";
		repetationOfChars(str);
	}

	public static void repetationOfChars(String str) {

		Map<Character, Integer> myMap = new HashMap<Character, Integer>();
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);

			if (myMap.containsKey(c)) {
				myMap.put(c, myMap.get(c) + 1);
			} else {
				myMap.put(c, 1);
			}
		}
		System.out.println(myMap);
	}
}
