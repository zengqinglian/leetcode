package coinChange;

import java.util.Arrays;

//Another Dp solution
public class Solution2
{
    public int coinChange( int[] coins, int amount ) {
        if( amount == 0 ) {
            return 0;
        }
        Arrays.sort( coins );
        int[][] dp = new int[coins.length][amount + 1];
        dp[0][0] = 0;
        for( int i = 0; i < coins.length; i++ ) {
            for( int j = 1; j < amount + 1; j++ ) {
                if( i == 3 && j == 6249 ) {
                    System.out.print( 3 );
                }
                if( i == 0 ) {
                    if( coins[i] > j ) {
                        dp[i][j] = 0;
                    } else if( coins[i] == j ) {
                        dp[i][j] = 1;
                    } else {
                        if( dp[i][j - coins[i]] == 0 ) {
                            dp[i][j] = 0;
                        } else {
                            dp[i][j] = dp[i][j - coins[i]] + 1;
                        }
                    }
                } else {
                    if( coins[i] > j ) {
                        dp[i][j] = dp[i - 1][j];
                    } else if( coins[i] == j ) {
                        dp[i][j] = 1;
                    } else {
                        if( dp[i][j - coins[i]] == 0 ) {
                            dp[i][j] = dp[i - 1][j];
                        } else if( dp[i - 1][j] != 0 ) {
                            dp[i][j] = Math.min( dp[i - 1][j], dp[i][j - coins[i]] + 1 );
                        } else {
                            dp[i][j] = dp[i][j - coins[i]] + 1;
                        }
                    }
                }
            }
        }
        if( dp[coins.length - 1][amount] == 0 ) {
            return -1;
        }
        return dp[coins.length - 1][amount];
    }

    public static void main( String[] args ) {
        Solution2 s = new Solution2();
        int[] coins = { 186, 419, 83, 408 };
        s.coinChange( coins, 6249 );

    }
}
