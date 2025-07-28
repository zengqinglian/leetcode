package maximumNumberOfJumpsToReachTheLastIndex;

import java.util.Arrays;
/*
14ms
Beats 74.65%
Analyze Complexity
Memory
45.36 MB
Beats 21.20%
 */
public class Solution {
    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j]>=0) {
                    if (Math.abs(nums[i]-nums[j])<=target) {
                        dp[i] = Math.max(dp[i],dp[j]+1);
                    }
                }
            }
        }
        return dp[nums.length-1] < 0 ? -1: dp[nums.length-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumJumps(new int[]{1,3,6,4,1,2}, 2));
    }
}
