package bestTimetoBuyandSellStock;

public class Solution
{
    public int maxProfit( int[] prices ) {
        if( prices.length == 0 || prices.length == 1 ) {
            return 0;
        }
        int min = prices[0];
        int[] result = new int[prices.length];
        int max = 0;
        result[0] = 0;

        for( int i = 1; i < prices.length; i++ ) {
            if( min > prices[i] ) {
                result[i] = 0;
                min = prices[i];
            } else {
                result[i] = result[i - 1] + prices[i] - prices[i - 1];
            }
            if( max < result[i] ) {
                max = result[i];
            }
        }

        return max;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] prices = { 7, 2, 3, 6, 3, 4, 2, 5, 9 };
        s.maxProfit( prices );
    }

}
