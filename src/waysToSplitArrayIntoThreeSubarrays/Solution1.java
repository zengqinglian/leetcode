package waysToSplitArrayIntoThreeSubarrays;
/*
Over time limit
 */
public class Solution1 {
    public int waysToSplit(int[] nums) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        int total = 0;
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        for(int i=0; i<nums.length; i++) {
            int left = prefixSum[i];
            int secondIndex = -1;
            int thirdIndex = -1;
            for(int j=i+1; j<nums.length; j++) {
                int mid = prefixSum[j] - prefixSum[i];
                if (mid>=left) {
                    secondIndex = j;
                }
                if (secondIndex<0){
                    continue;
                }
                int totalSum = prefixSum[prefixSum.length-1] - left;
                for (int e=prefixSum.length-1; e>=secondIndex;e--) {
                    int rightSum = prefixSum[prefixSum.length-1] - prefixSum[e];
                    if (rightSum*2>=totalSum) {
                        thirdIndex = e+1;
                        break;
                    }
                }
                if ( thirdIndex!=-1) {
                    int addon = thirdIndex-secondIndex;
                    total += addon;
                    total = total % 1_000_000_007;
                    break;
                }
            }
        }
        return total;
    }

    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.waysToSplit(new int[]{1,1,1}));
    }
}
