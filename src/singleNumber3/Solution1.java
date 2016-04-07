package singleNumber3;

public class Solution1
{

    // cool bit solution from others
    public int[] singleNumber( int[] nums ) {
        int A = 0;
        int B = 0;
        int AXORB = 0;
        for( int i = 0; i < nums.length; i++ ) {
            AXORB ^= nums[i];
        }

        AXORB = (AXORB & (AXORB - 1)) ^ AXORB; // find the different bit in A and B ??????
        for( int i = 0; i < nums.length; i++ ) {
            if( (AXORB & nums[i]) == 0 )
                A ^= nums[i];
            else
                B ^= nums[i];
        }
        return new int[] { A, B };
    }

    public static void main( String[] args ) {
        Solution1 s = new Solution1();
        int[] nums = { 1403617094, -490450406, -1756388866, -967931676, 1878401007, 1878401007, -74743538, 1403617094, -1756388866,
                -74743538, -490450406, -1895772685 };
        s.singleNumber( nums );
    }
}
