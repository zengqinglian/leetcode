package coinChange;

import java.util.Arrays;

public class Solution
{
    public int coinChange( int[] coins, int amount ) {
        if( coins.length == 0 ) {
            return -1;
        }

        if( coins.length == 1 ) {
            if( amount % coins[0] == 0 ) {
                return amount / coins[0];
            } else {
                return -1;
            }
        }

        Arrays.sort( coins );
        int length = coins.length;
        int remainAmount = amount;
        int counter = 0;

        for( int i = length - 1; i >= 0; i-- ) {
            if( i == 0 ) {
                if( remainAmount % coins[0] != 0 ) {
                    return -1;
                }
            }
            counter = counter + remainAmount / coins[i];
            remainAmount = remainAmount % coins[i];
        }
        return counter;

    }

    public static void main( String[] args ) {

        int[] coins = { 186, 83, 408 };
        int amount = 6249;
        Solution s = new Solution();
        s.coinChange( coins, amount );
    }
}