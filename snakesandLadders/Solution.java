package snakesandLadders;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    // 21ms solution beat 60%
    public int snakesAndLadders(int[][] board) {
	Map<Integer, int[]> pos = new HashMap<>();
	int N = board.length;
	int x = N - 1;
	int y = 0;
	int increase = 1;
	for (int i = 1; i <= N * N; i++) {
	    int[] p = { x, y };
	    pos.put(i, p);
	    if (y + increase > N - 1) {
		x--;
		increase = -1;
	    } else if (y + increase < 0) {
		x--;
		increase = 1;
	    } else {
		y += increase;
	    }
	}
	boolean[] moves = new boolean[N * N];
	Queue<Integer> q = new LinkedList<>();
	int step = 0;
	q.add(1);
	moves[0] = true;
	while (!q.isEmpty()) {
	    int loop = q.size();
	    for (int i = 1; i <= loop; i++) {
		int val = q.poll();
		for (int j = 1; j <= 6; j++) {
		    int v = val + j;
		    int[] p = pos.get(v);
		    if (board[p[0]][p[1]] > 0) {
			v = board[p[0]][p[1]];
		    }
		    if (!moves[v - 1]) {
			if (v == N * N) {
			    return step + 1;
			} else {
			    q.add(v);
			    moves[v - 1] = true;
			}
		    }

		}
	    }
	    step++;
	}
	
	return -1;
    }
    
    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] board = {{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
	s.snakesAndLadders(board);
    }


}
