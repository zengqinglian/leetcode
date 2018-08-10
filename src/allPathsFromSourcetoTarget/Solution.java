package allPathsFromSourcetoTarget;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    // bfs 11 ms solution beat 20%
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
	Queue<ArrayList<Integer>> q = new LinkedList<>();
	List<List<Integer>> result = new ArrayList<>();
	ArrayList<Integer> list = new ArrayList<>();
	list.add(0);
	q.add(list);
	
	while (!q.isEmpty()) {
	    ArrayList<Integer> li = q.poll();
	    int index = li.get(li.size()-1);
	    for (int i : graph[index]) {
		ArrayList<Integer> newList = (ArrayList) li.clone();
		newList.add(i);
		if (i == graph.length - 1) {
		    result.add(newList);
		} else {
		    q.add(newList);
		}
	    }
	}

	return result;
    }


}
