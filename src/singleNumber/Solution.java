package singleNumber;

import java.util.Arrays;

public class Solution
{
    // no extra space
    public int singleNumber( int[] nums ) {
        if( nums.length == 1 ) {
            return nums[0];
        }
        Arrays.sort( nums );
        int index = 0;
        while( index < nums.length - 2 ) {
            if( nums[index] == nums[index + 1] ) {
                index = index + 2;
            } else {
                if( nums[index + 1] == nums[index + 2] ) {
                    return nums[index];
                } else {
                    return nums[index + 1];
                }
            }
        }
        return nums[nums.length - 1];
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { 17, 12, 5, -6, 12, 4, 17, -5, 2, -3, 2, 4, 5, 16, -3, -4, 15, 15, -4, -5, -6 };
        s.singleNumber( nums );
    }
}
