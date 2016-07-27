package searchforaRange;

public class Solution {
    public int[] searchRange(int[] nums, int target) {

        int searchStart = 0;
        int searchEnd = nums.length - 1;


        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (target >= nums[searchStart] && target <= nums[searchEnd]) {
            findTarget(nums, target, searchStart, searchEnd, result);
        }

        return result;

    }

    private void findTarget(int[] nums, int target, int startIndex, int endIndex, int[] result) {
        if (startIndex > endIndex) {
            return;
        }

        if (nums[startIndex] == target) {
            if (startIndex < result[0] || result[0] == -1) {
                result[0] = startIndex;
            }
        } else if (nums[startIndex] > target) {
            return;
        }

        if (nums[endIndex] == target) {
            if (endIndex > result[1] || result[1] == -1) {
                result[1] = endIndex;
            }
        } else if (nums[endIndex] < target) {
            return;
        }

        if (startIndex == endIndex) {
            return;
        }

        int mid = startIndex + (endIndex - startIndex) / 2;

        if (nums[mid] > target) {
            findTarget(nums, target, startIndex, mid - 1, result);
        } else if (nums[mid] < target) {
            findTarget(nums, target, mid + 1, endIndex, result);
        }else{
            if (result[0] == -1 || startIndex < result[0]) {
                result[0] = mid;
            }
            if (result[1] == -1 || endIndex > result[1]) {
                result[1] = mid;
            }
            findTarget(nums, target, mid + 1, endIndex, result);
            findTarget(nums, target, startIndex, mid - 1, result);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 4, 5, 5, 6, 6, 6, 8, 10, 10 };

        s.searchRange(nums, 4);
    }

}
