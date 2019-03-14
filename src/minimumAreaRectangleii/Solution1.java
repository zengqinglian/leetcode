package minimumAreaRectangleii;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
    // improved solution , 27 ms beat 90%
    double area = 0;
    public double minAreaFreeRect(int[][] points) {
	if(points.length <4) {
	    return 0;
	}
	Map<Integer, List<Node>> map = new HashMap<>();

	for (int i = 0; i < points.length; i++) {
	    for (int j = i + 1; j < points.length; j++) {
		int diffX = Math.abs(points[i][0] - points[j][0]);
		List<Node> list = map.get(diffX);
		if (list == null) {
		    list = new ArrayList<>();
		    map.put(diffX, list);
		}
		int idx1 = 0;
		int idx2 = 0;
		if (points[i][0] >= points[j][0]) {
		    idx1 = i;
		    idx2 = j;
		} else {
		    idx1 = j;
		    idx2 = i;
		}
		list.add(new Node(idx1, idx2));
	    }
	}

	double res = Double.MAX_VALUE;

	for (int key : map.keySet()) {
	    List<Node> list = map.get(key);
	    if (list.size() >= 2) {
		for (int i = 0; i < list.size(); i++) {
		    for (int j = i + 1; j < list.size(); j++) {
			Node n1 = list.get(i);
			Node n2 = list.get(j);

			if (n1.idx1 != n2.idx1 && n1.idx2 != n2.idx2) {
			    int[] A = points[n1.idx1];
			    int[] B = points[n1.idx2];
			    int[] C = points[n2.idx1];
			    int[] D = points[n2.idx2];

			    if (isRec(A, B, C, D)) {
				res = Math.min(res, area);
			    }
			}

		    }

		}
	    }
	}

	return res == Double.MAX_VALUE ? 0 : res;
    }

    private boolean isRec(int[] a, int[] b, int[] c, int[] d) {
	double AB = Math.pow(Math.abs(a[0] - b[0]), 2) + Math.pow(Math.abs(a[1] - b[1]), 2);
	double AC = Math.pow(Math.abs(a[0] - c[0]), 2) + Math.pow(Math.abs(a[1] - c[1]), 2);
	double BC = Math.pow(Math.abs(c[0] - b[0]), 2) + Math.pow(Math.abs(c[1] - b[1]), 2);

	if (a[1] - b[1] == c[1] - d[1] && AB + AC == BC) {
	    area = Math.sqrt(AB) * Math.sqrt(AC);
	    return true;
	}

	return false;

    }

    private static class Node {
	private int idx1;
	private int idx2;

	Node(int idx1, int idx2) {
	    this.idx1 = idx1;
	    this.idx2 = idx2;
	}

    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	// int[][] points = { { 2, 1 }, { 0, 0 }, { 0, 3 }, { 1, 3 }, { 3, 2 }, { 1, 0
	// }, { 2, 3 }, { 0, 2 } };
	int[][] points = { { 1, 2 }, { 2, 1 }, { 1, 0 }, { 0, 1 } };
	s.minAreaFreeRect(points);
    }
}
