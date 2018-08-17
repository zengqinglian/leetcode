package findEventualSafeStates;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    // dfs recursion solution. no need set to store path. 20ms // beat 70%
    public List<Integer> eventualSafeNodes(int[][] graph) {
	int N = graph.length;
	int[] color = new int[N];
	List<Integer> ans = new ArrayList();

	for (int i = 0; i < N; ++i)
	    if (dfs(i, color, graph))
		ans.add(i);
	return ans;
    }

    // colors: WHITE 0, GRAY 1, BLACK 2;
    public boolean dfs(int node, int[] color, int[][] graph) {
	if (color[node] > 0)
	    return color[node] == 2;

	color[node] = 1;
	for (int nei : graph[node]) {
	    if (color[node] == 2)
		continue;
	    if (color[nei] == 1 || !dfs(nei, color, graph))
		return false;
	}

	color[node] = 2;
	return true;
    }
}
