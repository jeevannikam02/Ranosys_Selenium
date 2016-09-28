package com.practice;

public class ReverseString {

	public static void main(String[] args) {
		String str = "Jeevan";
		System.out.println(reverseMyString(str));
	}

	public static String reverseMyString(String str) {

		String str1 = "";
		char[] ch = str.toCharArray();
		for (int i = ch.length - 1; i >= 0; i--) {
			str1 = str1 + ch[i];
		}
		return str1;
	}
}
