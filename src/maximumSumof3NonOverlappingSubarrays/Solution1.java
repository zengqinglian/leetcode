package maximumSumof3NonOverlappingSubarrays;

public class Solution1 {
  // dp solution - beat only 8%
  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    if (3 * k == nums.length) {
      int[] result = new int[3];
      result[0] = 0;
      result[1] = k;
      result[2] = 2 * k;
      return result;
    }

    int[] sums = new int[nums.length - k + 1];

    for (int i = 0; i < sums.length; i++) {
      for (int j = 0; j < k; j++) {
        sums[i] += nums[i + j];
      }
    }

    int[][][] dp = new int[3][sums.length + 1][2];

    int[] result = new int[3];

    int index = -1;
    for (int i = 0; i < 3; i++) {
      for (int j = i * k + 1; j <= sums.length; j++) {
        if (i == 0) {
          if (dp[i][j - 1][0] >= sums[j - 1]) {
            dp[i][j][0] = dp[i][j - 1][0];
            dp[i][j][1] = dp[i][j - 1][1];
          } else {
            dp[i][j][0] = sums[j - 1];
            dp[i][j][1] = j - 1;
          }

        } else {
          index = j - 1;
          dp[i][j][0] = Math.max(dp[i][j - 1][0], sums[j - 1] + dp[i - 1][j - k][0]);
          dp[i][j][1] = j - k;
        }
      }
    }

    result[2] = index;
    for (int i = result[2] + 1; i >= 1; i--) {
      if (dp[2][i][0] == dp[2][i - 1][0]) {
        result[2] = i - 2;
      } else {
        break;
      }
    }
    result[1] = dp[2][result[2]][1];
    for (int i = result[1] + 1; i > 0; i--) {
      if (dp[1][i][0] == dp[1][i - 1][0]) {
        result[1] = i - 2;
      } else {
        break;
      }
    }
    result[0] = dp[1][result[1]][1];

    for (int i = result[0] + 1; i > 0; i--) {
      if (dp[0][i][0] == dp[0][i - 1][0]) {
        result[0] = i - 2;
      } else {
        break;
      }
    }

    return result;

  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    int[] nums = {4, 5, 10, 6, 11, 17, 4, 11, 1, 3};
    System.out.print(s.maxSumOfThreeSubarrays(nums, 1));
  }
}
