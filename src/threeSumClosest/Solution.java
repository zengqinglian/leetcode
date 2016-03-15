package threeSumClosest;

import java.util.Arrays;

public class Solution
{
    public int threeSumClosest( int[] nums, int target ) {

        if( nums.length < 3 ) {
            throw new IllegalArgumentException();
        }
        Arrays.sort( nums );
        int leftPointer = 0;
        int rightPointer = nums.length - 1;
        int gap = Integer.MAX_VALUE;
        int retVal = 0;

        while( leftPointer + 1 < rightPointer ) {
            int twoSum = nums[leftPointer] + nums[rightPointer];
            int oneLoopGap = Integer.MAX_VALUE;
            int oneLoopVal = 0;
            for( int i = 0; i < nums.length - 1; i++ ) {
                if( i == leftPointer || i == rightPointer ) {
                    continue;
                }
                int oneLoopThreeSum = twoSum + nums[i];
                if( oneLoopThreeSum == target ) {
                    return oneLoopThreeSum;
                } else {
                    if( Math.abs( oneLoopThreeSum - target ) < oneLoopGap ) {
                        oneLoopVal = oneLoopThreeSum;
                        oneLoopGap = Math.abs( oneLoopThreeSum - target );
                    }
                }
            }
            if( oneLoopGap < gap ) {
                gap = oneLoopGap;
                retVal = oneLoopVal;
            }
            if( oneLoopVal > target ) {
                rightPointer--;
            } else if( oneLoopVal < target ) {
                leftPointer++;
            }
        }

        return retVal;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { 0, 1, 2 };

        System.out.print( s.threeSumClosest( nums, 0 ) );
    }
}
