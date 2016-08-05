package combinationSumIV;

import java.util.Arrays;

//dp solution . meet avg
public class Solution1 {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 0;

        Arrays.sort(nums);
        for (int i = 1; i <= target; i++) {
            for (int j : nums) {
                if (j < i && i - j >= 0) {
                    dp[i] = dp[i] + dp[i - j];
                } else if (j == i) {
                    dp[i] = dp[i] + 1;
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = { 1, 2, 3 };
        s.combinationSum4(nums, 9);
    }
}
