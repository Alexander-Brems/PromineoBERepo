package Week04_Project;

import java.util.ArrayList;
import java.util.List;

public class Week04_Project {

	public static void main(String[] args) {
		
		
		// 1. Create an array of integers called 'ages' with the following pre-determined values: 3, 9, 23, 64, 2, 8, 28, 93
		int[] ages = {3, 9, 23, 64, 2, 8, 28, 93};
		for (int num : ages) {
			System.out.print(num + ", ");
		}
		System.out.println();
		
		
		// 1a. subtract the first value from the last value in the array
		ages = SubtractFirstFromLast(ages);
		for (int num : ages) {
			System.out.print(num + ", ");
		}
		System.out.println();
		
		
		// 1b. Create a second array of integers called 'ages2' with 9 elements
		int[] ages2 = {13, 18, 84, 56, 27, 72, 29, 8, 10};
		for (int num : ages2) {
			System.out.print(num + ", ");
		}
		System.out.println();
		
		// 1bii. subtract the first element from the last element.
		ages2 = SubtractFirstFromLast(ages2);
		for (int num : ages2) {
			System.out.print(num + ", ");
		}
		System.out.println();
		
		
		// 1c. Use a loop to calculate the average age in the given array
		int avgAge = 0;
		// sum up the values of the array
		for (int num : ages2) {
			avgAge += num;
		}
		// divide that sum by the number of integers in the array and print it out
		avgAge /= ages2.length;
		System.out.println("The average age within the second array is: " + avgAge);
		
		
		// 2. Create an array of Strings called 'names' with the following pre-determined values: 
		// “Sam”, “Tommy”, “Tim”, “Sally”, “Buck”, “Bob”.
		// 2a. Use a loop to calculate the average number of letters per name.
		// 2b. Use a loop to concatenate all the names together, separated by spaces.
		String[] names = {"Sam", "Tommy", "Tim", "Sally", "Buck", "Bob"};
		double avgNameLength = 0.0;
		String allTheNames = "";
		// I created a single for loop to both sum up the length of every name in the array and to also concatenate them all into one string
		for (String name : names) {
			avgNameLength += name.length();
			allTheNames += (name + ", ");
		}
		avgNameLength /= names.length;
		System.out.println("The average name length is: " + avgNameLength);
		System.out.println(allTheNames);
		
		
		// 3. How do you access the last element of any array?
		// By utilizing the 'length of the array - 1'. Because arrays always start at 0, you can subtract 1 to find the last item, as shown below.
		System.out.println("The last name in the array is: " + names[names.length-1]);
		
		
		// 4. How do you access the first element of any array?
		// Arrays always start at 0, so if you use 'array[0]', you will always get the first item, as shown below.
		System.out.println("The first name in the array is: " + names[0]);
		
		
		
		// 5. Create an array of integers called 'nameLengths'. 
		// Create a loop to set each of the values in 'nameLengths' to the length of each name in the 'names' array.
		// 6. Create a loop that sums all of the values in the 'nameLengths' array.
		int[] nameLengths = new int[names.length];
		int nameLengthsSum = 0;
		// I created a single for loop to both set the lengths of the array required in 5, and then use each length as it is set to get that sum
		for (int i = 0; i < names.length; i++) {
			nameLengths[i] = names[i].length();
			nameLengthsSum += nameLengths[i];
			System.out.print(nameLengths[i] + ", ");
		}
		System.out.println();
		System.out.println("The sum of the name lengths is: " + nameLengthsSum);
		
		
		// 7. Create a method that takes in a String 'word' and an int, 'n', and returns the String concatenated to itself 'n' number of times.
		System.out.println(RepeatWord("Pyre", 4));
		
		
		// 8. Create a method that takes in two Strings, 'firstName' and 'lastName', and returns a String that is both names concatenated with a space between them.
		System.out.println(CreateFullName("Sybil", "Reisz"));
		
		
		// 9. Create a method that takes an array of integers and returns true if the sum of the integers in the array is greater than 100.
		int[] array9 = {25, 33, 16, 20, 12};
		System.out.println(GreaterThan100(array9));
		
		
		// 10. Create a method that takes an array of doubles and returns the average of the doubles in the array.
		double[] array10 = {3.4, 12.0, 15.8, 26.2};
		System.out.println(GetAverageOfArray(array10));
		
		
		// 11. Create a method that takes two arrays of doubles, and returns true if the average of the first array is greater than the average of the second array
		double[] array11 = {4.2, 8.6, 5.0};
		System.out.println(FirstAvgIsGreater(array10, array11));
	
		
		// 12. Create a method called 'willBuyDrink' that takes a boolean called 'isHotOutside' and a double called 'moneyInPocket', 
		// and returns true if 'isHotOutside' is true AND 'moneyInPocket' is greater than 10.5
		System.out.println(willBuyDrink(true, 10.5));
		
		
		// 13. Create a method of your own that solves a problem.
		// My method takes in a list of integers and sorts them from lowest to highest. It works best when the list of integers is not very long.
		List<Integer> jumbledList = new ArrayList<Integer>();
		jumbledList.add(12); jumbledList.add(8); jumbledList.add(0); jumbledList.add(12); jumbledList.add(16); jumbledList.add(3);
		// show the jumbled-up List beforehand
		for (int num : jumbledList) {
			System.out.print(num + ", ");
		}
		System.out.println();
		List<Integer> sortedList = SortIntegers(jumbledList);
		//show the new sorted List, yaaaay
		for (int num : sortedList) {
			System.out.print(num + ", ");
		}
		System.out.println();
		
	}

	
	// 1biii. by using this method, and utilizing the length of the array as a way to get the last value in the given array, 
	// this will always subtract the first value from the last value, even if there is only one value in the array.
	public static int[] SubtractFirstFromLast(int[] inputArray) {
		//find the last number in the array, and subtract the first number in the array from the last one
		inputArray[inputArray.length-1] -= inputArray[0];
		return inputArray;
	}
	
	
	// Method 7
	public static String RepeatWord(String word, int n) {
		String output = "";
		if(n > 0) {
			// if I get a positive number, then repeat it that many times
			for (int i = 0; i < n; i++) {
				output += word;
			}
		}
		// if I get a non-positive number in, let the user know
		else {
			output = "That is not a positive number. Your word is: " + word;
		}
		return output;
	}
	
	
	// Method 8
	public static String CreateFullName(String firstName, String lastName) {
		// just put them together in the return statement. who needs variables.
		return (firstName + " " + lastName);
	}
	
	
	// Method 9
	public static boolean GreaterThan100(int[] inputArray) {
		int sum = 0;
		// add each number to a sum - if the sum gets over 100 at any point, stop and return true
		for (int num : inputArray) {
			sum += num;
			if (sum > 100) {
				return true;
			}
		}
		// otherwise, we've gone through the whole array and the sum is not big enough, so return false
		return false;
	}
	
	
	// Method 10
	public static double GetAverageOfArray(double[] inputArray) {
		double avg = 0.0;
		// sum up all of the values in the array
		for(double num : inputArray) {
			avg += num;
		}
		// divide that sum by the number of values in the array
		avg /= inputArray.length;
		return avg;
	}
	
	
	// Method 11
	public static boolean FirstAvgIsGreater(double[] firstArray, double[] secondArray) {
		double avg1 = 0.0;
		double avg2 = 0.0;
		// sum up all of the values in the first array
		for (double num : firstArray) {
			avg1 += num;
		}
		// divide that sum by the number of values in the first array
		avg1 /= firstArray.length;
		// sum up all of the values in the second array
		for (double num: secondArray) {
			avg2 += num;
		}
		// divide that sum by the number of values in the second array
		avg2 /= secondArray.length;
		// compare the two numbers and see which one is bigger
		if (avg1 > avg2) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	// Method 12
	public static boolean willBuyDrink(boolean isHotOutside, double moneyInPocket) {
		// check both of the required values
		if(isHotOutside & moneyInPocket > 10.5) {
			return true;
		}
		// if they both meet the criteria, return true. Otherwise one (or both) have failed, so return false
		else {
			return false;
		}
	}
	
	
	// Method 13
	public static List<Integer> SortIntegers(List<Integer> inputList) {
		// set up our output
		List<Integer> outputList = new ArrayList<Integer>();
		// add the first thing in since there's nothing to compare it against
		outputList.add(inputList.get(0));
		// run through both lists as they are. Every time we add a number, we 'break' so that we don't add it multiple times
		for(int i = 1; i < inputList.size(); i++) {
			for(int j = 0; j < outputList.size(); j++) {
				if(outputList.get(j) >= inputList.get(i)) {
					outputList.add(j, inputList.get(i));
					break;
				}
				// worth noting that if the 'break' in this section is removed, it causes an infinite loop. The size will always get 1 bigger, 
				// so it will add the largest number over and over again unless we specifically tell it to stop
				else if(j == outputList.size()-1) {
					outputList.add(inputList.get(i));
					break;
				}
			}
		}
		// return our newly-sorted list, yaaaay
		return outputList;
	}
	
	
}
