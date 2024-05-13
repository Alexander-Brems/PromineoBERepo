//
// Copyright (c) 2023 Promineo Tech
// Author:  Promineo Tech Academic Team
// Subject:  Variables & Operations Lab
// Java Week 01 Lab  
//
package week01;

public class Week01VariablesVariablesAndOperationsLab {

	public static void main(String[] args) {
		
		System.out.println("Week 1 Labs:");
		// 1. Create a variable to hold the quantity of 
		//		available plane seats left on a flight		
		int AvailSeats = 7;

		
		// 2. Create a variable to hold the cost of groceries at checkout
		double GroceryCost = 27.99;

		
		// 3. Create a variable to hold a person's middle initial
		char MiddleInitial = 'E';

	
		// 4. Create a variable to hold true if it's hot outside 
		//		and false if it's cold outside
		boolean IsHotOutside = false;

		
		// 5. Create a variable to hold a customer's first name
		String CustomerName = "John";

		
		// 6. Create a variable to hold a street address
		String StreetAddress = "1312 Oh Street, Unit 27";
		

		// 7. Print all variables to the console
		System.out.println(
				"Plane Seats: " + AvailSeats + "\nCheckout Cost: " + GroceryCost + "\nJohn's Middle Initial: " + MiddleInitial + "\nIs it hot outside?: " + IsHotOutside + 
				"\nFirst Customer's name: " + CustomerName + "\nCustomer's Address: " + StreetAddress
				);
	

		// 8. A customer booked 2 plane seats, 
		//		remove 2 seats from the available seats variable
		AvailSeats -= 2;
		System.out.println("New Booking. Now only "+AvailSeats+" are left.");
	

		// 9. Impulse candy bar purchase, add 2.15 to the grocery total
		// 		costOfGroceries = costOfGroceries + 2.15;
		GroceryCost = GroceryCost + 2.15;
		System.out.println("New Grocery Total is "+GroceryCost+".");


		// 10.  The birth certificate was printed incorrectly, 
		//		change the middle initial to something else
		MiddleInitial = 'D';
		System.out.println("New initial is "+MiddleInitial+".");
		

		// 11.  The season has changed, update the hot outside 
		//			variable to be opposite of what it was
		IsHotOutside = true;
		System.out.println("Is it hot outside in summer?: "+IsHotOutside);


		// 12.  Create a new variable called full name using the customer's first name, 
		//			the middle initial, and a last name of your choice
		CustomerName = "Mark";
		System.out.println("Our new customer's name is: "+CustomerName+" "+MiddleInitial+". "+"Goedde.");
	

		// 13.  Print a line to the console that introduces the customer and says they live
		// 			at the address variable
		System.out.println(CustomerName+" lives at "+StreetAddress+".");

	}

}
