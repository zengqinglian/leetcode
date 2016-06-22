package removeDuplicatesfromSortedArrayII;

import java.util.HashMap;
import java.util.Map;

public class Solution
{
    // map solution - slow
    public int removeDuplicates( int[] nums ) {
        Map<Integer, Integer> result = new HashMap<>();
        int total = 0;
        for( int i : nums ) {
            if( !result.containsKey( i ) ) {
                result.put( i, 1 );
                nums[total] = i;
                total++;
            } else {
                if( result.get( i ) == 1 ) {
                    result.put( i, 2 );
                    nums[total] = i;
                    total++;
                }
            }
        }
        return total;
    }
}
