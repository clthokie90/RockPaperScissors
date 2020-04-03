
import java.lang.Math;

// Class to represent the Computer Player

public class Computer extends Player {
	final String COMPUTER = "Computer";
	final static int MIN = 1;
	final static int MAX = 3;


	public Computer() {
		
		super.setName(COMPUTER);
		
	}
	
	// Generates a random number within range of min and max
	public static int generateRandomIntegerInRange(int min, int max)
		
	{
		int x = (int)(Math.random() * ((max-min)+1)) + min;
		
		return x;
	}
	
	public static int generateRandomChoice() 
	{
		return generateRandomIntegerInRange(MIN, MAX);
	}

	// generates a random choice in the range of 1-3
	
	public void setChoice() {
		// TODO Auto-generated method stub
		super.setChoice(generateRandomIntegerInRange(MIN, MAX));
	} 	
	

}
