package shortestPathWithAlternatingColors;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

//6ms solution , beat 65%
public class Solution {
    int RED = 0;
    int BLUE = 1;
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {

	int[][] dp_red = new int[n][n];
	int[][] dp_blue = new int[n][n];

	for (int[] r : red_edges) {
	    dp_red[r[0]][r[1]] = 1;
	}

	for (int[] r : blue_edges) {
	    dp_blue[r[0]][r[1]] = 1;
	}

	int[] res = new int[n];
	Arrays.fill(res, -1);
	res[0] = 0;

	Queue<Node> q = new LinkedList<>();
	boolean[] red_visited = new boolean[n];
	boolean[] blue_visited = new boolean[n];
	
	for (int j = 1; j < n; j++) {
	    if (dp_red[0][j] == 1 || dp_blue[0][j] == 1) {
		res[j] = 1;
	    }
	    
	    if(dp_red[0][j] ==1 ) {
		q.add(new Node(j, 0));
	    }
	    if (dp_blue[0][j] == 1) {
		q.add(new Node(j, 1));
	    }
	}
	
	int cnt = 1;
	while (!q.isEmpty()) {
	    int loop = q.size();
	    for (int m = 0; m < loop; m++) {
		Node node = q.poll();
		if (res[node.pos] == -1) {
		    res[node.pos] = cnt;
		}
		if (node.color == 1) {
		    for (int j = 1; j < n; j++) {
			if (!red_visited[node.pos] && dp_red[node.pos][j] == 1) {
			    q.add(new Node(j, 0));
			}
		    }
		    red_visited[node.pos] = true;
		} else {
		    for (int j = 1; j < n; j++) {
			if (!blue_visited[node.pos] && dp_blue[node.pos][j] == 1) {
			    q.add(new Node(j, 1));
			}
		    }
		    blue_visited[node.pos] = true;
		}
	    }
	    cnt++;
	}
	return res;
    }

    private static class Node {
	private int pos;
	private int color;

	Node(int pos, int color) {
	    this.pos = pos;
	    this.color = color;
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] red_edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } };
	int[][] blue_edges = { { 1, 2 }, { 2, 3 }, { 3, 1 } };
	s.shortestAlternatingPaths(5, red_edges, blue_edges);
    }

}
