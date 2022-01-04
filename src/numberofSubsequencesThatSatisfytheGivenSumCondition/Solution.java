package numberofSubsequencesThatSatisfytheGivenSumCondition;

import java.util.Arrays;
/*
DP solution cache all value of possibilities
Runtime: 28 ms, faster than 81.07% of Java online submissions for Number of Subsequences That Satisfy the Given Sum Condition.
Memory Usage: 47.8 MB, less than 82.85% of Java online submissions for Number of Subsequences That Satisfy the Given Sum Condition.
 */
public class Solution {
    public int numSubseq(int[] nums, int target) {
        int seq = 0;
        Arrays.sort(nums);
        int j;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++)
            dp[i] = (int) ((2 * dp[i - 1]) % 1_000_000_007);
        int i;
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                seq = (int) ((seq + dp[j - i]) % 1_000_000_007);
                i++;
            } else
                j--;
        }
        return seq;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {27,21,14,2,15,1,19,8,12,24,21,8,12,10,11,30,15,18,28,14,26,9,2,24,23,11,7,12,9,17,30,9,28,2,14,22,19,19,27,6,15,12,29,2,30,11,20,30,21,20,2,22,6,14,13,19,21,10,18,30,2,20,28,22};
        s.numSubseq(nums, 31);
    }
}
