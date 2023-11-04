import java.util.Random;
import java.util.Scanner;

public class GuessTheNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        
        int min_number = 1;
        int max_number = 100;
        int maxAttempts = 7;
        int totalScore = 0;
        int rounds = 0;

        System.out.println("**************************************************");
        System.out.println("Welcome to Guessing the Number Game!");
        System.out.println();
        System.out.println("In this game, You will have "+maxAttempts+" to guess the target number correctly.");
        System.out.println();
        System.out.println("\tLet's Start!!!\t");
        System.out.println("**************************************************");

        while (true) {
            int targetNumber = random.nextInt(max_number - min_number + 1) + min_number;
            int attempts = 0;

            System.out.println("--------------------------------------------------");
            System.out.println("Round : " + (rounds + 1));
            System.out.println();
            System.out.println("Try to guess the number in minimum no. of attempts");
            System.out.println();
            System.out.println("I'm thinking of a number between " + min_number + " and " + max_number);
            System.out.println("--------------------------------------------------");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess between 1 to 100 : ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess < targetNumber) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Your guess is lower than the target number.");
                    System.out.println("Try again with a higher number.");
                    System.out.println("Attempts left: " + (maxAttempts - attempts));
                    System.out.println("--------------------------------------------------");
                    System.out.println();
                } else if (userGuess > targetNumber) {
                    System.out.println("--------------------------------------------------");
                    System.out.println("Your guess is higher than the target number.");
                    System.out.println("Try again with a lower number.");
                    System.out.println("Attempts left: " + (maxAttempts - attempts));
                    System.out.println("--------------------------------------------------");
                    System.out.println();
                } else {
                    int roundScore = maxAttempts - attempts + 1;
                    totalScore += roundScore;
                    System.out.println("Congratulations!!! You guessed the number correctly in " + attempts + " attempts.");
                    System.out.println("Round Score: " + roundScore);
                    System.out.println();
                    break;
                }
            }

            System.out.println("The target number was: " + targetNumber);

            System.out.print("Do you want to play again? (yes/no): ");
            String playerChoice = scanner.next().toLowerCase();
            if (!playerChoice.equals("yes")) {
                break;
            }

            rounds++;
        }
        System.out.println();
        System.out.println("**************************************************");
        System.out.println("\tGame Over!!!\t");
        System.out.println();
        System.out.println("\tYour Total Score : " + totalScore);
        System.out.println();
        System.out.println("\tThanks for playing!!!\t");
        System.out.println("**************************************************");
        scanner.close();
    }
}
