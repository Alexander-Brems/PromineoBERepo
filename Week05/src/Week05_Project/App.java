package Week05_Project;

public class App {

	public static void main(String[] args) {
		
		AsteriskLogger Astley = new AsteriskLogger();
		SpacedLogger Spacy = new SpacedLogger();
		
		Astley.log("Never gonna");
		Astley.error("Give you up");
		
		Spacy.log("Whoa");
		Spacy.error("Space");

	}

}
