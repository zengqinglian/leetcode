package largestSumofAverages;

public class Solution {
    //over time limit solution . 
    public double largestSumOfAverages(int[] A, int K) {
	int sum = 0;
	double max = 0;
	if (K == 1) {
	    for (int i = 0; i <= A.length - K; i++) {
		sum += A[i];

	    }
	    return sum * 1.0 / (A.length);
	}
	for (int i = 0; i <= A.length - K; i++) {
	    sum += A[i];
	    max = Math.max(max, sum * 1.0 / (i + 1) + getTotal(A, K - 1, i + 1));
	}
	return max;
    }

    private double getTotal(int[] A, int K, int i) {
	if (K == 1) {
	    int sum = 0;
	    for (int j = i; j < A.length; j++) {
		sum += A[j];
	    }
	    return sum * 1.0 / (A.length - i);
	} else if (K == A.length - i) {
	    int sum = 0;
	    for (int j = i; j < A.length; j++) {
		sum += A[j];
	    }
	    return sum;
	} else {
	    int sum = 0;
	    double max = 0;
	    for (int j = i; j <= A.length - K; j++) {
		sum += A[j];
		max = Math.max(max, sum * 1.0 / (j - i + 1) + getTotal(A, K - 1, j + 1));
	    }
	    return max;
	}

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 9, 1, 9, 2, 3 };
	s.largestSumOfAverages(A, 2);
    }

}
