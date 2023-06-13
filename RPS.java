import java.util.*;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;  

public class RPS{
    public static int userInput;
    public static int numChosen;
    public static String playAgain;

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
        tellTime();
        System.out.println("Welcome to my rock paper scissors game!");
        System.out.println("Let us get started!");
        askUser(input, rand, choices);
    }

    public static void askUser(Scanner input, Random rand, String[] choices){
        System.out.println("Rock is 0? Paper is 1? Scissors is 2? -->");
        userInput = input.nextInt();
        numChosen = rand.nextInt(0,3);
        if ( 3 > userInput && userInput >= 0 && 3 > numChosen && numChosen >= 0){
            System.out.println("You chose " + choices[userInput] + " and the computer chose " + choices[numChosen]);
            if (userInput == numChosen){
                System.out.println("That is a draw! Chose again!");
                askUser(input, rand, choices);
            }
            else if ((userInput == 0 && numChosen == 1) || (userInput == 1 && numChosen == 2) || (userInput == 2 && numChosen == 0)){
                System.out.println("You have lost!");
                playAgain(input, rand, choices);
            }
            else if ((userInput == 0 && numChosen == 2) || (userInput == 1 && numChosen == 0) || (userInput == 2 && numChosen == 1)){
                System.out.println("You have Won!");
                playAgain(input, rand, choices);
            }
            else{
                incorrectValue(input, rand, choices);
            }
        }
        else{
            incorrectValue(input, rand, choices);
        }
    }

    public static void playAgain(Scanner input, Random rand, String[] choices){
        System.out.println("Play again? Y or N:");
        playAgain = input.next();
        if (playAgain.equals("Y")){
            askUser(input, rand, choices);
        }
        else if (playAgain.equals("N")){
            System.exit(0);
        }
        else{
            System.out.println("Enter an acceptable answer \"Y\" or \"N\" please!");
            playAgain(input, rand, choices);
        }
    }

    public static void incorrectValue(Scanner input, Random rand, String[] choices){
        System.out.println("Enter an acceptable value!");
        askUser(input, rand, choices);
    }

    public static void tellTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
    }
}