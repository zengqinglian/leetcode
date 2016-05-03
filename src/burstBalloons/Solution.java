package burstBalloons;

public class Solution
{
    // over time limit, talk too long to do recursive.

    public int maxCoins( int[] nums ) {
        int result = maxSum( nums, 0 );
        return result;
    }

    private int maxSum( int[] nums, int total ) {
        System.out.println( "nums = " + nums );
        if( nums.length == 0 ) {
            return total + 0;
        }

        if( nums.length == 1 ) {
            return total + nums[0];
        }

        if( nums.length == 2 ) {
            return total + Math.max( nums[0], nums[1] ) + nums[0] * nums[1];
        }

        int result = Integer.MIN_VALUE;

        for( int i = 0; i < nums.length; i++ ) {
            int[] newNums = genNewNums( nums, i );
            if( i == 0 ) {
                result = Math.max( result, maxSum( newNums, total + nums[i] * nums[i + 1] ) );
            } else if( i == nums.length - 1 ) {
                result = Math.max( result, maxSum( newNums, total + nums[i - 1] * nums[i] ) );
            } else {
                result = Math.max( result, maxSum( newNums, total + nums[i - 1] * nums[i] * nums[i + 1] ) );
            }

        }

        return result;

    }

    private int[] genNewNums( int[] nums, int exclIndex ) {
        int index = 0;
        int[] newNums = new int[nums.length - 1];
        for( int i = 0; i < nums.length; i++ ) {
            if( i != exclIndex ) {
                newNums[index] = nums[i];
                index++;
            }
        }

        return newNums;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { 7, 9, 8, 0, 7 };
        s.maxCoins( nums );
    }
}
