/**
 * 
 */
package week06;


import java.util.Scanner;
/**
 * 
 */
public class TicTacToeBoard {

	String[][] board = new String[3][3];
	
	public void initialize() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = " ";
			}
		}
	}
	
	
	public void display() {
		System.out.println("     +---+---+---+");
		System.out.println("     | " + this.board[0][0] + " | " + this.board[0][1] + " | " + this.board[0][2] + " | ");
		System.out.println("     +---+---+---+");
		System.out.println("     | " + this.board[1][0] + " | " + this.board[1][1] + " | " + this.board[1][2] + " | ");
		System.out.println("     +---+---+---+");
		System.out.println("     | " + this.board[2][0] + " | " + this.board[2][1] + " | " + this.board[2][2] + " | ");
		System.out.println("     +---+---+---+");
	}
	
	
	public String checkWinStatus(int input) {
		if(validateInput(input)) {
			int[] location = findLocation(input);
			int row = location[0];
			int col = location[1];
			String placedChar = this.board[row][col];
			String win = placedChar + placedChar + placedChar; 
			if((this.board[row][0] + this.board[row][1] + this.board[row][2]).equals(win) ||
				(this.board[0][col] + this.board[1][col] + this.board[2][col]).equals(win) ||
				(this.board[0][0] + this.board[1][1] + this.board[2][2]).equals(win) ||
				(this.board[0][2] + this.board[1][1] + this.board[2][0]).equals(win)) {
				return placedChar;
			}
			else {
				boolean spaceFound = false;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if(this.board[i][j] == " ") {
							spaceFound = true;
							break;
						}
						else if (!spaceFound && i+j == 4) {
							return "draw";
						}
					}
					if(spaceFound) {
						break;
					}
				}
				return "";
			}
		}
		else {
			return "err";
		}
	}
	
	
	public boolean validateInput(int input) {
		if(input < 1 || input > 9) {
			System.out.println("That is not a valid number. Please select a number from 1-9. The locations go from left to right, then top to bottom.");
			return false;
		}
		else {
			return true;
		}
	}
	
	
	public int[] findLocation(int input) {
		int[] output = new int[2];
		output[0] = 0;
		output[1] = -1;
		while (input > 3) {
			output[0]++;
			input -= 3;
		}
		output[1] += input;
		return output;
	}
	
	
	public void playGame() {
		
		//setup the variables we'll need
		Scanner userInput = new Scanner(System.in);
		this.initialize();
		String player = "X";
		String outcome = "";
		System.out.println("\nTime to play Tic-Tac-Toe!\n");
		
		//while we don't yet know the outcome
		while (outcome == "") {
			
			//show the board and ask for input
			this.display();
			System.out.println("\n" + player + "'s turn. Please enter a number from 1-9:");
			String input = "";
			int inputNum = -1;
			boolean noError = true;
			
			//check for invalid inputs
			try {
				input = userInput.nextLine();
				inputNum = Integer.valueOf(input);
				noError = validateInput(inputNum);
			}
			catch(Exception e) {
				System.out.println("That is not a number. Please enter a number from 1-9.");
				noError = false;
			}
			
			if (noError) {
				//if we have a valid input, place the marker and check the outcome
				int[] location = findLocation(inputNum);
				int row = location[0];
				int col = location[1];
				if(this.board[row][col] == " ") {
					this.board[row][col] = player;
					outcome = checkWinStatus(inputNum);
					if (player == "X") {
						player = "O";
					}
					else {
						player = "X";
					}
				}
				else {
					System.out.println("That location has already been filled. Please select a new location.");
				}
			}
		}
		
		//once we have the outcome, show it to the players and say who (did not) win
		this.display();
		if(outcome == "draw") {
			System.out.println("The game is over. Nobody wins!");
		}
		else {
			System.out.println("Player " + outcome + " is the winner!");
		}
		
		userInput.close();
	}
	
}
