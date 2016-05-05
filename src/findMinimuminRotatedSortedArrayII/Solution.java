package findMinimuminRotatedSortedArrayII;

public class Solution
{
    public int findMin( int[] nums ) {
        if( nums.length == 1 ) {
            return nums[0];
        }

        if( nums.length == 2 ) {
            return Math.min( nums[0], nums[1] );
        }

        int left = nums.length / 2;
        int right = left + 1;

        if( nums[left] > nums[right] ) {
            return nums[right];
        }

        while( left >= 0 && right < nums.length ) {
            if( left - 1 >= 0 ) {
                if( nums[left - 1] > nums[left] ) {
                    return nums[left];
                }
                left--;
            } else if( right + 1 < nums.length ) {
                if( nums[right] > nums[right + 1] ) {
                    return nums[right + 1];
                }
                right++;
            } else {
                left--;
                right++;
            }
        }

        return Math.min( nums[0], nums[nums.length - 1] );

    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { 0, 1, 1, 2, 2, 3, 0 };
        s.findMin( nums );
    }

}
