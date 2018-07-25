package isGraphBipartite;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // 8ms solution - beat 20%
    public boolean isBipartite(int[][] graph) {

	boolean[] tracker = new boolean[graph.length];
	int idx = 0;

	while (idx < graph.length) {
	    if (tracker[idx] || graph[idx].length == 0) {
		tracker[idx] = true;
		idx++;
		continue;
	    }

	    boolean[] check1 = new boolean[graph.length];
	    boolean[] check2 = new boolean[graph.length];
	    Queue<QObject> q = new LinkedList<>();
	    int startIndex = idx;
	    for (int i = idx; i < graph.length; i++) {
		if (graph[i].length > 0) {
		    startIndex = i;
		    break;
		} else {
		    tracker[i] = true;
		}
	    }
	    check1[startIndex] = true;
	    tracker[startIndex] = true;
	    for (int i = 0; i < graph[startIndex].length; i++) {
		check2[graph[startIndex][i]] = true;
		q.add(new QObject(2, graph[startIndex][i]));
	    }

	    while (!q.isEmpty()) {
		QObject obj = q.poll();
		int index = obj.val;
		int s = obj.sourceId;
		if (!tracker[index]) {
		    if (graph[index].length > 0) {
			for (int i : graph[index]) {
			    if (s == 1) {
				q.add(new QObject(2, i));
			         check2[i] = true;
			    }
			    else {
				q.add(new QObject(1, i));
				check1[i] = true;
			    }

			    if (check1[i] && check2[i]) {
				return false;
			    }
			}
		    }
		}
		tracker[index] = true;
	    }
	}
	return true;

    }

    private static class QObject {
	private int sourceId;
	private int val;

	public QObject(int sourceId, int val) {
	    this.sourceId = sourceId;
	    this.val = val;
	}

    }
}
