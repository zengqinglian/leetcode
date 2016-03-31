package majorityElement;

import java.util.Arrays;

public class Solution1
{
    public int majorityElement( int[] nums ) {
        Arrays.sort( nums );
        return nums[nums.length / 2];
    }
}
