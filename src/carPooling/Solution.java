package carPooling;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    // 23ms solution , beat 23%
    public boolean carPooling(int[][] trips, int capacity) {
	PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
	    return a[2]-b[2];
	});
	Arrays.sort(trips, (a, b) -> {
	    return a[1] - b[1];
	});

	for (int[] p : trips) {
	    while (!q.isEmpty() && q.peek()[2] <= p[1]) {
		int[] pos = q.poll();
		capacity += pos[0];
	    }
	    capacity -= p[0];
	    if (capacity < 0) {
		return false;
	    }
	    q.add(p);
	}

	return true;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] trips = { { 9, 3, 4 }, { 9, 1, 7 }, { 4, 2, 4 }, { 7, 4, 5 } };
	s.carPooling(trips, 23);
    }
}
