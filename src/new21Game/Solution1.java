package new21Game;

public class Solution1 {
    // accepted dp solution
    public double new21Game(int N, int K, int W) {
	double[] dp = new double[N + W + 1];
	// dp[x] = the answer when Alice has x points
	for (int k = K; k <= N; ++k)
	    dp[k] = 1.0;

	double S = Math.min(N - K + 1, W);
	// S = dp[k+1] + dp[k+2] + ... + dp[k+W]
	for (int k = K - 1; k >= 0; --k) {
	    dp[k] = S / W;
	    S += dp[k] - dp[k + W];
	}
	return dp[0];
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	s.new21Game(21, 17, 10);
    }
}
