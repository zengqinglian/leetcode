package bestTimeToBuyAndSellStockiv;

public class Solution2 {
    // 2ms solution , beat 100%
    public int maxProfit(int k, int[] prices) {

	int n = prices.length;
	if (n == 0)
	    return 0;

	if (k >= n / 2) {
	    int pro = 0;
	    for (int i = 1; i < n; i++) {
		if (prices[i] > prices[i - 1])
		    pro += prices[i] - prices[i - 1];
	    }
	    return pro;
	}

	int[][] dp = new int[k + 1][n];
	for (int i = 1; i <= k; i++) {
	    int localMax = dp[i - 1][0] - prices[0];
	    for (int j = 1; j < n; j++) {
		dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
		localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
	    }
	}
	return dp[k][n - 1];
    }

    public static void main(String[] args) {
	Solution2 s = new Solution2();
	int[] prices = { 3, 2, 6, 5, 0, 3 };
	s.maxProfit(2, prices);
    }
}
