package guessNumberHigherorLower;

public class GuessGame {
    private int target;

    public GuessGame(int target) {
        this.target = target;
    }

    public int guess(int guess) {
        if (guess == target) {
            return 0;
        } else if (guess > target) {
            return -1;
        } else {
            return 1;
        }
    }
}
