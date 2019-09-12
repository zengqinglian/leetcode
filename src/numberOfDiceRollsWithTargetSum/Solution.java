package numberOfDiceRollsWithTargetSum;

public class Solution {
    // 4ms dp solution , beat 95%
    public int numRollsToTarget(int d, int f, int target) {
	int[][] dp = new int[d + 1][target + 1];
	int mod = 1_000_000_007;
	for (int i = 1; i <= d; i++) {
	    if (i == 1) {
		int loop = Math.min(f, target);
		for (int j = i; j <= loop; j++) {
		    dp[i][j] = 1;
		}
	    } else {
		int loop = Math.min(i*f, target);
		long res = 0;
		int cnt = 1;
		for (int j = i; j <= loop; j++) {
		    res += dp[i - 1][j - 1];
		    if (cnt > f) {
			res -= dp[i - 1][j - f - 1];
			if (res < 0) {
			    res += mod;
			}
		    }
		    res %= mod;
		    dp[i][j] = (int) res;
		    cnt++;
		}

	    }

	}

	return dp[d][target];
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.numRollsToTarget(20, 19, 233);
    }
}
