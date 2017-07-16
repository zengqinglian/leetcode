package deleteOperationforTwoStrings;

public class Solution {
  public int minDistance(String word1, String word2) {
    if ((word1 == null || word1.length() == 0) && (word2 == null || word2.length() == 0)) {
      return 0;
    } else if (word1 == null || word1.length() == 0) {
      return word2.length();
    } else if (word2 == null || word2.length() == 0) {
      return word1.length();
    }

    // find longest common string length
    int[][] dp = new int[word2.length() + 1][word1.length() + 1];
    for (int i = 1; i <= word2.length(); i++) {
      for (int j = 1; j <= word1.length(); j++) {
        if (word2.charAt(i - 1) == word1.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return word1.length() + word2.length() - 2 * dp[word2.length()][word1.length()];



  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.minDistance("a", "ab");
  }

}
