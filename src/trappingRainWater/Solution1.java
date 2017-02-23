package trappingRainWater;

public class Solution1 {
    // For each point, find left side max and right side max. Then calculate the
    // total

    // Over time limit - but very easy to understand
    public int trap(int[] height) {
        int total = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int left = leftMax(i, height);
            if (left <= height[i]) {
                continue;
            }
            int right = rightMax(i, height);
            if (right <= height[i]) {
                continue;
            }

            int h = Math.min(left, right);
            if (h - height[i] > 0) {
                total += h - height[i];
            }
        }

        return total;
    }

    private int leftMax(int startIndex, int[] height) {
        if (startIndex == 0) {
            return 0;
        }

        int maxLeft = 0;
        for (int i = startIndex - 1; i >= 0; i--) {
            if (height[startIndex] < height[i]) {
                maxLeft = Math.max(height[i], maxLeft);
            }
        }

        return maxLeft;
    }

    private int rightMax(int startIndex, int[] height) {
        if (startIndex == height.length - 1) {
            return 0;
        }

        int maxRight = 0;
        for (int i = startIndex + 1; i < height.length; i++) {
            if (height[startIndex] < height[i]) {
                maxRight = Math.max(height[i], maxRight);
            }
        }

        return maxRight;
    }
}
