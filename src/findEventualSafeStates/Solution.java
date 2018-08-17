package findEventualSafeStates;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Stack;

public class Solution {
    // time over limit solution -- failed on 91/111
    public List<Integer> eventualSafeNodes(int[][] graph) {
	int[] circle = new int[graph.length];
	for (int i = 0; i < graph.length; i++) {
	    if (circle[i] != 0) {
		continue;
	    }
	    Stack<LinkedHashSet<Integer>> stack = new Stack<>();
	    LinkedHashSet<Integer> set = new LinkedHashSet<>();
	    set.add(i);
	    stack.add(set);

	    while (!stack.isEmpty()) {
		LinkedHashSet<Integer> cur = stack.pop();
		int index = (int) cur.toArray()[cur.size() - 1];
		int[] nextPoints = graph[index];
		if (nextPoints.length == 0) {
		    // no circle
		    for (int num : cur) {
			if (circle[num] == 0)
			    circle[num] = 1;
		    }
		} else {
		    for (int n : nextPoints) {
			if (cur.contains(n) || circle[n] == -1) {
			    if (cur.contains(n)) {
				for (int num : cur) {
				    circle[num] = -1;
				    if (num == n) {
					break;
				    }
				}
			    }
			    if (circle[n] == -1) {
				for (int num : cur) {
				    circle[num] = -1;
				}
			    }
			} else {
			    LinkedHashSet<Integer> next = new LinkedHashSet<Integer>(cur);
			    next.add(n);
			    stack.push(next);
			}
		    }
		}

	    }

	}
	List<Integer> result = new ArrayList<>();
	for (int i = 0; i < circle.length; i++) {
	    if (circle[i] == 1) {
		result.add(i);
	    }
	}
	return result;
    }

    public static void main(String[] args) {
	Solution s= new Solution();
	int[][] graph = {{1,2},{2,3},{5},{0},{5},{},{}};
	s.eventualSafeNodes(graph);
    }
}
