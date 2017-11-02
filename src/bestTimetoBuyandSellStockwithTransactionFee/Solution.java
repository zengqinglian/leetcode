package bestTimetoBuyandSellStockwithTransactionFee;

public class Solution {
  // memory limit over - failed on 34/44
  public int maxProfit(int[] prices, int fee) {
    int[][] dp = new int[prices.length][prices.length];

    for (int i = 1; i < prices.length; i++) {
      int maxVal = Integer.MIN_VALUE;
      for (int j = i; j < prices.length; j++) {
        maxVal = Math.max(maxVal, dp[i - 1][j - 1] - prices[j - 1]);
        dp[i][j] = Math.max(dp[i][j - 1], maxVal + prices[j]);
      }
    }

    int result = -1;
    for (int i = 1; i < prices.length; i++) {
      result = Math.max(result, dp[i][prices.length - 1] - fee * i);
    }

    return result < 0 ? 0 : result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] prices = {1, 3, 2, 8, 4, 9};
    s.maxProfit(prices, 2);
  }
}
