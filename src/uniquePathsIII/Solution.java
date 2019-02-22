package uniquePathsIII;

//2ms faster than 100% solution.
public class Solution {
    int[] X = { 1, -1, 0, 0 };
    int[] Y = { 0, 0, 1, -1 };
    int sum = 0;
    public int uniquePathsIII(int[][] grid) {

	boolean[][] visited = new boolean[grid.length][grid[0].length];
	int[] X = {1,-1,0,0};
	int[] Y = {0,0,1,-1};
	int[] start = new int[2];
	for (int i = 0; i < grid.length; i++) {
	    for (int j = 0; j < grid[0].length; j++) {
		if (grid[i][j] == 1) {
		    start[0] = i;
		    start[1] = j;
		    visited[i][j] = true;
		}
		if (grid[i][j] == 2 || grid[i][j] == -1) {
		    visited[i][j] = true;
		}
	    }
	}
	getPath(grid, visited, start);

	return sum;

    }

    private void getPath(int[][] grid, boolean[][] visited, int[] point) {
	for(int i=0; i<4; i++) {
	    int newX = point[0] + X[i];
	    int newY = point[1] + Y[i];
	    
	    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
		if (grid[newX][newY] == 2) {
		    if (allTrue(visited)) {
			sum++;
		    }
		}
		if (grid[newX][newY] == 0 && !visited[newX][newY]) {
		    visited[newX][newY] = true;
		    int[] newStart = { newX, newY };
		    getPath(grid, visited, newStart);
		    visited[newX][newY] = false;
		}
	    }
	}
    }

    private boolean allTrue(boolean[][] visited) {
	for (int i = 0; i < visited.length; i++) {
	    for (int j = 0; j < visited[0].length; j++) {
		if (!visited[i][j]) {
		    return false;
		}
	    }
	}
	return true;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
	s.uniquePathsIII(grid);
    }
}
