package Week06_Project;

import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		
		//Create the deck and shuffle it
		Deck testDeck = new Deck();
		testDeck.shuffle();
		
		//Create the two players and have them draw their cards.
		List<Card> emptyList1 = new ArrayList<Card>();
		List<Card> emptyList2 = new ArrayList<Card>();
		Player player1 = new Player("Jason", emptyList1);
		Player player2 = new Player("May", emptyList2);
		
		for(int i = 0; i < 52; i++) {
			if(i % 2 == 0) {
				player1.draw(testDeck);
			}
			else {
				player2.draw(testDeck);
			}
		}
		testDeck.describe();
		player1.describe();
		player2.describe();
		
		//Play War. Have each player flip all 26 of their cards, in the order they drew them.
		for(int i = 0; i < 26; i++) {
			Card player1Card = player1.flip();
			Card player2Card = player2.flip();
			String point = "";
			//whomever's card has a higher value gets a point
			if(player1Card.getValue() > player2Card.getValue()) {
				player1.incrementScore();
				point = player1.getName();
			}
			else if(player2Card.getValue() > player1Card.getValue()) {
				player2.incrementScore();
				point = player2.getName();
			}
			
			System.out.print(player1.getName() + " plays the " + player1Card.getName() + " and " + 
								player2.getName() + " plays the " + player2Card.getName() + ".  ");
			
			//Tell the user the cards that have been played and who earns a point.
			if(point != "") {
				System.out.println(point + " got a point!");
			}
			else {
				System.out.println("Draw, no point awarded.");
			}
		}
		
		//Tell the user the final score.
		System.out.println("\n" + player1.getName() + " has "  + player1.getScore() + " points, and " + 
							player2.getName() + " has " + player2.getScore() + " points.");
		if(player1.getScore() > player2.getScore()) {
			System.out.println("Player 1, " + player1.getName() + ", wins!");
		}
		else if(player2.getScore() > player1.getScore()) {
			System.out.println("Player 2, " + player2.getName() + ", wins!");
		}
		else {
			System.out.println("A draw overall. nobody wins.");
		}

	}

}
