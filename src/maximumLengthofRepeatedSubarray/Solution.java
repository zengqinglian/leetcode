package maximumLengthofRepeatedSubarray;

public class Solution {
  // O(A*B) solution - meet avg speed beat 50%
  public int findLength(int[] A, int[] B) {
    if (A.length == 0 || B.length == 0) {
      return 0;
    }
    int[][] dp = new int[A.length + 1][B.length + 1];

    int maxVal = Integer.MIN_VALUE;
    for (int i = 1; i <= A.length; i++) {
      for (int j = 1; j <= B.length; j++) {
        if (A[i - 1] == B[j - 1]) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = 0;
        }
        maxVal = Math.max(maxVal, dp[i][j]);
      }
    }

    return maxVal;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] A = {1, 2, 3, 2, 1};
    int[] B = {3, 2, 1, 4, 7};
    s.findLength(A, B);
  }
}
