package searchinRotatedSortedArray2;

public class Solution {
    // 7ms solution - compare to others very slow
    public boolean search(int[] nums, int target) {
        boolean result = search(nums, target, 0, nums.length - 1);
        System.out.println(result);
        return result;
    }

    private boolean search(int[] nums, int target, int start, int end) {
        if (nums[start] == target || nums[end] == target) {
            return true;
        } else if (end - start > 1) {
            int midIndex = start + (end - start) / 2;
            int mid = nums[midIndex];
            if (target == mid) {
                return true;
            } else if (target > nums[start] && target < mid) {
                return search(nums, target, start, midIndex - 1);
            } else if (target > mid && target < nums[end]) {
                return search(nums, target, midIndex + 1, end);
            } else if (mid < nums[start] && target > nums[end]) {
                return search(nums, target, start, midIndex - 1);
            } else if (mid > nums[end] && target < nums[start]) {
                return search(nums, target, midIndex + 1, end);
            } else {
                return search(nums, target, start, midIndex - 1) || search(nums, target, midIndex + 1, end);
            }

        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 1, 2, 1 };
        s.search(nums, 0);
    }
}
