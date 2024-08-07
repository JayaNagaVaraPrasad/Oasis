import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    private static final int MAX_NUMBER = 100;
    private static final int MAX_ATTEMPTS = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numberToGuess = random.nextInt(MAX_NUMBER) + 1;
        int attempts = 0;
        boolean hasGuessedCorrectly = false;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between 1 and " + MAX_NUMBER + ".");
        System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

        while (attempts < MAX_ATTEMPTS && !hasGuessedCorrectly) {
            System.out.print("Enter your guess (or type 'quit' to exit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("quit")) {
                System.out.println("You have chosen to quit. The number was " + numberToGuess + ".");
                break;
            }

            try {
                int guess = Integer.parseInt(input);
                attempts++;

                if (guess < 1 || guess > MAX_NUMBER) {
                    System.out.println("Please enter a number between 1 and " + MAX_NUMBER + ".");
                } else if (guess < numberToGuess) {
                    System.out.println("Too low! Try again.");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high! Try again.");
                } else {
                    hasGuessedCorrectly = true;
                    System.out.println("Congratulations! You've guessed the number in " + attempts + " attempts.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number or type 'quit' to exit.");
            }
        }

        if (!hasGuessedCorrectly) {
            System.out.println("Sorry, you've used all your attempts. The number was " + numberToGuess + ".");
        }

        scanner.close();
    }
}
