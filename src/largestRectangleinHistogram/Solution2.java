package largestRectangleinHistogram;

import java.util.Stack;

public class Solution2 {
    // someone 's o(n) solution
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }

        int max = 0;
        int areaWithTop = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < heights.length; i++) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i);
            } else {
                do {
                    int index = stack.pop();
                    areaWithTop = heights[index] * (stack.empty() ? i : i - stack.peek() - 1);
                    if (max < areaWithTop) {
                        max = areaWithTop;
                    }
                } while (!stack.isEmpty() && heights[stack.peek()] > heights[i]);
                stack.push(i);
            }
        }

        while (!stack.isEmpty()) {
            int index = stack.pop();
            areaWithTop = heights[index] * (stack.empty() ? heights.length : heights.length - stack.peek() - 1);
            if (max < areaWithTop) {
                max = areaWithTop;
            }
        }
        return max;

    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        s.largestRectangleArea(heights);
    }
}
