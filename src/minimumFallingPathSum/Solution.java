package minimumFallingPathSum;

import java.util.Arrays;

public class Solution {
    // 8ms solution meet avg speed. beat 50%
    public int minFallingPathSum(int[][] A) {
	int res = Integer.MAX_VALUE;
	if (A.length == 1) {
	    for (int i = 0; i < A[0].length; i++) {
		res = Math.min(res, A[0][i]);
	    }
	    return res;
	}

	int[][] sum = new int[A.length][A[0].length];
	
	for (int i = 1; i < A.length; i++) {
	    Arrays.fill(sum[i], Integer.MAX_VALUE);
	}
	
	int[] shift = { -1, 0, 1 };
	for (int i = 0; i < A.length - 1; i++) {
	    for(int j=0; j<A.length; j++) {
		for (int s : shift) {
		    int newCol = j + s;
		    if (newCol >= 0 && newCol < A.length) {
			if (i == 0) {
			    sum[i + 1][newCol] = Math.min(sum[i + 1][newCol], A[i][j] + A[i + 1][newCol]);
			} else {
			    sum[i + 1][newCol] = Math.min(sum[i + 1][newCol], sum[i][j] + A[i + 1][newCol]);
			}
			if (i == A.length - 2) {
			    res = Math.min(res, sum[i + 1][newCol]);
			}
		    }
		}

	    }
	}
	return res;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] A = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
	s.minFallingPathSum(A);
    }
}
