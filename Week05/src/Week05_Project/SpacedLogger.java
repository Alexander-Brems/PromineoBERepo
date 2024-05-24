package Week05_Project;

public class SpacedLogger implements Logger {

	@Override
	public void log(String input) {
		String output = "";
		for(int i = 0; i < input.length(); i++) {
			output += input.charAt(i) + " ";
		}
		output = output.stripTrailing();
		System.out.println(output);

	}

	@Override
	public void error(String input) {
		String output = "";
		for(int i = 0; i < input.length(); i++) {
			output += input.charAt(i) + " ";
		}
		output = output.stripTrailing();
		System.out.println("ERROR: " + output);

	}

}
