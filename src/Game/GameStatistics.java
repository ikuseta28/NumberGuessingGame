package Game;

public class GameStatistics {

    private int gamesPlayed;
    private int gamesWon;
    private int totalAttempts;

    public void recordGame(boolean won, int attempts){
        gamesPlayed ++;

        if(won){
            gamesWon++;
            totalAttempts += attempts;
        }
    }

    public void printStats(){
        System.out.println("\nGame Statistics");
        System.out.println("Games played: " + gamesPlayed);
        System.out.println("Games won: " + gamesWon);

        if(gamesWon > 0){
            System.out.println("Average Attempts (wins): " + (totalAttempts / gamesWon));
        }
    }
}
