package com.practice;

public class SplitString {

	public static void main(String[] args) {

		String str = "Hi I am Jeevan";
		mySplitString(str);
	}

	public static void mySplitString(String str) {

		String[] split = str.split(" ");
		for (String str1 : split) {
			System.out.println(str1);
		}
	}
}
