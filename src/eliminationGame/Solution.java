package eliminationGame;

public class Solution {
    // Over memory limit
    public int lastRemaining(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2 || n == 3) {
            return 2;
        }

        int[] nums = new int[n / 2];
        for (int i = 1; i * 2 <= n; i++) {
            nums[i - 1] = 2 * i;
        }
        return getLast(nums, false, nums.length);

    }

    private int getLast(int[] nums, boolean leftToRight, int length) {
        if (length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return leftToRight ? nums[1] : nums[0];
        }

        int newLength = length / 2;
        if (length % 2 == 0 && !leftToRight) {
            for (int i = 0; i < newLength; i++) {
                nums[i] = nums[2 * i];
            }
        } else {
            for (int i = 0; i < newLength; i++) {
                nums[i] = nums[2 * i + 1];
            }
        }
        return getLast(nums, !leftToRight, newLength);
    }
}
