package sumofSubarrayMinimums;

public class Solution {
    // dp over memory limit solution
    public int sumSubarrayMins(int[] A) {
	int MOD = 1_000_000_007;
	int[][] dp = new int[A.length][A.length];
	int total = 0;
	for (int i = 0; i < A.length; i++) {
	    dp[i][i] = A[i];
	}

	for (int i = 0; i < A.length; i++) {
	    dp[i][i] = A[i];
	    total += dp[i][i];
	    total = total % MOD;
	}

	for (int n = 1; n < A.length; n++) {
	    for (int i = 0, j = n; j < A.length; j++, i++) {
		dp[i][j] = Math.min(dp[i][j - 1], dp[i + 1][j]);
		total += dp[i][j];
		total = total % MOD;
	    }
	}



	return total;
    }


    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 2, 1, 4, 5 };
	s.sumSubarrayMins(A);
    }
}
