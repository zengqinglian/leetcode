package numberOfEnclaves;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // 21ms solution beat 5%
    public int numEnclaves(int[][] A) {
	boolean[][] visited = new boolean[A.length][A[0].length];
	int[] X = { 1, -1, 0, 0 };
	int[] Y = { 0, 0, 1, -1 };
	int res = 0;
	Queue<int[]> q = new LinkedList<>();
	for (int i = 0; i < A.length; i++) {
	    for (int j = 0; j < A[0].length; j++) {
		int count = 0;
		if (A[i][j] == 1 && !visited[i][j]) {
		    count = 1;
		    boolean off = false;
		    int[] p = { i, j };
		    q.add(p);
		    visited[i][j] = true;
		    while (!q.isEmpty()) {
			int[] pos = q.poll();
			for (int n = 0; n < 4; n++) {
			    if (pos[0] + X[n] >= 0 && pos[1] + Y[n] >= 0 && pos[0] + X[n] <= A.length - 1
				    && pos[1] + Y[n] <= A[0].length - 1) {
				if (A[pos[0] + X[n]][pos[1] + Y[n]] == 1 && !visited[pos[0] + X[n]][pos[1] + Y[n]]) {
				    int[] newPos = { pos[0] + X[n], pos[1] + Y[n] };
				    q.add(newPos);
				    count++;
				    visited[pos[0] + X[n]][pos[1] + Y[n]] = true;
				}

			    } else {
				off = true;
			    }
			}
		    }
		    
		    if (!off) {
			res += count;
		    }

		}
		
	    }
	}
	return res;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] A = { { 0, 1, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 0 } };
	s.numEnclaves(A);
    }
}
