package continuousSubarraySum;

public class Solution {
    // nature solution
    public boolean checkSubarraySum(int[] nums, int k) {
        int length = nums.length;
        if (length < 2) {
            return false;
        }
        for (int i = 0; i < length - 1; i++) {
            int total = nums[i];
            for (int j = i + 1; j < length; j++) {
                total = total + nums[j];
                if ((k == 0 && total == k) || (k != 0 && total % k == 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Solution s = new Solution();
        s.checkSubarraySum(nums, 6);
    }
}
