package jumpGameII;

public class Solution {
    // over time limit - dp solution
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > 0) {
                for (int j = 1; j <= nums[i]; j++) {
                    if (i + j >= nums.length) {
                        continue;
                    }
                    if (dp[i + j] == 0) {
                        dp[i + j] = dp[i] + 1;
                    } else {
                        dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
                    }
                }
            }
        }

        return dp[nums.length - 1];

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 2, 3, 1, 1, 4 };
        s.jump(nums);
    }
}
