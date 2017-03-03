package contiguousArray;

import java.util.Stack;

public class Solution {
    // over time limt O(NxN) - O(NxNxN)
    public int findMaxLength(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            Stack<Integer> stack = new Stack<>();
            int count = 0;
            int total = 0;
            if (result >= nums.length - i) {
                break;
            }
            for (int j = i; j < nums.length; j++) {
                if (stack.isEmpty()) {
                    stack.push(nums[j]);
                } else {
                    int top = stack.peek();
                    if (top != nums[j]) {
                        stack.pop();
                        count += 2;
                    } else {
                        stack.push(nums[j]);
                    }
                    if (stack.isEmpty()) {
                        total = count;
                    }
                }
            }
            result = Math.max(result, total);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = { 0, 1, 1, 0, 1, 1, 1, 0 };
        s.findMaxLength(nums);
    }
}
