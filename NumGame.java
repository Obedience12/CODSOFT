import java.util.Random;
import java.util.Scanner;

public class NumGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int lowNum = 1;
        int highNum = 100;
        int attmpLimit = 10;
        int rounds = 0;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int tgetNumber = rand.nextInt(highNum - lowNum + 1) + lowNum;
            int attempts = 0;
            int userGuess;

            System.out.println("\nRound " + (rounds + 1));
            System.out.println("Guess a number between " + lowNum + " and " + highNum);

            do {
                System.out.print("Enter your guess: ");
                userGuess = scan.nextInt();
                attempts++;

                if (userGuess == tgetNumber) {
                    System.out.println("Congratulations! You guessed the correct number in " + attempts + " attempts.");
                    score += attempts;
                } else if (userGuess < tgetNumber) {
                    System.out.println("Too low. Try again.");
                } else {
                    System.out.println("Too high. Try again.");
                }

            } while (userGuess != tgetNumber && attempts < attmpLimit);

            if (userGuess != tgetNumber) {
                System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: "
                        + tgetNumber);
            }

            rounds++;

            System.out.print("Do you want to play again? (yes/no): ");
        } while (scan.next().equalsIgnoreCase("yes"));

        System.out.println("\nGame Over! You played " + rounds + " rounds and your total score is: " + score);

        scan.close();
    }
}