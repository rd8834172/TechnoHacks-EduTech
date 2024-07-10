import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public static void guessingNumberGame() {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        while (true) {
            int number = random.nextInt(100) + 1;
            int attempts = 7;
            int guess = -1;
            boolean validInput;
            System.out.println("Let's start....");
            System.out.println("A number is chosen between 1 to 100.");
            System.out.println("You have only 7 chances to guess the correct number.");

            for (int i = 0; i < attempts; i++) {
                do {
                    System.out.print("Guess the number:  ");
                    try {
                        guess = sc.nextInt();
                        validInput = true;
                        if (guess < 1 || guess > 100) {
                            System.out.println("Please enter a number between 1 and 100.");
                            validInput = false;
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a number between 1 and 100.");
                        validInput = false;
                        sc.next();
                    }
                } while (!validInput);

                if (number == guess) {
                    System.out.println("Congratulations! You guessed the number.");
                    break;
                } else if (number > guess && i != attempts - 1) {
                    System.out.println("The number is greater than " + guess);
                } else if (number < guess && i != attempts - 1) {
                    System.out.println("The number is less than " + guess);
                }

                if (i == attempts - 1) {
                    System.out.println("You have exhausted your attempts. The number was " + number);
                }
            }

            System.out.print("Do you want to play again? (y/n):  ");
            System.out.println("");
            String response = sc.next();
            if (!response.equalsIgnoreCase("y")) {
                System.out.println("Thank you for playing the Number Guessing Game!");
                break;
            }
        }

        sc.close();
    }

    public static void main(String arg[]) {

        guessingNumberGame();
    }
}
