package swiminRisingWater;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {
    // Same logic but using backtrack is much quicker. Someone's 20ms solution beat
    // 90%
    PriorityQueue<square> pq;
    public int swimInWater(int[][] grid) {
	pq = new PriorityQueue<>(new Comparator<square>() {
	    @Override
	    public int compare(square o1, square o2) {
		return o1.value - o2.value;
	    }
	});
	int i = grid[0][0];
	return Math.max(i, helper(grid, 0, 0, 0));
    }

    public int helper(int[][] grid, int i, int j, int max) {
	if (i == grid.length - 1 && j == grid.length - 1) {
	    return max;
	}
	if (i - 1 >= 0 && grid[i - 1][j] != -1) {
	    pq.add(new square(i - 1, j, grid[i - 1][j]));
	    grid[i - 1][j] = -1;
	}
	if (j - 1 >= 0 && grid[i][j - 1] != -1) {
	    pq.add(new square(i, j - 1, grid[i][j - 1]));
	    grid[i][j - 1] = -1;
	}
	if (i + 1 < grid.length && grid[i + 1][j] != -1) {
	    pq.add(new square(i + 1, j, grid[i + 1][j]));
	    grid[i + 1][j] = -1;
	}
	if (j + 1 < grid.length && grid[i][j + 1] != -1) {
	    pq.add(new square(i, j + 1, grid[i][j + 1]));
	    grid[i][j + 1] = -1;
	}
	if (pq.isEmpty()) {
	    return max;
	}
	square temp = pq.poll();
	if (temp.value <= max) {
	    return helper(grid, temp.i, temp.j, max);
	} else {
	    return helper(grid, temp.i, temp.j, temp.value);
	}
    }

    class square {
	int i;
	int j;
	int value;

	square(int ii, int jj, int v) {
	    i = ii;
	    j = jj;
	    value = v;
	}
    }
}
