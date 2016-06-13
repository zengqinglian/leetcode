package editDistance;

public class Solution
{
    public int minDistance( String word1, String word2 ) {
        if( word1.equals( word2 ) ) {
            return 0;
        }

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for( int i = 0; i < m + 1; i++ ) {
            for( int j = 0; j < n + 1; j++ ) {
                if( i == 0 ) {
                    dp[i][j] = j;
                } else if( j == 0 ) {
                    dp[i][j] = i;
                } else {
                    if( word1.charAt( i - 1 ) == word2.charAt( j - 1 ) ) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = Math.min( dp[i - 1][j - 1] + 1, Math.min( dp[i][j - 1] + 1, dp[i - 1][j] + 1 ) );
                    }
                }
            }
        }

        return dp[m][n];
    }
}
