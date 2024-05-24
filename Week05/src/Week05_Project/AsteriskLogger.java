package Week05_Project;

public class AsteriskLogger implements Logger {

	@Override
	public void log(String input) {
		System.out.println("***" + input + "***");

	}

	@Override
	public void error(String input) {
		String box = "*************"; //13 asterisks - same length as the static part of the middle line
		for(int i = 0; i < input.length(); i++) {
			box += "*";
		}
		System.out.println(box);
		System.out.println("***ERROR: " + input + "***");
		System.out.println(box);
	}

}
