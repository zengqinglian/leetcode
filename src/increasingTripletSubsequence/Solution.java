package increasingTripletSubsequence;

public class Solution
{
    public boolean increasingTriplet( int[] nums ) {

        if( nums.length < 3 ) {
            return false;
        }
        int min = nums[0];
        int minMiddle = Integer.MAX_VALUE;

        for( int i = 1; i < nums.length; i++ ) {
            if( nums[i] <= min ) {
                min = nums[i];
            } else if( minMiddle == Integer.MAX_VALUE || minMiddle > nums[i] ) {
                minMiddle = nums[i];
            } else if( nums[i] > minMiddle ) {
                return true;
            }

        }
        return false;

    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { 1, 1, -2, 6 };
        s.increasingTriplet( nums );
    }
}
