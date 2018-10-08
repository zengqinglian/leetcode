package scoreAfterFlippingMatrix;

public class Solution {
    // 5ms solution - meet avg speed.
    public int matrixScore(int[][] A) {
	// check row make
	for (int i = 0; i < A.length; i++) {
	    if(A[i][0] == 0) {
		for (int j = 0; j < A[0].length; j++) {
		    if (A[i][j] == 0) {
			A[i][j] = 1;
		    } else {
			A[i][j] = 0;
		    }
		}
	    }
	}

	for (int i = 1; i < A[0].length; i++) {
	    int count = 0;
	    for (int j = 0; j < A.length; j++) {
		if (A[j][i] == 0) {
		    count++;
		}
	    }
	    if (count > A.length - count) {
		for (int j = 0; j < A.length; j++) {
		    if (A[j][i] == 0) {
			A[j][i] = 1;
		    } else {
			A[j][i] = 0;
		    }
		}
	    }
	}
	
	int total = 0;
	for (int i = 0; i < A.length; i++) {
	    int num = 0;
	    for (int j = 0; j < A[0].length; j++) {
		if (A[i][j] == 1) {
		    num += (Math.pow(2, A[0].length - j - 1));
		}
	    }

	    total += num;
	}

	return total;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[][] A = { { 0, 0, 1, 1 }, { 1, 0, 1, 0 }, { 1, 1, 0, 0 }, { 1, 0, 0, 1 } };
	s.matrixScore(A);
    }
}
