package minimumScoreByChangingTwoElements;

import java.util.Arrays;
/*
Runtime
15 ms
Beats
63.83%
Analyze Complexity
Memory
55.60 MB
Beats
82.98%

 */
public class Solution {
    public int minimizeSum(int[] nums) {
        if (nums.length <=3) {
            return 0;
        }
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE;
        res = Math.min(res, nums[nums.length-1]-nums[2]);
        int avg = (nums[2]+nums[nums.length-1]) / 2;
        res = Math.min(res, avg-nums[2] + nums[nums.length-1]-avg);
        res = Math.min(res, nums[nums.length-3]-nums[0]);
        int avg2 = (nums[nums.length-3]+nums[0]) / 2;
        res = Math.min(res, avg2-nums[0] + nums[nums.length-3]-avg2);
        int avg3 = (nums[nums.length-2]+nums[1]) / 2;
        res = Math.min(res, avg2-nums[1] + nums[nums.length-2]-avg2);
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.minimizeSum(new int[]{58,42,8,75,28});
    }
}
