package com.promineotech;

import java.util.Random;

public class TestDemo {
	
	public int addPositive(int a, int b) {
		if(a > 0 && b > 0) {
			return a + b;
		} else {
			throw new IllegalArgumentException("Both parameters must be positive!");
			
		}
	}
	
	//This method will check to see if a number is even or not.
	public int checkToSeeIfNumbersAreEvenThenMultiplyThemTogether(int c, int d) {
		if(c % 2 == 0 && d % 2 == 0) {
			return c * d;
		} else {
			throw new IllegalArgumentException("The numbers are not even.");
		}
	}
	
	public int randomNumberSquared() {
		getRandomInt();
		int result = 0 + getRandomInt();
		return result * result;
		
	}
	
	public int getRandomInt() {
		Random random = new Random();
		return random.nextInt(10) + 1;
		
	}

}


