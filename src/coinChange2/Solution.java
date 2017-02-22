package coinChange2;

public class Solution {
    // DP solution
    public int change(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }

        if (coins.length == 0) {
            return 0;
        }

        int[][] dp = new int[coins.length][amount + 1];

        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (i == 0) {
                    if (coins[i] > j) {
                        dp[i][j] = 0;
                    } else if (j % coins[i] == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = 0;
                    }
                } else {
                    if (coins[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i][j - coins[i]] + dp[i - 1][j];
                    }
                }
            }
        }

        return dp[coins.length - 1][amount];

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] coins = { 1, 2, 5 };
        int result = s.change(5, coins);
        System.out.println(result);

    }
}
