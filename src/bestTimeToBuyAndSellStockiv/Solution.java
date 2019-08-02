package bestTimeToBuyAndSellStockiv;

public class Solution {
    // 135ms solution, beat 10%
    public int maxProfit(int k, int[] prices) {
	if (k == 0 || prices.length < 2) {
	    return 0;
	}

	if (k >= prices.length / 2) {
	    int pro = 0;
	    for (int i = 1; i < prices.length; i++) {
		if (prices[i] > prices[i - 1])
		    pro += prices[i] - prices[i - 1];
	    }
	    return pro;
	}

	int[][] dp = new int[k][prices.length];
	dp[0][0] = 0;
	int min = prices[0];
	for (int i = 1; i < prices.length; i++) {
	    min = Math.min(min, prices[i-1]);
	    dp[0][i] = Math.max(dp[0][i - 1], prices[i] - min);
	}
	
	for (int i = 1; i < k; i++) {
	    for (int j = 0; j < prices.length; j++) {
		if (j == 0) {
		    dp[i][j] = dp[i - 1][j];
		} else {
		    for (int n = 0; n < j; n++) {
			dp[i][j] = Math.max(dp[i][j], dp[i - 1][n] + (prices[j] - prices[n]));
			dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
		    }
		}
	    }
	}
	return dp[k - 1][prices.length - 1];
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] prices = { 3, 2, 6, 5, 0, 3 };
	s.maxProfit(2, prices);
    }
}
