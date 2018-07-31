package dominoandTrominoTiling;

public class Solution {
    // DP solution 3ms - beat 50%
    public int numTilings(int N) {
	int[][] dp = new int[N + 1][2];

	// case 1: XX shape
	// case 2: L shape
	dp[0][0] = 1;
	for (int i = 1; i <= N; i++) {
	    dp[i][0] = dp[i - 1][0]; // case 1
	    if (i - 2 >= 0) {
		dp[i][0] = (dp[i][0] + dp[i - 2][0]) % 1000000007; // case 1 rotate
		dp[i][0] = (dp[i][0] + dp[i - 1][1]) % 1000000007;
		dp[i][1] = (dp[i - 2][0] * 2) % 1000000007; // case 2 and rotate
		dp[i][1] = (dp[i][1] + dp[i - 1][1]) % 1000000007; // case 2 and case 1 combine
	    }

	}

	return dp[N][0];
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.numTilings(3);
    }
}
