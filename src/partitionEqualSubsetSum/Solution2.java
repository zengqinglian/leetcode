package partitionEqualSubsetSum;

import java.util.Arrays;

public class Solution2 {
    // improved dp - 38ms- beat 45%
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return true;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1)
            return false;
        Arrays.sort(nums);
        int target = sum / 2;
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] == target)
                return true;
            if (nums[i - 1] > target)
                return false;
            System.arraycopy(dp[i - 1], 0, dp[i], 0, Math.min(target + 1, nums[i - 1]));
            for (int j = nums[i - 1]; j <= target; j++) {
                dp[i][j] = dp[i - 1][j - nums[i - 1]];
            }
            if (dp[i][target])
                return true;
        }
        return false;
    }
}
