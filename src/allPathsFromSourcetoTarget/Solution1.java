package allPathsFromSourcetoTarget;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    // dfs recursive , 5ms solution beat 60%
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
	ArrayList<Integer> list = new ArrayList<>();
	List<List<Integer>> result = new ArrayList<>();
	list.add(0);
	getPath(list, result, graph);
	return result;
    }

    private void getPath(ArrayList<Integer> list, List<List<Integer>> result, int[][] graph) {
	int index = list.get(list.size() - 1);
	for (int i : graph[index]) {
	    list.add(i);
	    if (i == graph.length - 1) {
		result.add((ArrayList) list.clone());
	    } else {
		getPath(list, result, graph);
	    }
	    list.remove(list.size() - 1);
	}
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	int[][] graph = { { 1, 2 }, { 3 }, { 3 }, {} };
	s.allPathsSourceTarget(graph);
    }
}
