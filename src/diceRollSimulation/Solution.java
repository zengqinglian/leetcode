package diceRollSimulation;

public class Solution {
    //DP solution , meet avg speed.
    int mod = 1000_000_007;
    public int dieSimulator(int n, int[] rollMax) {
        long[] res = new long[n + 1];
        long[][] dp = new long[6][n + 1];
        res[0] = 1;
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < 6; ++j) {
                int k = i - rollMax[j] - 1;
                dp[j][i] = (res[i - 1] - (0 <= k ? res[k] - dp[j][k] : 0) + mod) % mod;
                res[i] = (res[i] + dp[j][i]) % mod;
            }
        }
        return (int) res[n];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] rollMax = {1,1,1,1,1,2};
        s.dieSimulator(4, rollMax);
    }
}
