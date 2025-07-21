package waysToSplitArrayIntoThreeSubarrays;

/*
Over time limit
 */
public class Solution {
    public int waysToSplit(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        int total = 0;
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        for(int i=0; i<nums.length; i++) {
            int left = prefixSum[i];
            for(int j=i+1; j<nums.length; j++) {
                int mid = prefixSum[j] - prefixSum[i];
                int right=-1;
                if (j+1<nums.length) {
                    right = prefixSum[prefixSum.length-1] - prefixSum[j];
                }
                if (mid>=left && mid<=right) {
                    total++;
                    total = total % 1_000_000_007;
                }
            }
        }
        return total;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.waysToSplit(new int[]{1,2,2,2,5,0}));
    }
}
