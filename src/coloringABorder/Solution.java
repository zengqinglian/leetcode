package coloringABorder;

import java.util.LinkedList;
import java.util.Queue;

//1m solution , beat 99%
public class Solution {
    int[] X = { -1, 1, 0, 0 };
    int[] Y = { 0, 0, 1, -1 };
    public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {

	boolean[][] visited = new boolean[grid.length][grid[0].length];
	Queue<int[]> q = new LinkedList<>();
	int origColor = grid[r0][c0];
	int[] origPoint = { r0, c0 };
	q.add(origPoint);
	visited[r0][c0] = true;
	while (!q.isEmpty()) {
	    int[] p = q.poll();

	    boolean isBorder = false;
	    if (p[0] == 0 || p[0] == grid.length - 1 || p[1] == 0 || p[1] == grid[0].length - 1) {
		isBorder = true;
	    }
	    for (int i = 0; i < 4; i++) {
		int newR = p[0] + X[i];
		int newC = p[1] + Y[i];
		if (newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length && !visited[newR][newC]) {
		    if (grid[newR][newC] == origColor) {
			int[] newpoint = { newR, newC };
			q.add(newpoint);
			visited[newR][newC] = true;
		    } else {
			isBorder = true;
		    }
		}
	    }
	    if (isBorder) {
		grid[p[0]][p[1]] = color;
	    }
	}

	return grid;

    }

    public static void main(String[] args) {

    }



}
