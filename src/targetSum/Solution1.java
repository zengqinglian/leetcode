package targetSum;

public class Solution1 {
    // DP solution beat 65%
    public int findTargetSumWays(int[] nums, int S) {
        int size = nums.length;
        if (size == 0) {
            return 0;
        }
        if (size == 1) {
            if (nums[0] == S || nums[0] == -1 * S) {
                return 1;
            } else {
                return 0;
            }
        }

        int total = 0;
        for (int i : nums) {
            total += i;
        }

        if (total < S) {
            return 0;
        }

        int[][] dp = new int[size][total + 1];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < total + 1; j++) {
                if (i == 0) {
                    if(j==nums[0]){
                        if (nums[0] != 0) {
                            dp[i][j] = 1;
                        } else {
                            dp[i][j] = 2;
                        }
                    }
                }else{
                    int index1 = j + nums[i];
                    int index2 = Math.abs(j - nums[i]);
                    if (index1 <= total) {
                        dp[i][j] = dp[i - 1][index1] + dp[i - 1][index2];
                    } else {
                        dp[i][j] = dp[i - 1][index2];
                    }
                }
            }
        }
        return dp[size - 1][Math.abs(S)];
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = { 1, 1, 1, 1, 1 };

        s.findTargetSumWays(nums, 3);
    }
}
