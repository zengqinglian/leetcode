package longestPalindromicSubsequence;

public class Solution {
    // DP solution

    public int longestPalindromeSubseq(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int[][] dp = new int[s.length() + 1][s.length() + 1];

        for (int i = 1; i < s.length() + 1; i++) {
            dp[i][i] = 1;
        }

        int length = 2;
        while (length <= s.length()) {
            for (int i = length; i < s.length() + 1; i++) {
                int index = i - length + 1;
                if (s.charAt(index - 1) == s.charAt(i - 1)) {
                    if (length == 2) {
                        dp[index][i] = 2;
                    } else {
                        dp[index][i] = 2 + dp[index + 1][i - 1];
                    }
                } else {
                    dp[index][i] = Math.max(dp[index][i - 1], dp[index + 1][i]);
                }
            }
            length++;
        }

        return dp[1][s.length()];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestPalindromeSubseq("bbbab");
    }
}
