package findPeakElement;

public class Solution
{
    public int findPeakElement( int[] nums ) {
        if( nums == null || nums.length == 0 ) {
            return 0;
        }
        if( nums.length == 1 ) {
            return 0;
        }

        if( nums[0] > nums[1] ) {
            return 0;
        }

        if( nums[nums.length - 1] > nums[nums.length - 2] ) {
            return nums.length - 1;
        }

        int i = 1;
        while( i < nums.length - 1 ) {
            if( nums[i - 1] < nums[i] && nums[i] > nums[i + 1] ) {
                return i;
            }
            i++;
        }

        return -1;
    }
}
