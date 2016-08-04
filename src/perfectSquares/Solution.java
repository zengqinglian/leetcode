package perfectSquares;

public class Solution {
    // dp solution but only beat 20%
    public int numSquares(int n) {
        double available = Math.sqrt((double)n);
        int intNumber = Double.valueOf(available).intValue();
        
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int[] numbers = new int[intNumber];
        for (int i = 1; i <= intNumber; i++) {
            numbers[i - 1] = i * i;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j : numbers) {
                if (j == 1) {
                    dp[i] = dp[i - 1] + 1;
                } else if (i - j >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - j] + 1);
                }
            }
        }

        return dp[n];
    }
}
