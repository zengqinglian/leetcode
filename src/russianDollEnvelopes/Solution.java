package russianDollEnvelopes;

import java.util.Arrays;

public class Solution
{
    // first slow solution 700ms
    public int maxEnvelopes( int[][] envelopes ) {
        if( envelopes == null || envelopes.length == 0 ) {
            return 0;
        }
        if( envelopes.length == 1 ) {
            return 1;
        }

        Arrays.sort( envelopes, ( o1, o2 ) -> {
            if( o1[0] > o2[0] ) {
                return 1;
            } else if( o1[0] < o2[0] ) {
                return -1;
            } else {
                if( o1[1] > o2[1] ) {
                    return 1;
                } else if( o1[1] < o2[1] ) {
                    return -1;
                } else {
                    return 0;
                }
            }

        } );

        int[] dp = new int[envelopes.length];
        dp[0] = 1;
        int max = 1;
        for( int i = 1; i < envelopes.length; i++ ) {
            dp[i] = 1;
            int index = i - 1;
            while( index >= 0 ) {
                if( envelopes[i][0] != envelopes[index][0] && envelopes[i][1] > envelopes[index][1] ) {
                    dp[i] = Math.max( dp[i], dp[index] + 1 );
                    if( dp[i] > max ) {
                        max = dp[i];
                    }
                }
                index--;
            }
        }

        return max;

    }

    public static void main( String[] args ) {
        int[][] env = { { 1, 3 }, { 3, 5 }, { 6, 7 }, { 6, 8 }, { 8, 4 }, { 9, 5 }, { 10, 6 } };
        Solution s = new Solution();
        s.maxEnvelopes( env );

    }
}
