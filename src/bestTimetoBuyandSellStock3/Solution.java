package bestTimetoBuyandSellStock3;

public class Solution {
    // Time over limit solution.
    public int maxProfit(int[] prices) {
        if (prices.length == 0 || prices.length == 1) {
            return 0;
        }

        int[] dp = new int[prices.length];
        dp[0] = 0;

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (dp[i - 1] + diff <= 0) {
                dp[i] = 0;
            } else {
                dp[i] = dp[i - 1] + diff;
            }
        }

        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i] + findMaxDiff(dp, i + 1));
        }

        return max;
    }

    private int findMaxDiff(int[] dp, int startIndex) {
        int max = 0;
        if (startIndex >= dp.length - 1) {
            return max;
        }
        int[] newDP = new int[dp.length];
        newDP[startIndex] = 0;
        for (int i = startIndex + 1; i < newDP.length; i++) {
            int diff = dp[i] - dp[i - 1];
            if (newDP[i - 1] + diff <= 0) {
                newDP[i] = 0;
            } else {
                newDP[i] = newDP[i - 1] + diff;
            }
            max = Math.max(max, newDP[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] prices = { 1, 2, 1, 3, 4, 5, 1, 2, 7, 3, 5, 4, 3, 7, 8, 9, 10 };

        Solution s = new Solution();
        s.maxProfit(prices);
    }
}
