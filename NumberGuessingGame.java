import java.util.*;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random ran = new Random();
        int min = 1;
        int max = 100;
        int attemptslimit = 5;
        int score = 0;
        boolean playagain = true;

        System.out.println("Welcome to the number guessing game!:");

        while (playagain) {
            int targetNumber = ran.nextInt(max - min + 1) + min;
            int attempts = 0;
            boolean guessedCorrectly = false;
            System.out
                    .println("I have selected a number between " + min + " and " + max + " Can you guess the number?");

            while (attempts < attemptslimit) {
                System.out.println("Enter your guess:");
                int guess = sc.nextInt();
                attempts++;

                if (guess == targetNumber) {
                    System.out.println("Congratulation! Your guessed is correct");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < targetNumber) {
                    System.out.println("Your guess to low!");
                } else if (guess > targetNumber) {
                    System.out.println("Your guess is to high!");
                } else {
                    System.out.println("You've enterd the invalid number. Please enter number between 1 to 100");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry you've run out of attempts. The correct answer was:" + targetNumber);
            }

            System.out.println("Do you want to play again? (yes/no):");
            String playagainInput = sc.next();
            playagain = playagainInput.equalsIgnoreCase("yes");
        }
        System.out.println("Game Over. Your total score is:" + score);
        sc.close();
    }
}
