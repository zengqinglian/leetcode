package largestSumofAverages;

public class Solution1 {
    // 9ms dp solution beat 70%
    public double largestSumOfAverages(int[] A, int K) {
	double[][] arr = new double[A.length][K + 1];
	if (A.length == K || K == 1) {
	    double sum = 0.0;
	    for (int i : A) {
		sum += i;
	    }
	    if (A.length == K) {
		return sum;
	    } else {
		return sum / A.length;
	    }
	}

	arr[0][1] = A[0];

	for (int i = 1; i < A.length; i++) {
	    arr[i][1] = (arr[i - 1][1] * i + A[i]) / (i + 1);
	    int sum = 0;
	    int left = A.length - i;
	    for (int j = i - 1; j >= 0; j--) {
		sum += A[j + 1];
		for (int n = Math.max(1, K - left); n < Math.min(j + 2, K); n++) {
		    if (arr[j][n] > 0) {
			arr[i][n + 1] = Math.max(arr[i][n + 1], arr[j][n] + sum * 1.0 / (i - j));
		    }
		}
	    }
	}
	
	return arr[A.length - 1][K];

    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	int[] A = { 9, 1, 9, 2, 3 };
	s.largestSumOfAverages(A, 3);
    }

}
