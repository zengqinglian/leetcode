package distinctSubsequences;

public class Solution
{
    public int numDistinct( String s, String t ) {
        if( s == null || s.equals( "" ) ) {
            return 0;
        }
        if( s.length() < t.length() ) {
            return 0;
        }
        int[][] dp = new int[t.length()][s.length()];

        for( int i = 0; i < t.length(); i++ ) {
            char c = t.charAt( i );
            for( int j = i; j < s.length(); j++ ) {
                if( i == 0 ) {
                    if( j == 0 ) {
                        if( c == s.charAt( j ) ) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = 0;
                        }
                    } else {
                        if( c == s.charAt( j ) ) {
                            dp[i][j] = dp[i][j - 1] + 1;
                        } else {
                            dp[i][j] = dp[i][j - 1];
                        }
                    }
                } else {
                    if( c == s.charAt( j ) ) {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }
        }

        return dp[t.length() - 1][s.length() - 1];

    }

    public static void main( String[] args ) {
        Solution solution = new Solution();
        String s = "ccc";
        String t = "c";
        solution.numDistinct( s, t );
    }
}
