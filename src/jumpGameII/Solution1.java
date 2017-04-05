package jumpGameII;

public class Solution1 {
    // improvement. beat 70%
    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }

        int[] dp = new int[nums.length];
        dp[0] = 0;
        int max = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            if (i + nums[i] >= nums.length - 1) {
                return dp[i] + 1;
            } else if (i + nums[i] > max) {
                for (int j = max + 1; j <= i + nums[i]; j++) {
                    dp[j] = dp[i] + 1;
                }
                max = i + nums[i];
            }
        }

        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = { 1, 2 };
        s.jump(nums);
    }
}
