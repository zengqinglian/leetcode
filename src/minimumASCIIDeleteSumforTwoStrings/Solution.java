package minimumASCIIDeleteSumforTwoStrings;

public class Solution {
  // dp solution, find max common string
  public int minimumDeleteSum(String s1, String s2) {

    int[][] dp = new int[s1.length() + 1][s2.length() + 1]; // max common string after remove.
    int total = 0;
    for (int i = 1; i <= s1.length(); i++) {
      total += s1.charAt(i - 1);
      for (int j = 1; j <= s2.length(); j++) {
        if (i == 1) {
          total += s2.charAt(j - 1);
        }
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          dp[i][j] = Math.max(dp[i - 1][j - 1] + s2.charAt(j - 1), dp[i - 1][j]);
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }

    }

    return total - 2 * dp[s1.length()][s2.length()];
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.minimumDeleteSum("delete", "leet");
  }
}
