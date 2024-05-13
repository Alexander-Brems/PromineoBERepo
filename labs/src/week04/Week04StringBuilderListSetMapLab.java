package week04;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Week04StringBuilderListSetMapLab {

	public static void main(String[] args) {
		
		// 1. Why would we use a StringBuilder instead of a String?
		// 		a. Instantiate a new StringBuilder
		//		b. Append the characters 0 through 9 to it separated by dashes
		// 				Note:  make sure no dash appears at the end of the StringBuilder
		StringBuilder StringB1 = new StringBuilder();
		for (int i = 0; i < 9; i++) {
			StringB1.append(i + "-");	
			}
		StringB1.append("9");
		System.out.println(StringB1.toString());

		
		// 2. List of String:
		//		a. Create a list of Strings 
		//		b. Add 5 Strings to it, each with a different length
		
		List<String> StringList2 = new ArrayList<String>(); //remember the List and ArrayList imports at the top!
		StringList2.add("Tom");
		StringList2.add("Josh");
		StringList2.add("Mason");
		StringList2.add("Me");
		StringList2.add("Tomson");

		
		// 3. Write and test a method that takes a list of strings 
		//			and returns the shortest string
		System.out.println(FindShortestString(StringList2));

		
		// 4. Write and test a method that takes a list of strings 
		//			and returns the list with the first and last element switched
		List<String> StringList4 = SwitchFirstAndLast(StringList2);
		System.out.println("The first item is: " + StringList4.get(0) + ", and the last item is: " + StringList4.get(StringList4.size()-1));

		
		// 5. Write and test a method that takes a list of strings 
		//			and returns a string with all the list elements concatenated to each other,
		// 			separated by a comma
		System.out.println(OneBigString(StringList2));

		
		// 6. Write and test a method that takes a list of strings and a string 
		//			and returns a new list with all strings from the original list
		// 			containing the second string parameter (i.e. like a search method)
		List<String> List5 = FindMatchingStrings(StringList2, "son");
		for (String word : List5) {
			System.out.print(word + ", ");
		}
		System.out.println();

		
		// 7. Write and test a method that takes a list of integers 
		//			and returns a List<List<Integer>> with the following conditions specified
		//			for the return value:
		//		a. The first List in the returned value contains any number from the input list 
		//			that is divisible by 2
		//		b. The second List contains values from the input list that are divisible by 3
		//		c. The third containing values divisible by 5, and 
		//		d. The fourth all numbers from the input List not divisible by 2, 3, or 5
		List<Integer> List7 = new ArrayList<Integer>();
		List7.add(8); List7.add(15); List7.add(13); List7.add(49); List7.add(30); List7.add(48); List7.add(6); List7.add(69);
		List<List<Integer>> NestedList7 = DivisibleNumbers(List7);
		for (List<Integer> values : NestedList7) {
			for (int num : values) {
				System.out.print(num + ", ");
			}
			System.out.println();
		}

		
		// 8. Write and test a method that takes a list of strings 
		//			and returns a list of integers that contains the length of each string
		List<Integer> List8 = LengthOfStrings(StringList2);
		for(int num : List8) {
			System.out.print(num + ", ");
		}
		System.out.println();


		
		// 9. Create a set of strings and add 5 values
		Set<String> set9 = new HashSet<String>(); //remember the Set and HashSet imports at the top!
		set9.add("Sword"); set9.add("Spear"); set9.add("Shield"); set9.add("Bow"); set9.add("Fists");

		
		
		// 10. Write and test a method that takes a set of strings and a character 
		//			and returns a set of strings consisting of all the strings in the
		// 			input set that start with the character parameter.
		Set<String> set10 = FindStartingChar(set9, 'b');
		for (String word : set10) {
			System.out.print(word + ", ");
		}
		System.out.println();


		
		// 11. Write and test a method that takes a set of strings 
		//			and returns a list of the same strings
		List<String> list11 = ChangeToList(set9);
		for (String word : list11) {
			System.out.print(word + ", ");
		}
		System.out.println();
		

		// 12. Write and test a method that takes a set of integers 
		//			and returns a new set of integers containing only even numbers 
		//			from the original set
		Set<Integer> setOfNums = new HashSet<Integer>();
		setOfNums.add(13); setOfNums.add(26); setOfNums.add(69); setOfNums.add(14); setOfNums.add(0); setOfNums.add(10);
		Set<Integer> set12 = ReturnEvens(setOfNums);
		for (int value : set12) {
			System.out.print(value + ", ");
		}
		System.out.println();

		
		// 13. Create a map of string and string and add 3 items to it where the key of each
		// 			is a word and the value is the definition of the word
		Map<String, String> map13 = new HashMap<String, String>(); //remember the Map and HashMap imports at the top!
		map13.put("Port", "The left side of a boat."); map13.put("Starboard", "The right side of a boat."); map13.put("Bow", "The front end of a boat.");

	
		
		// 14. Write and test a method that takes a Map<String, String> and a string 
		// 			and returns the value for a key in the map that matches the
		// 			string parameter (i.e. like a language dictionary lookup)
		System.out.println(LookupMapValue(map13, "Starboard"));

		
		// 15. Write and test a method that takes a List<String> 
		//	and returns a Map<Character, Integer> containing a count of 
		//	all the strings that start with a given character
		Map<Character, Integer> map15 = ReturnStartingChars(StringList2);
		for (char key: map15.keySet()) {
			System.out.print(key + " is seen " + map15.get(key) + " times. ");
		}
		System.out.println();
		

	}
	
	
	// Method 15:
	public static Map<Character, Integer> ReturnStartingChars(List<String> inputList){
		Map<Character, Integer> outputMap = new HashMap<Character, Integer>();
		for (String word : inputList) {
			char value = word.toLowerCase().charAt(0);
			if (outputMap.containsKey(value)) {
				outputMap.put(value, outputMap.get(value)+1);
			}
			else {
				outputMap.put(value, 1);
			}
		}
		return outputMap;
	}
	
	
	// Method 14:
	public static String LookupMapValue(Map<String, String> map, String input) {
		for (String word : map.keySet()) {
			if(word.equals(input)) {
				return map.get(word);
				}
			}
		return "Key: '" + input + "' cannot be found";
		}

	
	// Method 12:
	public static Set<Integer> ReturnEvens (Set<Integer> inputSet) {
		Set<Integer> outputSet = new HashSet<Integer>();
		for(int num : inputSet) {
			if(num % 2 == 0) {
				outputSet.add(num);
			}
		}
		return outputSet;
	}

	
	// Method 11:
	public static List<String> ChangeToList(Set<String> inputSet) {
		List<String> outputList = new ArrayList<String>();
		for(String word : inputSet) {
			outputList.add(word);
		}
		return outputList;
	}


	// Method 10:
	public static Set<String> FindStartingChar (Set<String> inputSet, char inputChar){
		Set<String> outputSet = new HashSet<String>();
		for (String word : inputSet) {
			if(word.toLowerCase().charAt(0) == Character.toLowerCase(inputChar)) {
				outputSet.add(word);
			}
		}
		return outputSet;
	}

	
	// Method 8:
	public static List<Integer> LengthOfStrings(List<String> inputList){
		List<Integer> outputList = new ArrayList<Integer>();
		for(String word : inputList) {
			outputList.add(word.length());
		}
		return outputList;
	}

	
	// Method 7:
	public static List<List<Integer>> DivisibleNumbers(List<Integer> numList){
		List<List<Integer>> outputList = new ArrayList<List<Integer>>();
		outputList.add(new ArrayList<Integer>()); outputList.add(new ArrayList<Integer>()); outputList.add(new ArrayList<Integer>()); outputList.add(new ArrayList<Integer>());
		for(int num : numList) {
			if(num % 2 == 0) {
				outputList.get(0).add(num);
			}
			if(num % 3 == 0) {
				outputList.get(1).add(num);
			}
			if(num % 5 == 0) {
				outputList.get(2).add(num);
			}
			if(num % 2 != 0 & num % 3 != 0 & num % 5 != 0) {
				outputList.get(3).add(num);
			}
		}
		return outputList;
	}

	
	// Method 6:
	public static List<String> FindMatchingStrings(List<String> inputList, String match){
		List<String> outputList = new ArrayList<String>();
		for(String word : inputList) {
			if(word.toLowerCase().contains(match.toLowerCase())) {
				outputList.add(word);
			}
		}
		return outputList;
	}

	
	// Method 5:
	public static String OneBigString(List<String> List5){
		String output = "";
		for (String word : List5) {
			output += word + ", ";
		}
		return output;
	}
	
	
	// Method 4:
	public static List<String> SwitchFirstAndLast(List<String> inputList){
		String temp = inputList.get(0);
		List<String> outputList = inputList;
		outputList.set(0, inputList.get(inputList.size()-1));
		outputList.set(inputList.size()-1, temp);
		return outputList;
	}
	
	
	// Method 3:
	public static String FindShortestString(List<String> List3) {
		String output = List3.get(0);
		for (int i = 1; i < List3.size(); i++) {
			if(List3.get(i).length() < output.length()) {
				output = List3.get(i);
			}
		}
		return output;
	}

}
