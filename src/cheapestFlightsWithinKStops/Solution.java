package cheapestFlightsWithinKStops;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Solution {
    // 10ms solution - beat 70%
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
	int min = Integer.MAX_VALUE;
	boolean find = false;
	if (K == 0) {
	    for (int[] flight : flights) {
		if(flight[0] == src && flight[1]==dst) {
		    min = Math.min(min, flight[2]);
		    find = true;
		}
	    }
	    if (!find) {
		return -1;
	    }
	    return min;
	}
	// group
	Map<Integer, List<int[]>> groupSrc = new HashMap<>();
	int step = 0;
	for (int[] flight : flights) {
	    if (groupSrc.containsKey(flight[0])) {
		groupSrc.get(flight[0]).add(flight);
	    } else {
		List<int[]> li = new ArrayList<>();
		li.add(flight);
		groupSrc.put(flight[0], li);
	    }
	}
	
	Queue<int[]> q = new LinkedList<>();
	int[] init = new int[2];
	init[0] = src;
	init[1] = 0;
	q.add(init);

	while (step <= K && !q.isEmpty()) {
	    for(int i=0; i<q.size(); i++) {
		int[] cur = q.poll();
		List<int[]> points = groupSrc.get(cur[0]);
		if (points != null) {
		    for (int[] point : points) {
			if (point[1] == dst) {
			    find = true;
			    min = Math.min(min, point[2] + cur[1]);
			} else {
			    if (cur[1] + point[2] < min) {
				int[] newPos = new int[2];
				newPos[0] = point[1];
				newPos[1] = cur[1] + point[2];
				q.offer(newPos);
			    }
			}
		    }
		}
	    }
	    
	    step++;
	}

	if (find) {
	    return min;
	}
	return -1;

    }

    public static void main(String[] args) {
	int[][] flights = { { 3, 4, 4 }, { 2, 5, 6 }, { 4, 7, 10 }, { 9, 6, 5 }, { 7, 4, 4 }, { 6, 2, 10 }, { 6, 8, 6 },
		{ 7, 9, 4 }, { 1, 5, 4 }, { 1, 0, 4 }, { 9, 7, 3 }, { 7, 0, 5 }, { 6, 5, 8 }, { 1, 7, 6 }, { 4, 0, 9 },
		{ 5, 9, 1 }, { 8, 7, 3 }, { 1, 2, 6 }, { 4, 1, 5 }, { 5, 2, 4 }, { 1, 9, 1 }, { 7, 8, 10 }, { 0, 4, 2 },
		{ 7, 2, 8 } };
	Solution s = new Solution();
	s.findCheapestPrice(10, flights, 6, 0, 7);
    }
}
