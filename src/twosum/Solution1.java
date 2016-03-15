package twosum;

public class Solution1
{
    public int[] twoSum( int[] nums, int target ) {
        int length = nums.length;
        int index = 0;
        while( index < length - 1 ) {
            for( int i = index + 1; i < length; i++ ) {
                if( nums[index] + nums[i] == target ) {
                    return new int[] { 1, 2 };
                }
            }
        }
        return new int[] {};
    }
}
