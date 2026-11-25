package Game;

import java.util.Random;
import java.util.Scanner;

public class Main {
   public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);
       GameStatistics statistics = new GameStatistics();

       System.out.println("Welcome to the Number Guessing Game!");

       boolean playAgain = true;

       while(playAgain){
           System.out.println("1 - Easy (1-50)");
           System.out.println("2 - Medium (1-100)");
           System.out.println("3 - Hard (1-1000)");
           System.out.print("Choose difficulty:");

           int choice;
           while(true){
               if(scanner.hasNextInt()){
                   choice = scanner.nextInt();
                   if(choice >= 1 && choice <= 3)
                       break;
                   else System.out.println("Please select 1, 2, or 3.");
               }
               else{
                   System.out.println("Please enter a valid number.");
                   scanner.next();
               }
           }

           GameConfig config;
           if (choice == 1){
               config = new GameConfig(50, 10);
           } else if (choice == 2) {
               config = new GameConfig(100, 12);
           } else {
               config = new GameConfig(1000, 15);
           }

           GuessingGame game = new GuessingGame(config, statistics);
           game.start();

           statistics.printStats();
           System.out.println("\nPlay again? (y/n)");
           String answer = scanner.next();
           playAgain = answer.equalsIgnoreCase("y");
       }
       scanner.close();
       System.out.println("Thanks for playing!");
   }
}
