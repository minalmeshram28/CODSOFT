import java.util.Scanner;
import java.util.Random;

class GuessingGame {

    private final int maxAttempts;
    private int rounds;
    private int finalScore;

    private final Random rand;
    private final Scanner sc;

    public GuessingGame() {
        maxAttempts = 10;
        rounds = 0;
        finalScore = 0;

        rand = new Random();
        sc = new Scanner(System.in);
    }

    public void playGame() {
        while (true) {
            int generatedNumber = rand.nextInt(100) + 1;
            rounds++;

            System.out.println("Round " + rounds);

            int attempts = 0; // Reset attempts for each round

            while (attempts < maxAttempts) {
                System.out.print("Guess the number between 1 and 100: ");
                int guessedNumber = sc.nextInt();
                attempts++;

                if (guessedNumber < generatedNumber) {
                    System.out.println("Too low!");
                } else if (guessedNumber > generatedNumber) {
                    System.out.println("Too high!");
                } else {
                    int roundScore = maxAttempts - attempts + 1;
                    finalScore += roundScore;
                    System.out.println("Yeah! You guessed the number " + generatedNumber + " in " + attempts + " attempts.");
                    System.out.println("Round score: " + roundScore);
                    break;
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = sc.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }

        System.out.println("Game over...");
        System.out.println("Your score: " + finalScore);
        System.out.println("Congratulations!!!");
    }
}


