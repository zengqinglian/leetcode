package longestIncreasingSubsequence;

import java.util.Arrays;

public class Solution
{
    // dp O(n*n)
    public int lengthOfLIS( int[] nums ) {
        if( nums == null || nums.length == 0 ) {
            return 0;
        }
        if( nums.length == 1 ) {
            return 0;
        }
        int[] dp = new int[nums.length];

        Arrays.fill( dp, 1 );

        int leftP = 0;
        int rightP = 1;
        int index = 1;
        while( index < dp.length ) {
            while( leftP + 1 <= rightP ) {
                if( nums[leftP] < nums[rightP] ) {
                    dp[index] = Math.max( dp[index], dp[leftP] + 1 );
                }
                leftP++;
            }
            leftP = 0;
            rightP++;
            index++;
        }

        int max = 0;
        for( int i : dp ) {
            max = Math.max( max, i );
        }

        return max;
    }

    public static void main( String[] args ) {
        int[] nums = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };

        Solution s = new Solution();
        s.lengthOfLIS( nums );
    }
}
