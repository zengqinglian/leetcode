package maximalRectangle;

import java.util.Stack;

public class Solution1 {
    // change to largestRectangleinHistogram quesiton.
    // loop through each row. caculate the bar length.
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length == 0){
            return 0;
        }
        int length = matrix.length;
        int[] lastResult = null;
        int max = 0;
        for (int i = 0; i < length; i++) {
            char[] currentRow = matrix[i];
            lastResult = getHistogram(currentRow, lastResult);
            max = Math.max(max, largestRectangleArea(lastResult));
        }
        return max;

    }

    private int[] getHistogram(char[] currentRow, int[] lastResult) {
        int[] result = new int[currentRow.length];
        if (lastResult == null) {
            for (int i = 0; i < currentRow.length; i++) {
                if (currentRow[i] == '1') {
                    result[i] = 1;
                } else {
                    result[i] = 0;
                }
            }
        } else {
            for (int i = 0; i < currentRow.length; i++) {
                if (currentRow[i] == '1') {
                    result[i] = lastResult[i] + 1;
                } else {
                    result[i] = 0;
                }
            }
        }

        return result;
    }

    private int largestRectangleArea(int[] heights) {
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
        Solution1 s = new Solution1();
        char[][] matrix = { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
                { '1', '0', '0', '1', '0' } };
        s.maximalRectangle(matrix);
    }
}
