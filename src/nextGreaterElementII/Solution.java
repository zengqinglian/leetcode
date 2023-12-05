package nextGreaterElementII;

import java.util.Stack;
/*
Runtime
11 ms
Beats
75.77%
Memory
44.9 MB
Beats
50.81%
 */
public class Solution {
    public int[] nextGreaterElements(int[] nums) {
        if (nums.length==1) {
            int[] res = {-1};
            return res;
        }
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        for (int i=0; i<nums.length*2; i++) {
            int idx = i % nums.length;
            if(stack.isEmpty()) {
                stack.push(idx);
            }else{
                while(!stack.isEmpty()) {
                    int top = stack.peek();
                    if (nums[top]< nums[idx]) {
                        stack.pop();
                        res[top] = nums[idx];
                    }else {
                        if (i<nums.length)
                            stack.push(idx);
                        break;
                    }
                }
                if (i<nums.length && stack.isEmpty()) {
                    stack.push(idx);
                }
            }
        }
        while(!stack.isEmpty()) {
            res[stack.pop()] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,1,1,1,1};
        s.nextGreaterElements(nums);
    }
}
