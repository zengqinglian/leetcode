package minimumDifferenceBetweenLargestandSmallestValueinThreeMoves;

import java.util.Arrays;
/*
Runtime: 14 ms, faster than 92.25% of Java online submissions for Minimum Difference Between Largest and Smallest Value in Three Moves.
Memory Usage: 54.6 MB, less than 47.14% of Java online submissions for Minimum Difference Between Largest and Smallest Value in Three Moves.
 */
public class Solution {
    public int minDifference(int[] nums) {
        if(nums.length<=3){
            return 0;
        }
        Arrays.sort(nums);
        //case 1
        int res = Integer.MAX_VALUE;
        res = Math.min(res, nums[nums.length-1] - nums[3]);
        res = Math.min(res, nums[nums.length-2] - nums[2]);
        res = Math.min(res, nums[nums.length-3] - nums[1]);
        res = Math.min(res, nums[nums.length-4] - nums[0]);
        return res;
    }
}
