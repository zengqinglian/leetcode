package guessNumberHigherorLower;

public class Solution extends GuessGame {
    public Solution(int target) {
        super(target);
    }

    public int guessNumber(int n) {
        int min = 1;
        int max = n;
        while (true) {
            int guessNumber = min + (max - min) / 2;
            int result = guess(guessNumber);
            if (result == 0) {
                System.out.println(guessNumber);
                return guessNumber;
            } else if (result == 1) {
                min = guessNumber + 1;
            } else {
                max = guessNumber - 1;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution(6);
        s.guessNumber(10);
    }
}
