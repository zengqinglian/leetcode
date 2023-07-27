package rotateFunction;
/*
Runtime
4 ms
Beats
45.50%
Memory
60.8 MB
Beats
49.19%
 */
public class Solution {
    public int maxRotateFunction(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int sum = 0;
        int total = 0;
        for (int i=0; i<nums.length; i++) {
            sum+=nums[i];
            total += (i*nums[i]);
        }
        int max = total;
        for(int i=nums.length-1; i>=0; i--) {
            total = total - ((nums.length-1)*nums[i]);
            total = total + (sum-nums[i]);
            max = Math.max(max, total);
        }

        return max;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {4,3,2,6};
        s.maxRotateFunction(nums);
    }
}
