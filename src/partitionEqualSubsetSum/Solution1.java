package partitionEqualSubsetSum;

public class Solution1 {
    // DP solution - 78ms beat 20%
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int i : nums) {
            total += i;
        }

        if (total % 2 == 1) {
            return false;
        }

        int target = total / 2;

        return hasSubset(nums, target);

    }

    private boolean hasSubset(int[] nums, int target) {
        boolean[][] dp = new boolean[nums.length][target + 1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > target) {
                continue;
            }
            if (nums[i] == target) {
                return true;
            }
            if (i == 0) {
                dp[0][0] = true;
                dp[0][nums[0]] = true;
                continue;
            }
            for (int j = 0; j < target + 1; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                } else {
                    if (nums[i] > j) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (nums[i] == j) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[nums.length - 1][target]);
        return dp[nums.length - 1][target];
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = { 100 };
        s.canPartition(nums);
    }
}
