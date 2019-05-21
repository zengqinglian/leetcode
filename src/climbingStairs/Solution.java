package climbingStairs;

public class Solution {
    public int climbStairs(int n) {
	int[] dp = new int[n + 1];
	dp[0] = 1;
	for (int i = 1; i <= n; i++) {
	    if(i-2>=0) {
		dp[i] = dp[i - 1] + dp[i - 2];
	    } else {
		dp[i] = dp[i - 1];
	    }
	}

	return dp[n];
    }
}
