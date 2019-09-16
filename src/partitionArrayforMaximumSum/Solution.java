package partitionArrayforMaximumSum;

public class Solution {
    // 5ms DP solution , beat 60%
    public int maxSumAfterPartitioning(int[] A, int K) {

	int[] dp = new int[A.length + 1];
	dp[0] = 0;
	for (int i = 1; i < dp.length; i++) {
	    int max = 0;
	    for (int j = 0; j <K; j++) {
		if (i - 1 - j >= 0) {
		    max = Math.max(max, A[i - 1 - j]);
		    dp[i] = Math.max(dp[i], dp[i - 1 - j] + max * (j + 1));
		}
	    }
	}

	return dp[A.length];
    }

    public static void main(String[] args) {
	int[] A = { 1, 15, 7, 16 };
	Solution s = new Solution();
	s.maxSumAfterPartitioning(A, 3);
    }
}
