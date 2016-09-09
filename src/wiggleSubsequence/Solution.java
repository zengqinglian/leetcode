package wiggleSubsequence;

public class Solution {
    // O(N) solution
    public int wiggleMaxLength(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        int index = 0;
        boolean isUp = false;
        int result = 1;
        while (index + 1 < nums.length) {
            if (nums[index] == nums[index + 1]) {
                index++;
            } else if (nums[index] > nums[index + 1]) {
                isUp = false;
                result = 2;
                index++;
                break;
            } else {
                isUp = true;
                result = 2;
                index++;
                break;
            }
        }

        while (index + 1 < nums.length) {
            if (nums[index] == nums[index + 1]) {
                index++;
            } else if (nums[index] > nums[index + 1]) {
                if (isUp) {
                    isUp = false;
                    result++;
                    index++;
                } else {
                    index++;
                }
            } else {
                if (isUp) {
                    index++;
                } else {
                    isUp = true;
                    result++;
                    index++;
                }
            }
        }

        return result;
    }
}
