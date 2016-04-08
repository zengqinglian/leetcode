package rotateArray;

public class Solution1
{
    public void rotate( int[] nums, int k ) {

        int length = nums.length;
        k %= length;
        int[] temp = new int[k];
        for( int i = 0; i < k; i++ ) {
            temp[k - 1 - i] = nums[length - 1 - i];
        }

        for( int i = length - 1 - k; i >= 0; i-- ) {
            nums[i + k] = nums[i];
        }

        for( int i = 0; i < k; i++ ) {
            nums[i] = temp[i];
        }
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        s.rotate( nums, 3 );
        System.out.print( nums );
    }

}
