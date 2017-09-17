package findNumberOfLIS;

import java.util.Arrays;

public class Solution {
  public int findNumberOfLIS(int[] nums) {
    if (nums.length <= 1) {
      return nums.length;
    }
    int[] dp = new int[nums.length];
    int[] count = new int[nums.length];
    Arrays.fill(dp, 1);
    Arrays.fill(count, 1);
    int max = 1;
    int maxCount = 1;

    for (int i = 1; i < nums.length; i++) {
      for (int j = 0; j < i; j++) {
        if (nums[i] > nums[j]) {
          if (dp[i] < dp[j] + 1) {
            count[i] = count[j];
            dp[i] = dp[j] + 1;
          } else if (dp[i] == dp[j] + 1) {
            count[i] += count[j];
          }
        }
      }
      if (max < dp[i]) {
        maxCount = count[i];
        max = dp[i];
      } else if (max == dp[i]) {
        maxCount += count[i];
      }
    }
    return maxCount;

  }
}
