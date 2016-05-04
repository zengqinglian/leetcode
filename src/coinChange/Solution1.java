package coinChange;

import java.util.Arrays;

public class Solution1
{
    public int coinChange( int[] coins, int amount ) {
        if( amount == 0 ) {
            return 0;
        }
        Arrays.sort( coins );

        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for( int i = 1; i <= amount; i++ ) {
            if( i < coins[0] ) {
                dp[i] = 0;
            } else if( i == coins[coins.length - 1] || i == coins[0] ) {
                dp[i] = 1;
            } else if( i > coins[0] && i < coins[coins.length - 1] ) {
                boolean found = false;
                for( int j = 1; j < coins.length - 1; j++ ) {
                    if( coins[j] == i ) {
                        dp[i] = 1;
                        found = true;
                        break;
                    }
                }

                // set value
                if( !found )
                    dp[i] = getValue( i, dp, coins );
            } else {
                // set value
                dp[i] = getValue( i, dp, coins );
            }
        }

        if( dp[amount] == 0 ) {
            return -1;
        }
        return dp[amount];
    }

    private int getValue( int i, int[] dp, int[] coins ) {

        int ret = Integer.MAX_VALUE;
        for( int c : coins ) {
            if( i >= c && dp[i - c] != 0 ) {

                ret = Math.min( ret, dp[i - c] + 1 );
            }
        }

        if( ret == Integer.MAX_VALUE ) {
            ret = 0;
        }
        return ret;
    }

    public static void main( String[] args ) {
        Solution1 s = new Solution1();
        int[] coins = { 146, 66, 355, 93, 255, 152, 225, 244, 168, 205 };
        s.coinChange( coins, 8069 );
    }
}
