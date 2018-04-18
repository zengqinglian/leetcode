package swiminRisingWater;

import java.util.PriorityQueue;

public class Solution {
    // 80ms-90ms solution = beat 50%
    public int swimInWater(int[][] grid) {
	if(grid == null) {
	    return 0;
	}
	if(grid.length <= 1) {
	    return 0;
	}
	
	int r = grid.length;
	if(grid[0].length==0) {
	    return 0;    
	}
	
	int c = grid[0].length;
	
	
	boolean[][] tracker = new boolean[r][c];

	PriorityQueue<Node> q = new PriorityQueue<>((n1, n2) -> {
	    return Integer.compare(n1.v, n2.v);
	});

	if (c > 1) {
	    Node node = new Node(0, 1, grid[0][1]);
	    if (c == 1) {
		return grid[0][1];
	    }
	    q.add(node);
	    tracker[0][1] = true;
	}

	if (r > 1) {
	    Node node = new Node(1, 0, grid[1][0]);
	    if (r == 1) {
		return grid[1][0];
	    }
	    q.add(node);
	    tracker[1][0] = true;
	}

	tracker[1][0] = true;

	Node cur = null;

	int[] mr = { 1, -1, 0, 0 };
	int[] mc = { 0, 0, 1, -1 };

	int minMove = grid[0][0];
	while(!q.isEmpty()) {
	    cur = q.poll();
	    minMove = Math.max(minMove, cur.v);
	    for (int i = 0; i < 4; i++) {
		int newR = cur.r + mr[i];
		int newC = cur.c + mc[i];
		if (newR == r - 1 && newC == c - 1) {
		    return Math.max(minMove, grid[newR][newC]);
		}
		if (newR >= 0 && newR < r && newC >= 0 && newC < c && !tracker[newR][newC]) {
		    Node node = new Node(newR, newC, grid[newR][newC]);
		    q.add(node);
		    tracker[newR][newC] = true;
		}
	    }
	}
	
	return minMove;

    }

    private static class Node {
	private int r;
	private int c;
	private int v;

	Node(int r, int c, int v) {
	    this.r = r;
	    this.c = c;
	    this.v = v;
	}

	public String toString() {
	    return "r=" + r + ";c=" + c + ";v=" + v;
	}
    }
}
