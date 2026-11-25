package Game;

public class GameConfig {
    private int maxNumber;
    private int maxAttempts;

    public GameConfig(int maxNumber, int maxAttempts){
        this.maxNumber = maxNumber;
        this.maxAttempts = maxAttempts;
    }
    public int getMaxNumber(){
        return maxNumber;
    }
    public int getMaxAttempts(){
        return maxAttempts;
    }
}
