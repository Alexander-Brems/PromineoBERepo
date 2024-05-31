package Week06_Project;

import java.util.List;

public class Player {

	private String name;
	private List<Card> hand;
	private int score;
	
	Player(String name, List<Card> hand) {
		this.name = name;
		this.hand = hand;
		this.score = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Card> getHand() {
		return this.hand;
	}
	
	public void setHand(List<Card> hand) {
		this.hand = hand;;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void describe() {
		System.out.println(this.name + " has a score of " + this.score + 
				" and the following " + this.hand.size() + " cards:");
		for(Card card : this.hand) {
			card.describe();
		}
		System.out.println();
	}
	
	public Card flip() {
		return this.hand.remove(0);
	}
	
	public void draw(Deck cards) {
		this.hand.add(cards.draw());
	}
	
	public void incrementScore() {
		this.score++;
		this.getScore();
	}
	
}
