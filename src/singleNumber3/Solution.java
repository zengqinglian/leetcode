package singleNumber3;

import java.util.Arrays;

public class Solution
{
    public int[] singleNumber( int[] nums ) {
        if( nums.length == 2 ) {
            return nums;
        }

        int[] returns = new int[2];
        int index = 0;
        int returnIndex = 0;

        Arrays.sort( nums );

        while( index < nums.length - 2 ) {
            if( nums[index] == nums[index + 1] ) {
                index = index + 2;
            } else {
                if( nums[index + 1] == nums[index + 2] ) {
                    returns[returnIndex] = nums[index];
                    returnIndex++;
                    if( returnIndex >= 2 ) {
                        break;
                    }
                    index = index + 3;
                } else if( nums[index] == nums[index + 2] ) {
                    returns[returnIndex] = nums[index + 1];
                    returnIndex++;
                    if( returnIndex >= 2 ) {
                        break;
                    }
                    index = index + 3;
                } else {
                    if( nums[index] == nums[index + 3] ) {
                        returns[0] = nums[index + 1];
                        returns[1] = nums[index + 2];
                    } else if( nums[index + 1] == nums[index + 3] ) {
                        returns[0] = nums[index];
                        returns[1] = nums[index + 2];
                    } else {
                        returns[0] = nums[index];
                        returns[1] = nums[index + 1];
                    }
                    return returns;
                }
            }
        }
        if( returnIndex == 1 ) {
            returns[1] = nums[nums.length - 1];
        }

        if( returnIndex == 0 ) {
            returns[0] = nums[nums.length - 1];
            returns[1] = nums[nums.length - 2];
        }
        return returns;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { 1403617094, -490450406, -1756388866, -967931676, 1878401007, 1878401007, -74743538, 1403617094, -1756388866,
                -74743538, -490450406, -1895772685 };
        s.singleNumber( nums );
    }
}
