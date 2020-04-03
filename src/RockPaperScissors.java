import java.util.Scanner;
import java.lang.Enum;

// Main class of Rock Paper Scissors Game.  Game ends when user chooses to quit or when a player's 
// score reaches 10

public class RockPaperScissors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Initialization and print welcome messages
		
		final String WelcomeMsg = "Get Ready to Play Rock Paper Scissors";
		Scanner kb = new Scanner(System.in);
		int choice;
		Player winner; // pointer to winning Player
		Computer computerPlayer = new Computer();
		DecisionMaker decisionMaker = new DecisionMaker();
		
		System.out.println("Please enter your name");
		HumanPlayer humanPlayer = new HumanPlayer(kb.nextLine());
		
		System.out.println("Hi " + humanPlayer.getName() + "! " + WelcomeMsg);
		
		Choice[] menuChoice = Choice.values();
		
		
		do {
			
			
			try {
				System.out.println();
				System.out.println("Please enter a move.");
				for (Choice c: menuChoice) {
					System.out.print(c + " = " + c.ordinal() + " ");
				}
				System.out.println();
				
				choice = Integer.parseInt(kb.nextLine());
				
				
				if (choice == Choice.QUIT.ordinal()) { // Quit
					break;
				}
				else if (choice >= Choice.ROCK.ordinal() && choice <= Choice.SCISSORS.ordinal()) 
				{
					humanPlayer.setChoice(choice); 
					System.out.println("You entered " + menuChoice[humanPlayer.getChoice()].toString());
					
				
					computerPlayer.setChoice();
					System.out.println("Computer generated " + menuChoice[computerPlayer.getChoice()].toString());
				}
				else 
				{
					throw new InvalidSelectionException();
				}
				
				winner = decisionMaker.getWinner(humanPlayer, computerPlayer);
				
				
				// Update the winning player score unless there is a tie
				if (winner != null) {
					winner.setScore(winner.getScore() + 1);
				}
				 
			}
			catch (NumberFormatException|InvalidSelectionException e) 
			{
				System.out.println("Invalid Entry!  Please enter 0, 1, 2, or 3");
			    continue;
			}
			
			
		// end game when either player reaches a score of 10
			
		} while ((humanPlayer.getScore() < Player.MAX_SCORE) && (computerPlayer.getScore() < Player.MAX_SCORE));
		
		
		decisionMaker.displayFinalResults(humanPlayer, computerPlayer);
		
		kb.close();
		

	}

}
