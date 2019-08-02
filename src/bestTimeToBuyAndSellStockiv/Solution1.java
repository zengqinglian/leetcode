package bestTimeToBuyAndSellStockiv;

public class Solution1 {
    // 90ms solution , beat 15%
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

	int[] dp0 = new int[prices.length];
	dp0[0] = 0;
	int min = prices[0];
	for (int i = 1; i < prices.length; i++) {
	    min = Math.min(min, prices[i - 1]);
	    dp0[i] = Math.max(dp0[i - 1], prices[i] - min);
	}

	for (int i = 1; i < k; i++) {
	    int[] dp1 = new int[prices.length];
	    for (int j = 0; j < prices.length; j++) {
		if (j == 0) {
		    dp1[j] = dp0[j];
		} else {
		    for (int n = 0; n < j; n++) {
			dp1[j] = Math.max(dp1[j], dp0[n] + (prices[j] - prices[n]));
			dp1[j] = Math.max(dp1[j], dp1[j - 1]);
		    }
		}
	    }
	    dp0 = dp1;
	}
	return dp0[prices.length - 1];
    }
}
