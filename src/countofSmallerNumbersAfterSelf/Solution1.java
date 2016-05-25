package countofSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.List;

public class Solution1
{
    // Time Limit Exceeded
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
        for( int i = 0; i < length - 1; i++ ) {
            int total = 0;
            for( int j = i + 1; j < length; j++ ) {
                if( nums[i] > nums[j] ) {
                    total++;
                }
            }
            resultList.add( total );
        }
        resultList.add( 0 );
        return resultList;
    }
}
