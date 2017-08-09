package twoKeysKeyboard;

import java.util.Arrays;

public class Solution {
  // dp solution beat 65%
  public int minSteps(int n) {
    if (n == 1) {
      return 0;
    }
    int[] dp = new int[n + 1];

    Arrays.fill(dp, Integer.MAX_VALUE);

    dp[1] = 0;

    int index = 1;

    while (index < n) {
      for (int i = 1; i * index + index <= n; i++) {
        dp[i * index + index] = Math.min(dp[i * index + index], dp[index] + 1 + i);
      }
      index++;
    }

    return dp[n];
  }
}
