package com.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintReverse {

	public static void main(String[] args) {
		int num = 10;
		myNum(num);
	}

	public static void myNum(int num) {

		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i <= num; i++) {
			myList.add(i);
		}
		Collections.reverse(myList);
		System.out.println(myList);
	}
}
