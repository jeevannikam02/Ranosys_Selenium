package com.practice;

class Bicycle {

	static int cadence = 0;
	static int speed = 0;
	static int gear = 1;
	
	public static void main(String[] args) {
		Bicycle b1 = new Bicycle();
		b1.speedUp(20);
		b1.changeCadence(10);
		b1.changeGear(5);
		b1.printStates();
		
		MountainBikes mb = b1.new MountainBikes();
		mb.speedUp(20);
	}

	public static void changeCadence(int newValue) {
		cadence = newValue;
	}

	public static void changeGear(int newValue) {
		gear = newValue;
	}

	public static void speedUp(int increment) {
		speed = speed + increment;
	}

	public static void applyBrakes(int decrement) {
		speed = speed - decrement;
	}

	public static void printStates() {
		System.out.println("cadence:" + cadence + " speed:" + speed + " gear:" + gear);
	}
	
	public class MountainBikes extends Bicycle{
		
		
	}
}