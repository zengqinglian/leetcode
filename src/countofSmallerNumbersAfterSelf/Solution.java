package countofSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    // memeory over limit solution
    public List<Integer> countSmaller( int[] nums ) {
        List<Integer> resultList = new ArrayList<>();
        if( nums.length == 0 ) {
            return resultList;
        }
        if( nums.length == 1 ) {
            resultList.add( 0 );
            return resultList;
        }
        int length = nums.length;
        int[][] result = new int[length][length];
        for( int i = 0; i < length; i++ ) {
            for( int j = i; j >= 0; j-- ) {
                if( j == i ) {
                    result[i][j] = 0;
                } else if( nums[i] < nums[j] ) {
                    result[i][j] = result[i - 1][j] + 1;
                } else {
                    result[i][j] = result[i - 1][j];
                }
            }
        }

        for( int i = 0; i < length; i++ ) {
            resultList.add( result[length - 1][i] );
        }

        return resultList;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { 5, 2, 6, 1 };
        s.countSmaller( nums );
    }
}
