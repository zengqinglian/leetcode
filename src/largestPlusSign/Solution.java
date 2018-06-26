package largestPlusSign;

import java.util.LinkedList;
import java.util.Queue;

// 210ms solution beat 50%
public class Solution {
    int[] X = { 1, -1, 0, 0 };
    int[] Y = { 0, 0, 1, -1 };

    int[] newX = { 0, 0, 1, 1, 1, -1, -1, -1 };
    int[] newY = { 1, -1, 0, 1, -1, 0, 1, -1 };

    public int orderOfLargestPlusSign(int N, int[][] mines) {
	int[][] board = new int[N][N];
	boolean[][] track = new boolean[N][N];

	for (int[] p : mines) {
	    board[p[0]][p[1]] = -1;
	}

	Queue<int[]> queue = new LinkedList<>();

	int maxPossible = 0;
	if (N % 2 == 1) {
	    int[] p = new int[2];
            p[0] = N / 2;
            p[1] = N / 2;
            queue.add(p);
            track[p[0]][p[1]] = true;
	    maxPossible = N / 2 + 1;
	} else {
	    int[] p1 = new int[2];
	    p1[0] = N / 2;
	    p1[1] = N / 2;
	    queue.add(p1);
	    track[p1[0]][p1[1]] = true;

	    int[] p2 = new int[2];
	    p2[0] = N / 2 - 1;
	    p2[1] = N / 2;
	    queue.add(p2);
	    track[p2[0]][p2[1]] = true;

	    int[] p3 = new int[2];
	    p3[0] = N / 2;
	    p3[1] = N / 2 - 1;
	    queue.add(p3);
	    track[p3[0]][p3[1]] = true;

	    int[] p4 = new int[2];
	    p4[0] = N / 2 - 1;
	    p4[1] = N / 2 - 1;
	    queue.add(p4);
	    track[p4[0]][p4[1]] = true;
	    maxPossible = N / 2;
	}

	int max = 0;
	while (!queue.isEmpty()) {
	    int len = queue.size();
	    for (int i = 0; i < len; i++) {
		int[] pos = queue.poll();
		if (board[pos[0]][pos[1]] == 0) {
		    max = Math.max(max, getPlusSize(board, pos, N));
		}
		if (max == maxPossible) {
		    return maxPossible;
		}
		// add neighbour
		for (int j = 0; j < 8; j++) {
		    if (pos[0] + newX[j] >= 0 && pos[0] + newX[j] < N && pos[1] + newY[j] >= 0
			    && pos[1] + newY[j] < N) {
			if (!track[pos[0] + newX[j]][pos[1] + newY[j]]) {
			    int[] newPos = new int[2];
			    newPos[0] = pos[0] + newX[j];
			    newPos[1] = pos[1] + newY[j];
			    queue.add(newPos);
			    track[pos[0] + newX[j]][pos[1] + newY[j]] = true;
			}
		    }
		}
	    }
	    maxPossible--;
	}

	return max;
    }

    private int getPlusSize(int[][] board, int[] pos, int N) {
	int i = 1;
	int result = 1;
	while (pos[0] - i >= 0 && pos[0] + i < N && pos[1] - i >= 0 && pos[1] + i < N) {
	    for (int j = 0; j < 4; j++) {
		if (board[pos[0] + X[j] * i][pos[1] + Y[j] * i] < 0) {
		    return result;
		}
	    }
	    result++;
	    i++;
	}
	return result;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] mines = { { 4, 2 } };
	s.orderOfLargestPlusSign(5, mines);
    }
}
