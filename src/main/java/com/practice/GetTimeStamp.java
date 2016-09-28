package com.practice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetTimeStamp {
	public static void main(String[] args) {
		SysDate();
	}

	public static String SysDate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HH-mm-ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); // 2014/08/06 15:59:48
		String SysDate = (dateFormat.format(date)).toString();
		return SysDate;
	}
}
