package largestRectangleinHistogram;

//Time Limit Exceeded Solution - of course O(n*n)
public class Solution {
    public int largestRectangleArea(int[] heights) {
        int retVal = 0;
        for (int i = 0; i < heights.length; i++) {
            int max = heights[i];
            int minVal = heights[i];
            for (int j = i + 1; j < heights.length; j++) {
                minVal = Math.min(minVal, heights[j]);
                max = Math.max(max, minVal * (j - i + 1));
            }
            retVal = Math.max(retVal, max);
        }

        return retVal;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] heights = { 2, 1, 5, 6, 2, 3 };

        s.largestRectangleArea(heights);
    }
}
