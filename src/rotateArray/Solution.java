package rotateArray;

public class Solution
{
    public void rotate( int[] nums, int k ) {

        int length = nums.length;
        k %= length;
        reverse( nums, 0, length - 1 );
        reverse( nums, 0, k - 1 );
        reverse( nums, k, length - 1 );
    }

    private void reverse( int[] nums, int start, int end ) {
        int i = start;
        int j = end;
        while( i < j ) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        s.rotate( nums, 4 );
        System.out.print( nums );
    }
}
