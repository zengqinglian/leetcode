package containsDuplicate;

import java.util.HashSet;
import java.util.Set;

public class Solution
{
    // time limit over
    public boolean containsDuplicate( int[] nums ) {
        if( nums == null || nums.length == 0 ) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for( int i : nums ) {
            if( !set.add( i ) ) {
                return true;
            }
        }
        return false;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        s.containsDuplicate( nums );
    }
}
