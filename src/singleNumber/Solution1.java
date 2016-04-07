package singleNumber;

import java.util.HashSet;
import java.util.Set;

public class Solution1
{
    public int singleNumber( int[] nums ) {
        if( nums.length == 1 ) {
            return nums[0];
        }
        Set<Integer> set = new HashSet<>();
        int actualTotal = 0;
        int total = 0;
        for( int i : nums ) {
            actualTotal += i;
            if( set.add( i ) ) {
                total += i * 2;
            }
        }
        return total - actualTotal;
    }
}
