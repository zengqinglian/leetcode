package bestTimetoBuyandSellStockwithTransactionFee;

public class Solution1 {
  // improve solution O(N) - meet avg
  public int maxProfit(int[] prices, int fee) {
    int[] dp = new int[prices.length];
    int maxVal = Integer.MIN_VALUE;
    for (int i = 1; i < dp.length; i++) {
      maxVal = Math.max(maxVal, dp[i - 1] - prices[i - 1]);
      dp[i] = Math.max(dp[i], maxVal + prices[i] - fee);
      dp[i] = Math.max(dp[i], dp[i - 1]);
    }
    return dp[dp.length - 1] < 0 ? 0 : dp[dp.length - 1];
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    int[] prices = {1, 3, 2, 8, 4, 9};
    s.maxProfit(prices, 2);
  }
}
