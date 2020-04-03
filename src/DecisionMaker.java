

public class DecisionMaker {

	final static int ROCK = Choice.ROCK.ordinal(), PAPER = Choice.PAPER.ordinal(), SCISSORS = Choice.SCISSORS.ordinal();
	
	
	// Contains logic to determine winner.  Return null if there is a tie, otherwise return winning player
	
	Player getWinner(Player humanPlayer, Player computerPlayer)
	{
		int human = humanPlayer.getChoice();
		int computer = computerPlayer.getChoice();
		
		Player winner = humanPlayer;
		
		if (human == computer) {
			System.out.println("It's a tie!");
			winner = null;
		}
		else if (human == ROCK)
        {
	        if (computer == SCISSORS)
		        System.out.println("You win!! Rock crushes scissors.");
	        else if (computer == PAPER)
	        {
		        System.out.println("You lose!! Paper eats rock.");
		        winner = computerPlayer;
	        }    
        } 
        else if (human == PAPER) 
        {
            if (computer == ROCK)
		        System.out.println("You win!! Paper eats rock.");
	        else if (computer == SCISSORS)
	        {	
		        System.out.println("You lose!! Scissor cuts paper.");
		        winner = computerPlayer;
	        }    
        } 
        else if (human == SCISSORS) 
        {
	        if (computer == PAPER)
		        System.out.println("You win!! Scissor cuts paper.");
	        else if (computer == ROCK)
	        {	
		        System.out.println("You lose!! Rock breaks scissors.");
		        winner = computerPlayer;
	        }   
        } 
		
		return winner;
	}
	
	
	public void displayFinalResults(Player player1, Player player2)
	{
		
		Player winner;
		
		System.out.println("\nFINAL RESULTS");
		
		if (player1.getScore() == player2.getScore()) 
		{
			System.out.println("It's a Tie!");
		}
		else {
			winner = player1.getScore() > player2.getScore() ? player1: player2;
			System.out.println(winner.getName() + " Wins!");
		}
		
		System.out.println(player1.getName() + ": " + player1.getScore());
		System.out.println(player2.getName() + ": " + player2.getScore());
		
		
	}
}
