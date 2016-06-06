package kthLargestElementinanArray;

import java.util.Arrays;

public class Solution
{
    public int findKthLargest( int[] nums, int k ) {
        if( nums == null || nums.length == 0 ) {
            return 0;
        }

        Arrays.sort( nums );

        int length = nums.length;
        return nums[length - k];
    }
}
