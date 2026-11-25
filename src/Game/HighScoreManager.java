package Game;

import java.io.*;
import java.io.PrintWriter;

public class HighScoreManager {

    private static final String FILE_NAME = "highscore.txt";

    public void updateHighScore(int attempts){

        int bestScore = getHighscore();

        if(bestScore == -1 || attempts < bestScore){
            try(PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))){
                writer.println(attempts);
                System.out.println("New High Score!");
            }
            catch(IOException e){
                System.out.println("Error saving high score.");
            }
        }
    }

    public int getHighscore(){

        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            return Integer.parseInt(reader.readLine());
        }
        catch(Exception e){
            return -1;
        }
    }
    public void printHighScore() {

        int score = getHighscore();

        if (score != -1) {
            System.out.println("Best Score: " + score + "attempts");
        }
    }
}
