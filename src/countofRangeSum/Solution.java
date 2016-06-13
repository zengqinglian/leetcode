package countofRangeSum;

import java.util.ArrayList;
import java.util.List;

public class Solution
{// naive solution O(n*n)
    public int countRangeSum( int[] nums, int lower, int upper ) {
        int result = 0;
        List<Integer> allSums = new ArrayList<>();
        for( int i : nums ) {
            if( !allSums.isEmpty() ) {
                for( int n = 0; n < allSums.size(); n++ ) {
                    allSums.set( n, allSums.get( n ) + i );
                    if( allSums.get( n ) >= lower && allSums.get( n ) <= upper ) {
                        result++;
                    }
                }
            }
            if( i >= lower && i <= upper ) {
                result++;
            }
            allSums.add( i );
        }
        return result;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { -2, 5, -1 };
        s.countRangeSum( nums, -2, 2 );
    }
}
