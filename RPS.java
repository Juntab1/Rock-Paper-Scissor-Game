import java.util.*;

public class RPS{
    public static int userInput;
    public static int numChosen;

    public RPS(){
        userInput = -1;
        numChosen = -1;
    }
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        String[] choices = new String[3];
        choices[0] = "ROCK";
        choices[1] = "PAPER";
        choices[2] = "SCISSORS";
        Random rand = new Random();
        System.out.println("Welcome to my rock paper scissors game!");
        System.out.println("Let us get started!");
        askUser(input, rand);
        // fix the error of if a user inputs a number greater than 3 they should get an try again!
        if ( 3 > userInput && userInput >= 0 && 3 > numChosen && numChosen >= 0){
            System.out.println("You chose " + choices[userInput] + " and the computer chose " + choices[numChosen]);
            if (userInput == numChosen){
                System.out.println("That is a draw! Chose again!");
                askUser(input, rand);
            }
            else if (userInput == 0 && numChosen == 1){
                System.out.println("You have lost!");
            }
            else if (userInput == 0 && numChosen == 2){
                System.out.println("You have Won!");
            }
            else if (userInput == 1 && numChosen == 0){
                System.out.println("You have Won!");
            }
            else if (userInput == 1 && numChosen == 2){
                System.out.println("You have Lost!");
            }
            else if (userInput == 2 && numChosen == 0){
                System.out.println("You have Lost!");
            }
            else if (userInput == 2 && numChosen == 1){
                System.out.println("You have Won!");
            }
            else{
                System.out.println("Enter an acceptable value!");
                askUser(input, rand);
            }
        }

    }

    public static void askUser(Scanner input, Random rand){
        System.out.println("Rock is 0? Paper is 1? Scissors is 2? -->");
        userInput = input.nextInt();
        numChosen = rand.nextInt(2);
    }
}