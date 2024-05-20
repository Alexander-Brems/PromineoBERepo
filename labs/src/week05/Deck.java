package week05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

	List<Card> cards = new ArrayList<Card>();
	
	Deck() {
		String[] suits = {"Clubs", "Diamonds", "Spades", "Hearts"};
		String[] names = {"Two", "Three", "Four", "Five", "Six", "Seven",
						"Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
		
		for(String type : suits) {
			int value = 2;
			for (String title : names) {
				Card card = new Card(title, type, value);
				this.cards.add(card);
				value++;
			}
		}
	}
	
	public List<Card> getDeck() {
		return cards;
	}
	
	public void setDeck(List<Card> cards) {
		this.cards = cards;
	}
	
	public void describe() {
		for (Card card : this.cards) {
			card.describe();
		}
		System.out.println("There are currently " + this.cards.size() + " cards in the deck.");
	}
	
	public void shuffle() {
		Collections.shuffle(cards);
	}
	
	public Card draw() {
		Card outputCard = this.cards.remove(0);
		return outputCard;
	}
	
	public List<Card> draw(int num) {
		if(num > 0) {
			List<Card> outputCards = new ArrayList<Card>();
			for(int i = 0; i < num; i++) {
				outputCards.add(draw());
			}
			return outputCards;
		}
		else {
			System.out.println("ERR");
			return null;
		}
	}
	
}
