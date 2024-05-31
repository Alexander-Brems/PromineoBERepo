package Week06_Project;

public class Card {

	private String name;
	private int value;
	
	Card(String name, int value) {
		this.name = name;
		this.value = value;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public void describe() {
		System.out.println("The " + this.name + ". It is worth: " + this.value);
	}
	
}
