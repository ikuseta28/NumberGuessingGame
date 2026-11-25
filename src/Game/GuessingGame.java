package Game;

import java.util.Random;
import java.util.Scanner;

public class GuessingGame {
    private GameConfig config;
    private Random random;
    private Scanner scanner;
    private HighScoreManager scoreManager;
    private GameStatistics statistics;

    public GuessingGame(GameConfig config, GameStatistics statistics){
        this.config = config;
        this.random = new Random();
        this.scanner = new Scanner(System.in);
        this.scoreManager = new HighScoreManager();
        this.statistics = statistics;
    }
    public void start(){

        int randomNumber = random.nextInt(config.getMaxNumber()) + 1;
        int guess = -1;
        int attempts = 0;

        System.out.println("\nGuess a number between 1 and " + config.getMaxNumber());

        long startTime = System.currentTimeMillis();

        while(guess != randomNumber && attempts < config.getMaxAttempts()){

            System.out.println("Enter guess: ");

            if(scanner.hasNextInt()){
                guess = scanner.nextInt();
            } else {
                System.out.println("Please enter a valid number!");
                scanner.next();
                continue;
            }
            attempts ++;

            if(guess > randomNumber){
                System.out.println("Too high, try again!");
            } else if (guess < randomNumber) {
                System.out.println("Too low, try again!");
            }
            else {
                long endTime = System.currentTimeMillis();
                long seconds = (endTime - startTime) / 1000;

                System.out.println("Correct!");
                System.out.println("Attempts: " + attempts);
                System.out.println("Time: " + seconds + " seconds");

                scoreManager.updateHighScore(attempts);
                scoreManager.printHighScore();

                statistics.recordGame(true, attempts);
                return;
            }
        }
        System.out.println("Game Over!");
        System.out.println("The number was: " + randomNumber);

        statistics.recordGame(false, attempts);
    }
}
