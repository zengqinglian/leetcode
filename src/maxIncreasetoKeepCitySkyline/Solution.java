package maxIncreasetoKeepCitySkyline;

public class Solution {
    // 7ms solution, avg speed. beat over 50%
    public int maxIncreaseKeepingSkyline(int[][] grid) {
	int rows = grid.length;
	int cols = grid[0].length;
	int[] maxValRows = new int[rows];
	int[] maxValCols = new int[cols];
	for (int i = 0; i < rows; i++) {
	    for (int j = 0; j < cols; j++) {
		maxValRows[i] = Math.max(maxValRows[i], grid[i][j]);
		maxValCols[j] = Math.max(maxValCols[j], grid[i][j]);
	    }
	}
	
	int result = 0;
	for (int i = 0; i < rows; i++) {
	    for (int j = 0; j < cols; j++) {
		int val = Math.min(maxValRows[i], maxValCols[j]);
		result += (val - grid[i][j]);
	    }
	}
	return result;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] grid = { { 3, 0, 8, 4 }, { 2, 4, 5, 7 }, { 9, 2, 6, 3 }, { 0, 3, 1, 0 } };
	s.maxIncreaseKeepingSkyline(grid);
    }

}
