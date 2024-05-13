package week03;

public class Week03ArraysAndMethodsLab {

	public static void main(String[] args) {
		//
		// Arrays:
		//
		
		// 1. Create an array with the following values 1, 5, 2, 8, 13, 6
		int[] numArray = new int[6];
		numArray[0] = 1;
		numArray[1] = 5;
		numArray[2] = 2;
		numArray[3] = 8;
		numArray[4] = 13;
		numArray[5] = 6;

		
		// 2. Print out the first element in the array
		System.out.println(numArray[0]);
	
		
		// 3. Print out the last element in the array without using the number 5
		System.out.println(numArray[numArray.length-1]);
		
		// 4. Print out the element in the array at position 6, what happens?
		//System.out.println(numArray[6]); - throws Out Of Bounds error

		
		// 5. Print out the element in the array at position -1, what happens?
		//System.out.println(numArray[-1]); - throws Out Of Bounds error
			
		// 6. Write a traditional for loop that prints out each element in the array
		for(int i = 0; i < numArray.length; i++) {
			System.out.println(numArray[i]);
		}
	
			
		// 7. Write an enhanced for loop that prints out each element in the array
		for(int num : numArray) {
			System.out.println(num);
		}
		
		// 8. Create a new variable called sum, write a loop that adds 
		//			each element in the array to the sum
		double sum = 0.0;
		for(int num : numArray) {
			sum += num;
		}
		System.out.println(sum);

			
		// 9. Create a new variable called average and assign the average value of the array to it
		double avg = sum / numArray.length;
		System.out.println(avg);
		
		// 10. Write an enhanced for loop that prints out each number in the array 
		//			only if the number is odd
		for(int num : numArray) {
			if(num % 2 != 0) {
				System.out.println(num);
			}
		}

		
		// 11. Create an array that contains the values "Sam", "Sally", "Thomas", and "Robert"
		String[] nameArray = new String[4];
		nameArray[0] = "Sam";
		nameArray[1] = "Sally";
		nameArray[2] = "Thomas";
		nameArray[3] = "Robert";
		
		// 12. Calculate the sum of all the letters in the new array
		int nameSum = 0;
		for(String name : nameArray) {
			nameSum += name.length();
		}
		System.out.println(nameSum);

		//
		// Methods:
		//
		
		// 13. Write and test a method that takes a String name and prints out a greeting. 
		//			This method returns nothing.
		printName("Michael");
		
		
		// 14. Write and test a method that takes a String name and  
		//			returns a greeting.  Do not print in the method.
		System.out.println(returnGreeting("Joshua"));

		
		// Compare method 13 and method 14:  
		//		a. Analyze the difference between these two methods.
		//		b. What do you find? 
		//		c. How are they different?
		// You can store any results from a 'non-void' method as a variable, which may be useful.
		
		
		// 15. Write and test a method that takes a String and an int and 
		//			returns true if the number of letters in the string is greater than the int
		System.out.println(stringLengthCheck("Test", 4));
		
		
		// 16. Write and test a method that takes an array of string and a string and 
		//			returns true if the string passed in exists in the array
		String[] wordArray16 = new String[3];
		wordArray16[0] = "Sam";
		wordArray16[1] = "Sally";
		wordArray16[2] = "Thomas";
		System.out.println(doesStringExist(wordArray16, "Sally"));
		
		
		// 17. Write and test a method that takes an array of int and 
		//			returns the smallest number in the array
		int[] numArray17 = new int[] {21, 5, 23, 8, 13, 6, 3, 34};
		System.out.println(smallestNumber(numArray17));
	
		
		// 18. Write and test a method that takes an array of double and 
		//			returns the average
		double[] numArray18 = new double[] {21.5, 12.2, 27.0, 46.2};
		System.out.println(avgValue(numArray18));

		// 19. Write and test a method that takes an array of Strings and 
		//			returns an array of int where each element
		//			matches the length of the string at that position
		String[] wordArray19 = new String[] {"Sam", "Sally", "Thomas", "Robert", "Josh"};
		int[] numArray19 = lengthOfWords(wordArray19);
		for (int num : numArray19) {
			System.out.print(num + ", ");
		}
		System.out.println("");

				
		// 20. Write and test a method that takes an array of strings and 
		//			returns true if the sum of letters for all strings with an even amount of letters
		//			is greater than the sum of those with an odd amount of letters.
		String[] wordArray20 = new String[] {"Sam", "Sally", "Thomas", "Robert"};
		System.out.println(isEvenLongerThanOdd(wordArray20));

	
		// 21. Write and test a method that takes a string and 
		//			returns true if the string is a palindrome
		System.out.println(isPalindrome("Racecar"));

	}

	// Method 13:
	public static void printName(String name) {
		System.out.println("Hello, "+ name + "!");
	}


	// Method 14:
	public static String returnGreeting(String name) {
		return ("Hello, " + name + "!");
	}

	
	// Method 15:
	public static boolean stringLengthCheck(String word, int num) {
		return (word.length() > num);
	}

	
	// Method 16:
	public static boolean doesStringExist(String[] wordArray, String testWord) {
		boolean check = false;
		for(String value : wordArray) {
			if(testWord == value) {
				check = true;
			}
		}
		return check;
	}

	
	// Method 17:
	public static int smallestNumber(int[] numberArray) {
		int smallNum = numberArray[0];
		for(int value : numberArray) {
			if(value < smallNum) {
				smallNum = value;
			}
		}
		return smallNum;
	}

	
	// Method 18:
	public static double avgValue(double[] numberArray) {
		double avg = 0;
		for (double num : numberArray) {
			avg += num;
		}
		avg /= numberArray.length;
		return avg;
	}

	
	// Method 19:
	public static int[] lengthOfWords(String[] wordArray) {
		int[] numArray = new int[wordArray.length];
		for(int i = 0; i < wordArray.length; i++) {
			numArray[i] = wordArray[i].length();
		}
		return numArray;
	}

	
	// Method 20:
	public static boolean isEvenLongerThanOdd(String[] wordArray) {
		int evenLetters = 0;
		int oddLetters = 0;
		for (String word : wordArray) {
			if(word.length() % 2 == 0) {
				evenLetters += word.length();
			}
			else {
				oddLetters += word.length();
			}
		}
		if(evenLetters > oddLetters) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	// Method 21:
	public static boolean isPalindrome(String word) {
		boolean check = true;
		word = word.toLowerCase();
		for(int i = 1; i <= (word.length() / 2); i++) {
			if(word.charAt(i-1) != word.charAt(word.length()-i)) {
				check = false;
				break;
			}
		}
		return check;
	}
}
