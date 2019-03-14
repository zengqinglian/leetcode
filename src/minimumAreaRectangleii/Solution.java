package minimumAreaRectangleii;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    double area = 0;

    // 110ms solution beat 20%
    public double minAreaFreeRect(int[][] points) {
	if(points.length <4) {
	    return 0;
	}
	
	Map<Integer, Set<Integer>> mapX = new HashMap<>();
	Map<Integer, Set<Integer>> mapY = new HashMap<>();
	for (int[] p : points) {
	    Set<Integer> setX = mapX.get(p[0]);
	    if (setX == null) {
		setX = new HashSet<>();
		mapX.put(p[0], setX);
	    }
	    setX.add(p[1]);

	    Set<Integer> setY = mapY.get(p[1]);
	    if (setY == null) {
		setY = new HashSet<>();
		mapY.put(p[1], setY);
	    }
	    setY.add(p[0]);
	}
	
	double res = Double.MAX_VALUE;

	for (int i = 0; i < points.length; i++) {
	    for (int j = i + 1; j < points.length; j++) {
		int[] A = points[i];
		int[] B = points[j];

		int diffX = Math.abs(A[0] - B[0]);
		int diffY = Math.abs(A[1] - B[1]);
		
		if (diffX == 0) {
		    for (int key : mapX.keySet()) {
			if(key == A[0]) {
			    continue;
			}
			Set<Integer> Ys = mapX.get(key);
			for (int y : Ys) {
			    if (Ys.contains(y + diffY) && y == Math.min(B[1], A[1])) {
				res = Math.min(res, diffY * Math.abs(key - A[0]));
			    }
			}
		    }
		} else {
		    for (int key : mapX.keySet()) {
			if (mapX.containsKey(key + diffX)) {
			    for (int cY : mapX.get(key)) {
				for (int dY : mapX.get(key + diffX)) {
				    if ((key != A[0] || cY != A[1]) && (key != B[0] || cY != B[1])
					    && (key + diffX != A[0] || dY != A[1])
					    && (key + diffX != B[0] || dY != B[1])
					    && Math.abs(cY - dY) == diffY) {

					int[] C = { key, cY };
					int[] D = { key + diffX, dY };
					if (isRec(A, B, C) && isRec(B, A, D)) {
					    res = Math.min(res, area);
					}
				    }
				}
			    }
			}
		    }
		}
	    }
	}

	return res == Double.MAX_VALUE ? 0 : res;

    }

    private boolean isRec(int[] a, int[] b, int[] c) {
	double A = Math.pow(Math.abs(a[0] - b[0]), 2) + Math.pow(Math.abs(a[1] - b[1]), 2);
	double B = Math.pow(Math.abs(a[0] - c[0]), 2) + Math.pow(Math.abs(a[1] - c[1]), 2);
	double C = Math.pow(Math.abs(c[0] - b[0]), 2) + Math.pow(Math.abs(c[1] - b[1]), 2);

	if (C > B && C > A) {
	    if (A + B == C) {
		area = Math.sqrt(A) * Math.sqrt(B);
		return true;
	    } else {
		return false;
	    }
	}

	if (A > B && A > C) {
	    if (A == B + C) {
		area = Math.sqrt(B) * Math.sqrt(C);
		return true;
	    } else {
		return false;
	    }
	}

	if (B > A && B > C) {
	    if (B == A + C) {
		area = Math.sqrt(A) * Math.sqrt(C);
		return true;
	    } else {
		return false;
	    }
	}


	return false;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	// int[][] points = { { 2, 1 }, { 0, 0 }, { 0, 3 }, { 1, 3 }, { 3, 2 }, { 1, 0
	// }, { 2, 3 }, { 0, 2 } };
	int[][] points = { { 39, 7 }, { 36, 36 }, { 27, 4 }, { 16, 51 }, { 36, 19 }, { 24, 16 }, { 4, 35 },
		{ 24, 20 } };
	s.minAreaFreeRect(points);
    }
}
