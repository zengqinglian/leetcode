package imageOverlap;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 35ms Solution beat 60%
    public int largestOverlap(int[][] A, int[][] B) {
	List<int[]> aList = new ArrayList<>();
	List<int[]> bList = new ArrayList<>();

	for (int i = 0; i < A.length; i++) {
	    for (int j = 0; j < A.length; j++) {
		if (A[i][j] == 1) {
		    int[] p = { i, j };
		    aList.add(p);
		}

		if (B[i][j] == 1) {
		    int[] p = { i, j };
		    bList.add(p);
		}
	    }
	}
	int max = 0;
	int[][] loopArr;
	List<int[]> loopList;

	if (aList.size() <= bList.size()) {
	    loopList = aList;
	    loopArr = B;
	} else {
	    loopList = bList;
	    loopArr = A;
	}

	for (int i = 0; i < A.length; i++) {
	    for (int j = 0; j < A.length; j++) {
		int val1 = 0;
		int val2 = 0;
		for (int[] p : loopList) {

		    if (p[0] + i < A.length && p[1] + j < A.length && loopArr[p[0] + i][p[1] + j] == 1) {
			val1++;
		    }
		    if (p[0] - i >= 0 && p[1] - j >= 0 && loopArr[p[0] - i][p[1] - j] == 1) {
			val2++;
		    }

		}
		max = Math.max(max, val1);
		max = Math.max(max, val2);
	    }
	}

	return max;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] A = { { 0, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 1 } };
	int[][] B = { { 1, 0, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1 }, { 1, 0, 1, 1, 1 } };
	s.largestOverlap(A, B);
    }
}
