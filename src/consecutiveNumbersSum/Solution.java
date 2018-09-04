package consecutiveNumbersSum;

public class Solution {
    // over time limit solution
    public int consecutiveNumbersSum(int N) {
	if (N == 1) {
	    return 1;
	}
	int result = 1;
	if (N % 2 == 1) {
	    result = 2;
	}
	for (long i = 1; i < N / 3; i++) {
	    double x = Math.sqrt(2 * N + i * i - i + 0.25) - 0.5;
	    if (x == Math.floor(x) && !Double.isInfinite(x)) {
		result++;
	    }
	}
	return result;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.consecutiveNumbersSum(72316829);
    }
}
