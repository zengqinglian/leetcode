package bestSightseeingPair;

public class Solution {
    // 3ms solution , beat 95%
    public int maxScoreSightseeingPair(int[] A) {
	int[] minusMax = new int[A.length];
	minusMax[A.length - 1] = A[A.length - 1] - (A.length - 1);
	for (int i = A.length - 2; i >= 0; i--) {
	    minusMax[i] = Math.max(minusMax[i + 1], A[i] - i);
	}
	int max = Integer.MIN_VALUE;
	for (int i = 0; i < A.length - 1; i++) {
	    max = Math.max(max, A[i] + i + minusMax[i + 1]);
	}

	return max;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 8, 1, 5, 2, 6 };
	s.maxScoreSightseeingPair(A);
    }
}
