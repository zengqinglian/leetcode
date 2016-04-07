package bestTimetoBuyandSellStock2;

public class Solution
{
    public int maxProfit( int[] prices ) {
        int length = prices.length;
        int buy = -1;
        // int sell = 0;
        int index = 0;
        int totalProfit = 0;
        while( index < length ) {

            if( buy == -1 ) {
                if( index == length - 1 ) {
                    return totalProfit;
                } else if( prices[index] < prices[index + 1] ) {
                    buy = prices[index];
                    index++;
                } else {
                    index++;
                }

            } else {
                if( index == length - 1 ) {
                    if( buy < prices[index] ) {
                        totalProfit += prices[index] - buy;
                        buy = -1;
                        return totalProfit;
                    }
                } else {
                    if( prices[index] < prices[index + 1] ) {
                        index++;
                    } else {
                        totalProfit += prices[index] - buy;
                        buy = -1;
                        index++;
                    }
                }
            }

        }
        return totalProfit;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] prices = { 2, 1, 2, 0, 1 };
        s.maxProfit( prices );
    }
}
