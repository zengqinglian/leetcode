package largestRectangleinHistogram;

public class Solution1 {
    // nlogn Divide and Conquer solution - still over time limit. worset is
    // O(N*N)
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        return getMax(heights, 0, heights.length - 1);
    }

    public int getMax(int[] heights, int startIndex, int endIndex) {

        if (startIndex == endIndex) {
            return heights[startIndex];
        }

        int minIndex = findMin(heights, startIndex, endIndex);

        int mid = heights[minIndex] * (endIndex - startIndex + 1);

        int left = 0;
        if (minIndex == startIndex) {
            left = mid;
        } else {
            left = getMax(heights, startIndex, minIndex - 1);
        }

        int right = 0;
        if (minIndex == endIndex) {
            right = mid;
        } else {
            right = getMax(heights, minIndex + 1, endIndex);
        }



        if (mid >= right && mid >= left) {
            return mid;
        } else if (right >= mid && right >= left) {
            return right;
        } else {
            return left;
        }

    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.print(s.largestRectangleArea(heights));
    }

    private int findMin(int[] heights, int startIndex, int endIndex) {
        int min = heights[startIndex];
        int index = startIndex;
        for (int i = startIndex + 1; i <= endIndex; i++) {
            if (min > heights[i]) {
                index = i;
                min = heights[i];
            }
        }
        return index;
    }
}
