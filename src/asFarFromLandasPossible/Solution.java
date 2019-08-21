package asFarFromLandasPossible;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // 24ms solution beat 50%
    public int maxDistance(int[][] grid) {
	boolean[][] visited = new boolean[grid.length][grid.length];
	Queue<int[]> q = new LinkedList<>();
	int cnt = 0;
	int[] X = { 1, -1, 0, 0 };
	int[] Y = { 0, 0, 1, -1 };
	for (int i = 0; i < grid.length; i++) {
	    for (int j = 0; j < grid.length; j++) {
		if(grid[i][j] == 1) {
		    for (int n = 0; n < 4; n++) {
			int newX = i + X[n];
			int newY = j + Y[n];
			if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid.length) {
			    if (grid[newX][newY] == 0) {
				int[] p = { newX, newY };
				q.add(p);
				visited[newX][newY] = true;
			    }
			}
		    }
		}
	    }
	}
	if (q.isEmpty()) {
	    return -1;
	}
	while (!q.isEmpty()) {
	    int size = q.size();
	    for (int i = 0; i < size; i++) {
		int[] p = q.poll();
		for (int n = 0; n < 4; n++) {
		    int newX = p[0] + X[n];
		    int newY = p[1] + Y[n];
		    if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid.length) {
			if (!visited[newX][newY] && grid[newX][newY] == 0) {
			    int[] newP = { newX, newY };
			    q.add(newP);
			    visited[newX][newY] = true;
			}
		    }
		}
	    }
	    cnt++;
	}

	return cnt;

    }
}
