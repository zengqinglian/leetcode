package smallestRangeII;

import java.util.Arrays;

public class Solution {
    // 20ms solution, meet avg speed.
    public int smallestRangeII(int[] A, int K) {
	int N = A.length;
	Arrays.sort(A);
	int ans = A[N - 1] - A[0];

	for (int i = 0; i < A.length - 1; ++i) {
	    int a = A[i], b = A[i + 1];
	    int high = Math.max(A[N - 1] - K, a + K);
	    int low = Math.min(A[0] + K, b - K);
	    ans = Math.min(ans, high - low);
	}
	return ans;
    }

    public static void main(String[] args) {
	int[] A = { 4, 1, 8, 10 };
	Solution s = new Solution();
	s.smallestRangeII(A, 3);
    }
}
