package coinChange;

import java.util.Arrays;

//Still DP but best.
public class Solution4
{
    public int coinChange( int[] coins, int amount ) {
        if( amount < 1 )
            return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill( dp, Integer.MAX_VALUE );
        dp[0] = 0;
        for( int coin : coins ) {
            for( int i = coin; i <= amount; i++ ) {
                if( dp[i - coin] != Integer.MAX_VALUE ) {
                    dp[i] = Math.min( dp[i], dp[i - coin] + 1 );
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static void main( String[] args ) {
        Solution4 s = new Solution4();
        int[] coins = { 2, 5, 8 };
        s.coinChange( coins, 20 );

    }
}
