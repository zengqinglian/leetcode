package numberOfEnclaves;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
    // 8ms solution , beat 33%
    public int numEnclaves(int[][] A) {
	int total = 0;
	for (int i = 0; i < A.length; i++) {
	    for (int j = 0; j < A[0].length; j++) {
		if (A[i][j] == 1) {
		    total++;
		}
	    }
	}
	int[] X = { 1, -1, 0, 0 };
	int[] Y = { 0, 0, 1, -1 };

	boolean[][] visited = new boolean[A.length][A[0].length];
	Queue<int[]> q = new LinkedList<>();
	int res = 0;
	for (int i = 0; i < A.length; i++) {
	    if (i == 0 || i == A.length - 1) {
		for (int j = 0; j < A[0].length; j++) {
		    if (A[i][j] == 1 && !visited[i][j]) {
			int[] p = { i, j };
			q.add(p);
			visited[i][j] = true;
			res++;
			while (!q.isEmpty()) {
			    int[] pos = q.poll();
			    for (int n = 0; n < 4; n++) {
				if (pos[0] + X[n] >= 0 && pos[1] + Y[n] >= 0 && pos[0] + X[n] <= A.length - 1
					&& pos[1] + Y[n] <= A[0].length - 1 && A[pos[0] + X[n]][pos[1] + Y[n]] == 1
					&& !visited[pos[0] + X[n]][pos[1] + Y[n]]) {
				    int[] newPos = { pos[0] + X[n], pos[1] + Y[n] };
				    q.add(newPos);
				    res++;
				    visited[pos[0] + X[n]][pos[1] + Y[n]] = true;
				}

			    }
			}
		    }
		}
	    } else {

		if (A[i][0] == 1 && !visited[i][0]) {
		    res++;
		    int[] p = { i, 0 };
		    q.add(p);
		    visited[i][0] = true;
		    while (!q.isEmpty()) {
			int[] pos = q.poll();
			for (int n = 0; n < 4; n++) {
			    if (pos[0] + X[n] >= 0 && pos[1] + Y[n] >= 0 && pos[0] + X[n] <= A.length - 1
				    && pos[1] + Y[n] <= A[0].length - 1 && A[pos[0] + X[n]][pos[1] + Y[n]] == 1
				    && !visited[pos[0] + X[n]][pos[1] + Y[n]]) {
				int[] newPos = { pos[0] + X[n], pos[1] + Y[n] };
				q.add(newPos);
				res++;
				visited[pos[0] + X[n]][pos[1] + Y[n]] = true;
			    }

			}
		    }
		}

		if (A[i][A[0].length - 1] == 1 && !visited[i][A[0].length - 1]) {
		    res++;
		    int[] p = { i, A[0].length - 1 };
		    q.add(p);
		    visited[i][A[0].length - 1] = true;
		    while (!q.isEmpty()) {
			int[] pos = q.poll();
			for (int n = 0; n < 4; n++) {
			    if (pos[0] + X[n] >= 0 && pos[1] + Y[n] >= 0 && pos[0] + X[n] <= A.length - 1
				    && pos[1] + Y[n] <= A[0].length - 1 && A[pos[0] + X[n]][pos[1] + Y[n]] == 1
				    && !visited[pos[0] + X[n]][pos[1] + Y[n]]) {
				int[] newPos = { pos[0] + X[n], pos[1] + Y[n] };
				q.add(newPos);
				res++;
				visited[pos[0] + X[n]][pos[1] + Y[n]] = true;
			    }
			}
		    }

		}
	    }
	}

	return total - res;
    }
}
