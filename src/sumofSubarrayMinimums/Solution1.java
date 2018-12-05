package sumofSubarrayMinimums;

public class Solution1 {
    //440ms solution beat only 5%
    public int sumSubarrayMins(int[] A) {
	int MOD = 1_000_000_007;
	int tempSum = A[0];
	int total = A[0];

	for (int i = 1; i < A.length; i++) {
	    if (A[i] >= A[i - 1]) {
		tempSum += A[i];
		total = (total + tempSum) % MOD;
	    } else {
		tempSum = getTempSum(tempSum, A, i);
		total = (total + tempSum) % MOD;
	    }
	}

	return total;

    }

    private int getTempSum(int tempSum, int[] A, int idx) {
	tempSum += A[idx];
	int min = Integer.MAX_VALUE;
	for (int i = idx - 1; i >= 0; i--) {
	    if (A[i] < A[idx]) {
		break;
	    } else {
		min = Math.min(A[i], min);
		tempSum -= (min - A[idx]);
	    }
	}
	return tempSum;
    }
}
