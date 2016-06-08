package houseRobberII;

public class Solution
{
    public int rob( int[] nums ) {
        if( nums == null || nums.length == 0 ) {
            return 0;
        }
        if( nums.length == 1 ) {
            return nums[0];
        }
        if( nums.length == 2 ) {
            return Math.max( nums[0], nums[1] );
        }
        if( nums.length == 3 ) {
            int max = Math.max( nums[0], nums[1] );

            return Math.max( max, nums[2] );
        }

        int[] nums1 = new int[nums.length - 1];
        int[] nums2 = new int[nums.length - 1];
        int index1 = 0;
        int index2 = 0;
        for( int i = 0; i < nums.length; i++ ) {
            if( i == 0 ) {
                nums1[index1] = nums[i];
                index1++;
            } else if( i == nums.length - 1 ) {
                nums2[index2] = nums[i];
                index2++;
            } else {
                nums1[index1] = nums[i];
                index1++;
                nums2[index2] = nums[i];
                index2++;
            }
        }

        return Math.max( robNoCircle( nums1 ), robNoCircle( nums2 ) );

    }

    private int robNoCircle( int[] nums ) {
        int[] dp = new int[nums.length];
        if( nums.length == 1 ) {
            return nums[0];
        } else if( nums.length == 2 ) {
            return Math.max( nums[0], nums[1] );
        } else {
            dp[0] = nums[0];
            dp[1] = Math.max( dp[0], nums[1] );

            for( int i = 2; i < nums.length; i++ ) {
                dp[i] = Math.max( dp[i - 2] + nums[i], dp[i - 1] );
            }
        }

        return dp[dp.length - 1];

    }
}
