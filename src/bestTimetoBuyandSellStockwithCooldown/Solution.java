package bestTimetoBuyandSellStockwithCooldown;

public class Solution
{ // wrong solution
    public int maxProfit( int[] prices ) {
        if( prices.length <= 1 ) {
            return 0;
        }
        if( prices.length == 2 ) {
            return (prices[0] < prices[1]) ? prices[1] - prices[0] : 0;
        }

        int max = 0;
        int index = 0;
        int buy = -1;
        while( index < prices.length - 1 ) {
            if( buy == -1 ) {
                if( prices[index] < prices[index + 1] ) {
                    if( index + 1 == prices.length - 1 ) {
                        max += prices[index + 1] - prices[index];
                        break;
                    }
                    buy = index;
                    index++;
                } else {
                    index++;
                }
            } else {
                if( index + 1 == prices.length - 1 ) {
                    if( prices[index] <= prices[index + 1] ) {
                        max += prices[index + 1] - prices[buy];
                        break;
                    } else {
                        max += prices[index] - prices[buy];
                        break;
                    }
                } else {
                    if( prices[index] <= prices[index + 1] ) {
                        index++;
                    } else {
                        int ret1 = prices[index - 1] - prices[buy] + prices[index + 2] - prices[index + 1];
                        int ret2 = prices[index] - prices[buy];
                        int ret3 = prices[index + 2] - prices[buy];

                        if( ret1 >= ret2 && ret1 >= ret3 ) {
                            max += prices[index - 1] - prices[buy];
                            buy = -1;
                            index++;
                        } else if( ret2 >= ret1 && ret2 >= ret3 ) {
                            max += ret2;
                            buy = -1;
                            index = index + 2;
                        } else if( ret3 >= ret1 && ret3 >= ret2 ) {
                            index++;
                        }

                    }
                }

            }
        }
        System.out.print( max );
        return max;

    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        // int[] prices = { 70, 4, 83, 56, 94 };
        // int[] prices = { 1, 2, 3, 0, 2 };
        int[] prices = { 8, 6, 4, 3, 3, 2, 3, 5, 8, 3, 8, 2, 6 };
        s.maxProfit( prices );

    }
}