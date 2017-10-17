package maximumLengthofPairChain;

import java.util.Arrays;

public class Solution {
  // solution 1 - sort and dp, beat 30%
  public int findLongestChain(int[][] pairs) {
    Arrays.sort(pairs, (x, y) -> {
      return x[0] - y[0];
    });
    int[] dp = new int[pairs.length];

    dp[0] = 1;

    for (int i = 1; i < dp.length; i++) {
      dp[i] = 1;
      for (int j = 0; j < i; j++) {
        if (pairs[i][0] > pairs[j][1]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
    }

    return dp[pairs.length - 1];
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] pairs = { {1, 2}, {2, 3}, {3, 4}};
    s.findLongestChain(pairs);
  }
}
