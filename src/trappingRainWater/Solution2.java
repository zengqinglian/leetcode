package trappingRainWater;

/*
 * Basically this solution runs two pointers from 
 * two sides to the middle, and the plank is used 
 * to record the height of the elevation within a 
 * certain range, plank height can only increase 
 * (or remain the same) from two sides to the middle. 
 * If the current pointer is pointing at a number that 
 * is less than the current plank height, 
 * the difference between plank height and the number 
 * would be the amount of water trapped. 
 * Otherwise, height[i] == plank, no water is trapped.
 */
public class Solution2 {
    public int trap(int[] height) {
        int i = 0, j = height.length - 1, result = 0, plank = 0;
        while (i <= j) {
            plank = plank < Math.min(height[i], height[j]) ? Math.min(height[i], height[j]) : plank;
            result = height[i] >= height[j] ? result + (plank - height[j--]) : result + (plank - height[i++]);
        }
        return result;
    }
}
