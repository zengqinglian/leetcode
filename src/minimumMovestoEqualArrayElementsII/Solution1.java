package minimumMovestoEqualArrayElementsII;

import java.util.Arrays;

public class Solution1 {
    public int minMoves2(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        Arrays.sort(nums);
        int target = nums[nums.length / 2];
        int target1 = nums[nums.length / 2 - 1];
        boolean oddLength = (nums.length % 2 == 1);
        long total1 = 0;
        long total2 = 0;
        for (int i : nums) {
            total1 += Math.abs(target - i);
            if (!oddLength) {
                total2 += Math.abs(target1 - i);
            }
        }

        if (oddLength) {
            return (int) total1;
        } else {
            return (int) Math.min(total1, total2);
        }
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = { 203125577, -349566234, 230332704, 48321315, 66379082, 386516853, 50986744, -250908656,
                -425653504, -212123143 };
        s.minMoves2(nums);
    }
}
