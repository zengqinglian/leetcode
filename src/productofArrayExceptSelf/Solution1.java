package productofArrayExceptSelf;

import java.util.Arrays;

public class Solution1
{
    public int[] productExceptSelf( int[] nums ) {
        int[] result = new int[nums.length];
        Arrays.fill( result, 1 );
        int i = 1, j = nums.length - 2;
        int bottom = 1;
        int up = 1;
        while( i < nums.length && j >= 0 ) {
            bottom *= nums[j + 1];
            up *= nums[i - 1];
            result[i] = result[i] * up;
            result[j] = result[j] * bottom;
            i++;
            j--;
        }
        return result;
    }

    public static void main( String[] args ) {
        int[] nums = { 1, 0 };
        Solution1 s = new Solution1();
        s.productExceptSelf( nums );
    }
}
