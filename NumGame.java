import java.lang.*;
import java.util.Scanner;

public class NumGame{
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    boolean playing = true;
	    int round = 1;
	    int totalPoints = 0;
		do{
		    System.out.println("------------------------"+"Round "+ round +"------------------------");
		    int roundPoints = GuessGame();
            totalPoints += roundPoints;
            System.out.println("Your score for Round "+round+" is "+ roundPoints);
            System.out.println("Your total score is "+ totalPoints);
		    System.out.println("Do you wish to play again? (y/n)");
		    String answer = sc.nextLine();
		    playing = answer.equalsIgnoreCase("y");
		    round++;
		}while(playing);
		System.out.println("Thank you for playing! Goodbye.");

	}
    public static int GuessGame(){
    int num = (int)(Math.random() * 100)+1;
		int tries = 5;
		Scanner scg = new Scanner(System.in);
		boolean correct = false;
		int roundPoints = 0;
	    System.out.println("I have selected a number between 1 and 100. Let's see if you can guess the number is 5 tries or fewer !");
		System.out.println("Enter your guess: ");
		while(tries > 0){
		    int guess = scg.nextInt();
		    if(guess == num){
		        System.out.println("Your guess is right! You win!");
		        correct = true;
		        if(tries == 5)
		            roundPoints=5;
		        else if(tries == 4)
		            roundPoints=4;
		        else if(tries == 3)
		            roundPoints=3;
		        else if(tries == 2)
		            roundPoints=2;
		        else if(tries == 1)
		            roundPoints=1;
		        break;
		    }
		    if (guess > num){
		        System.out.println("Your guess is too high.");
                System.out.println("You have " + (tries - 1) + " tries left.");
		        if(tries!=1){
		            System.out.println("Try again:");
		        }
		        tries--;
		    }
		    if(guess < num){
		        System.out.println("Your guess is too low.");
                System.out.println("You have " + (tries - 1) + " tries left.");
		        if(tries!=1){
		            System.out.println("Try again:");
		        }
		        tries--;
		    }
		    
		}
		if (correct == false)
		   System.out.println("Oops! You ran out of tries. You lose! The number was "+ num+".");

        
        return roundPoints;
    }
}


