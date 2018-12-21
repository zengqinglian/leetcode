package maximumSumCircularSubarray;

public class Solution {
    // over time limit solution O(NxN)
    public int maxSubarraySumCircular(int[] A) {
	int max = Integer.MIN_VALUE;
	for (int i = 0; i < A.length; i++) {
	    max = Math.max(max, getMax(A, i));
	}
	return max;
    }

    private int getMax(int[] A, int startIndex) {
	if (A[startIndex] <= 0) {
	    return A[startIndex];
	}

	int[] dp = new int[A.length];

	int max = Integer.MIN_VALUE;

	dp[startIndex] = A[startIndex];
	max = Math.max(dp[startIndex], max);
	for (int i = 1; i < A.length; i++) {
	    int trueIndex = i + startIndex > A.length - 1 ? i + startIndex - A.length : i + startIndex;
	    int idx = (trueIndex == 0 ? A.length - 1 : trueIndex - 1);
	    dp[trueIndex] = Math.max(A[trueIndex], A[trueIndex] + dp[idx]);
	    max = Math.max(dp[trueIndex], max);
	}
	
	return max;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { -5, 4, -6 };
	s.maxSubarraySumCircular(A);

    }
}
