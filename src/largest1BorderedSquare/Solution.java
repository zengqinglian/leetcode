package largest1BorderedSquare;

public class Solution {
    // 8 ms solution , beat 38%
    public int largest1BorderedSquare(int[][] grid) {
	int res = 0;
	for (int i = 0; i < grid.length; i++) {
	    for(int j=0; j<grid[0].length; j++) {
		if (grid[i][j] == 0) {
		    continue;
		}
		if (res == 0) {
		    res = 1;
		}
		int start = 1;
		if (res > 0) {
		    start = (int) Math.sqrt(res);
		}
		for (int n = start; n + i < grid.length && j + n < grid[0].length; n++) {
		    if (grid[n + i][n + j] == 1) {
			int size = calculate(grid, i, j, i + n, j + n);
			if (size > 0)
			    res = Math.max(res, calculate(grid, i, j, i + n, j + n));
			else if (size < 0) {
			    break;
			}

		    }
		 }
	    }
	   
	}
	return res;
    }

    private int calculate(int[][] grid, int i, int j, int k, int l) {

	for (int x = j; x <= l; x++) {
	    if (grid[i][x] == 1 && grid[k][x] == 1) {
		continue;
	    } else if (grid[i][x] != 1) {
		return -1;
	    } else {
		return 0;
	    }
	}

	for (int x = i; x <= k; x++) {
	    if (grid[x][j] == 1 && grid[x][l] == 1) {
		continue;
	    } else if (grid[x][j] != 1) {
		return -1;
	    } else {
		return 0;
	    }
	}

	return (k - i + 1) * (k - i + 1);
    }

    public static void main(String[] args) {
	int[][] grid = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
	Solution s = new Solution();
	s.largest1BorderedSquare(grid);
    }

}
