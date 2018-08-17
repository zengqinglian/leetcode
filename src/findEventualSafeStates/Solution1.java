package findEventualSafeStates;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Solution1 {
    // recursive 60ms solution . beat 30%
    public List<Integer> eventualSafeNodes(int[][] graph) {
	int[] circle = new int[graph.length];
	for (int i = 0; i < graph.length; i++) {
	    if (circle[i] != 0) {
		continue;
	    }
	    HashSet<Integer> set = new HashSet<>();
	    set.add(i);
	    checkRoute(graph, i, circle, set);
	}
	
	List<Integer> result = new ArrayList<>();
	for (int i = 0; i < circle.length; i++) {
	    if (circle[i] == 1) {
		result.add(i);
	    }
	}
	return result;
    }

    private void checkRoute(int[][] graph, int i, int[] circle, HashSet<Integer> set) {
	int[] nextPoints = graph[i];
	if (nextPoints.length == 0) {
	    for (int num : set) {
		if (circle[num] == 0)
		    circle[num] = 1;
	    }
	    return;
	}
	boolean valid = true;
	for (int n : nextPoints) {
	    if (circle[n] == -1 || set.contains(n)) {
		valid = false;
	    }
	}
	if (!valid) {
	    for (int num : set) {
		circle[num] = -1;
	    }

	} else {
	    for (int n : nextPoints) {
		if (circle[n] != 1) {
		    set.add(n);
		    checkRoute(graph, n, circle, set);
		    set.remove(n);
		} else {
		    for (int num : set) {
			if (circle[num] == 0)
			    circle[num] = 1;
		    }
		}
	    }
	}


    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
	s.eventualSafeNodes(graph);
    }
}
