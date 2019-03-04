package shortestBridge;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // 189ms solution beat 5%
    public int shortestBridge(int[][] A) {
	boolean[][] island1 = new boolean[A.length][A[0].length];
	for (int i = 0; i < A.length; i++) {
	    for (int j = 0; j < A[0].length; j++) {
		if (A[i][j] == 1) {

		    break;
		}
	    }
	}

	int[] moveI = {1,-1,0,0};
	int[] moveJ = {0,0,1,-1};
	boolean marked = false;
	for (int i = 0; i < A.length; i++) {
	    if (marked) {
		break;
	    }
	    for (int j = 0; j < A[0].length; j++) {
		if (A[i][j] == 1) {
		    markIsland(island1, i, j, moveI, moveJ, A);
		    marked = true;
		    break;
		}
	    }
	}

	int res = Integer.MAX_VALUE;
	for (int i = 0; i < A.length; i++) {
	    for (int j = 0; j < A[0].length; j++) {
		if(A[i][j] == 1 && island1[i][j]) {
		    Queue<int[]> q = new LinkedList<>();
		    boolean[][] visited = new boolean[A.length][A[0].length];

		    int[] p = {i,j,0};
		    visited[i][j] = true;
		    q.add(p);

		    while (!q.isEmpty()) {
			int[] point = q.poll();
			if (point[2] >= res) {
			    break;
			}
			for (int x = 0; x < 4; x++) {
			    int newI = point[0] + moveI[x];
			    int newJ = point[1] + moveJ[x];

			    if (newI >= 0 && newI < A.length && newJ >= 0 && newJ < A[0].length) {
				if (A[newI][newJ] == 0 && !visited[newI][newJ]) {
				    int[] newPoint = { newI, newJ, point[2] + 1 };
				    visited[newI][newJ] = true;
				    q.add(newPoint);
				} else if (A[newI][newJ] == 1 && !island1[newI][newJ]) {
				    res = Math.min(res, point[2]);
				    break;
				}
			    }
			}

		    }
		}
	    }
	}
	

	return res;

    }


    private void markIsland(boolean[][] island1, int startI, int startJ, int[] moveI, int[] moveJ, int[][] A) {
	if(A[startI][startJ] ==0) {
	   return;
	}
	island1[startI][startJ] = true;
	for(int i =0 ; i<4; i++) {
	    int newI = startI + moveI[i];
	    int newJ = startJ + moveJ[i];
	    if (newI >= 0 && newI < A.length && newJ >= 0 && newJ < A[0].length && !island1[newI][newJ]) {
		markIsland(island1, newI, newJ, moveI, moveJ, A);
	    }
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] A = { { 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1, 1, 0, 0 },
		{ 0, 0, 0, 1, 1, 0, 1, 0 }, { 0, 0, 0, 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 },
		{ 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0 } };
	// int[][] A = { { 0, 1 }, { 1, 0 } };
	s.shortestBridge(A);
    }
}
