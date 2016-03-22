package moveZeroes;

public class Solution1
{
    public void moveZeroes( int[] nums ) {
        int i = 0, j = 0;
        while( j < nums.length && nums[j] != 0 ) {
            i++;
            j++;
        }
        j++;
        while( j < nums.length ) {
            if( nums[j] != 0 ) {
                nums[i] = nums[j];
                nums[j] = 0;
                i++;
            }
            j++;
        }
    }

    public static void main( String[] args ) {
        Solution1 s = new Solution1();
        int[] nums = { 1, 0, 3, 0, 12 };
        s.moveZeroes( nums );
    }
}
