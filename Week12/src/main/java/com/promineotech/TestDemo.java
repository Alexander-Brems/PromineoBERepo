package com.promineotech;

import java.util.Random;

public class TestDemo {

	public int addPositive(int x, int y) {
		if(x > 0 && y > 0) {
			return x+y;
		}
		else {
			throw new IllegalArgumentException("Both parameters must be positve (greater than 0).");
		}
	}
	
	//This method returns a single String that is the concatenation of the two inputs. However, it throws an exception if either string is more than one word (ie: they contain a space)
	public String concatWords(String word1, String word2) {
		if(!word1.contains(" ") && !word2.contains(" ")) {
			return word1+word2;
		}
		else {
			throw new IllegalArgumentException("Both parameters must be single words (there cannot be any spaces).");
		}
	}
	
	public int randomNumberSquared() {
		int num = getRandomInt();
		return num * num;
	}
	
	public int getRandomInt() {
		Random roll = new Random();
		return roll.nextInt(10) + 1;
	}
	
}
