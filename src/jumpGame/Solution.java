package jumpGame;

public class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length<=1){
            return true;
        }

        boolean[] dp = new boolean[nums.length];
        dp[0] = true;
        int max = 0;
        for (int i = 0; i < dp.length - 1; i++) {
            if (dp[i] == false && max < i) {
                continue;
            }
            if (nums[i] + i >= dp.length - 1) {
                return true;
            } else {
                max = Math.max(max, nums[i] + i);
                dp[nums[i] + i] = true;
            }
        }

        return dp[nums.length - 1];

    }

    public static void main(String[] args) {
        int[] nums = { 3, 0, 8, 2, 0, 0, 1 };
        Solution s = new Solution();
        s.canJump(nums);
    }
}
