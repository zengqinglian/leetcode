package longestConsecutiveSequence;

import java.util.Arrays;

public class Solution
{
    public int longestConsecutive( int[] nums ) {
        Arrays.sort( nums );

        int index = 1;
        int length = 1;
        int result = 1;
        while( index < nums.length ) {
            if( nums[index] - nums[index - 1] == 1 ) {
                length++;
            } else if( nums[index] != nums[index - 1] ) {
                length = 1;
            }
            result = Math.max( result, length );
            index++;
        }
        return length;
    }

    public static void main( String[] args ) {
        int[] nums = { 0, 0, -1 };
        Solution s = new Solution();
        s.longestConsecutive( nums );
    }
}
