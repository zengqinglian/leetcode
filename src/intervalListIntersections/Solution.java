package intervalListIntersections;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    // 3ms solution beat 80%
    public int[][] intervalIntersection(int[][] A, int[][] B) {
	int a = 0;
	int b = 0;
	List<int[]> res = new LinkedList<>();
	while (a < A.length && b < B.length) {
	    int[] elementA = A[a];
	    int[] elementB = B[b];

	    if (elementA[1] < elementB[0]) {
		a++;
	    } else if (elementB[1] < elementA[0]) {
		b++;
	    } else {
		if (elementA[1] >= elementB[0] && elementA[1] <= elementB[1]) {
		    int[] overLap = new int[2];
		    overLap[0] = Math.max(elementA[0], elementB[0]);
		    overLap[1] = elementA[1];
		    a++;
		    res.add(overLap);
		} else if (elementB[1] >= elementA[0] && elementB[1] <= elementA[1]) {
		    int[] overLap = new int[2];
		    overLap[0] = Math.max(elementA[0], elementB[0]);
		    overLap[1] = elementB[1];
		    b++;
		    res.add(overLap);
		}
	    }
	}

	int[][] resArr = new int[res.size()][];
	res.toArray(resArr);

	return resArr;
    }

    private static class Interval {
	int start;
	int end;

	Interval() {
	    start = 0;
	    end = 0;
	}

	Interval(int s, int e) {
	    start = s;
	    end = e;
	}

	@Override
	public String toString() {
	    return "Interval [start=" + start + ", end=" + end + "]";
	}

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] A_arr = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
	int[][] B_arr = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
	Interval[] A = convert(A_arr);
	Interval[] B = convert(B_arr);
	s.intervalIntersection(A_arr, B_arr);
    }

    private static Interval[] convert(int[][] a_arr) {
	Interval[] res = new Interval[a_arr.length];
	int idx = 0;
	for (int[] v : a_arr) {
	    Interval i = new Interval();
	    i.start = v[0];
	    i.end = v[1];
	    res[idx++] = i;
	}
	return res;
    }

}
