package contiguousArray;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
    // beat 60% solution.
    public int findMaxLength(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int sum[] = new int[nums.length];
        sum[0] = nums[0] == 0 ? -1 : 1;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + (nums[i] == 0 ? -1 : 1);
        }

        Map<Integer, Integer> sumPositionMap = new HashMap<Integer, Integer>();
        int result = 0;
        int i = 0;
        for (int s : sum) {
            if (s == 0) {
                result = Math.max(result, i + 1);
            }
            if (sumPositionMap.containsKey(s)) {
                result = Math.max(result, i - sumPositionMap.get(s));
            } else {
                sumPositionMap.put(s, i);
            }
            i++;
        }
        return result;

    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] nums = { 0, 0, 1, 1, 0, 0, 0, 0, 1, 1 };
        s.findMaxLength(nums);
    }
}
