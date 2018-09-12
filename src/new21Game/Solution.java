package new21Game;

public class Solution {
    // Over time solution failed on 146/146
    public double new21Game(int N, int K, int W) {
	double[] dp = new double[N + 1];
	double sum = 0d;
	dp[0] = 1;
	for (int i = 0; i <= N; i++) {
	    if (dp[i] == 0) {
		continue;
	    }
	    if (i < K) {
		double pct = 1.0 / W;
		for (int j = 1; j <= W; j++) {
		    if (i + j <= N) {
			dp[i + j] += (dp[i] * pct);
		    } else {
			break;
		    }
		}
	    } else {
		sum += dp[i];
	    }
	}
	return sum;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.new21Game(5819, 5165, 5424);
    }
}
