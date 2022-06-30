package minimumSwapstoGroupAll1TogetherII;
/*
Runtime: 16 ms, faster than 49.30% of Java online submissions for Minimum Swaps to Group All 1's Together II.
Memory Usage: 88.8 MB, less than 15.69% of Java online submissions for Minimum Swaps to Group All 1's Together II.

 */
public class Solution {
    public int minSwaps(int[] nums) {
        if(nums.length == 1) {
            return 0;
        }
        int[] sumArray = new int[2*nums.length];
        int totalOnes = 0;
        int totalZero = 0;
        for(int i=0; i<nums.length * 2; i++) {
            int actualIndex = i;
            if (i>=nums.length) {
                actualIndex = i - nums.length;
            }
            if (nums[actualIndex]==1) {
                totalOnes++;
            }else{
                totalZero++;
            }
            sumArray[i] = totalZero;
        }
        totalOnes /=2;
        totalZero/=2;
        if (totalOnes  == nums.length || totalZero == nums.length) {
            return 0;
        }
        int res = Integer.MAX_VALUE;
        for(int i=totalOnes-1; i<2*nums.length; i++) {
            int preIndex = i - totalOnes;
            if (preIndex<0) {
                res = Math.min(res, sumArray[i]);
            }else{
                res = Math.min(res, sumArray[i]-sumArray[preIndex]);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums={1,0,1,1,1,0,0,0,1,0,0,1,1,1,0,0,1,1,1,0,0,0,0,1,1,0,0,1,1,0,0,1,0,0};
        //int[] nums={0,1,0,1,1,0,0};
        s.minSwaps(nums);
    }
}
