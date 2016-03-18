package removeElement;

public class Solution
{
    public int removeElement( int[] nums, int val ) {
        if( nums == null || nums.length == 0 ) {
            return 0;
        }

        int i = 0;
        int j = nums.length - 1;

        int ret = 0;

        while( i <= j ) {
            if( nums[i] == val && nums[j] == val ) {
                j--;
            } else if( nums[i] == val && nums[j] != val ) {
                nums[i] = nums[j];
                i++;
                ret++;
                j--;
            } else if( nums[i] != val ) {
                i++;
                ret++;
            }
        }

        if( ret == 0 ) {
            nums = new int[0];
            return 0;
        }

        return ret;
    }
}
