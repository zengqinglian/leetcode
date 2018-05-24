package palindromePartitioningII;

public class Solution {
    // dp solution - 29ms. beat 60%
    public int minCut(String s) {
	if (s == null || s.length() == 0)
	    return 0;
	int n = s.length();
	int[][] dp = new int[n][n]; // Min number of cut from s[0] to s[i] inclusively.
	boolean[][] isPal = new boolean[n][n]; // Whether s[0] to s[i] (inclusively) is palindrome.Whether s[1] to s[i]
					       // (inclusively) is palindrome.
	for (int step = 0; step < n; step++) {
	    for (int i = 0; i + step <= n - 1; i++) {
		if (s.charAt(i) == s.charAt(i + step)) {
		    if (step <= 2 || isPal[i + 1][i + step - 1])
			isPal[i][i + step] = true;
		}
	    }
	}
	for (int i = 0; i < 1; i++) {
	    for (int j = i; j < n; j++) {
		dp[i][j] = j - i;
	    }
	}
	// Dynamic Programming.
	for (int i = 0; i < n; i++) {
	    for (int j = i; j < n; j++) {
		if (isPal[i][j]) {
		    if (i != 0) {
			dp[0][j] = Math.min(dp[0][j], dp[0][i - 1] + 1);
		    } else {
			dp[0][j] = 0;
		    }
		}
	    }
	}

	return dp[0][n - 1];
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.minCut("aabbac");
    }
}
