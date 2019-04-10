package kClosestPointsToOrigin;

import java.util.PriorityQueue;

public class Solution {
    // 32ms solution meet avg speed. beat 50%
    public int[][] kClosest(int[][] points, int K) {
	int[][] result = new int[K][2];
	PriorityQueue<Node> q = new PriorityQueue<>();

	for (int[] point : points) {
	    Node node = new Node(point);
	    if (q.size() < K) {
		q.add(node);
	    } else {
		Node topNode = q.peek();
		if (topNode.dis > node.dis) {
		    q.poll();
		    q.add(node);
		}
	    }
	}

	for (int i = K - 1; i >= 0; i--) {
	    result[i] = q.poll().p;
	}

	return result;
    }

    private class Node implements Comparable<Node> {
	private int[] p;
	private int dis;

	Node(int[] p) {
	    this.p = p;
	    dis = p[0] * p[0] + p[1] * p[1];
	}

	@Override
	public int compareTo(Node o) {
	    return Integer.compare(o.dis, this.dis);
	}

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] points = { { 1, 3 }, { -2, 2 } };
	s.kClosest(points, 1);
    }
}
