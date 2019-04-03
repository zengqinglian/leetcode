package numbersWithSameConsecutiveDifferences;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    // recursion solution, 38ms . beat 25%
    public int[] numsSameConsecDiff(int N, int K) {
	if (N == 1) {
	    int[] digits = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	    return digits;
	}

	List<Integer> result = new ArrayList<>();
	for (int i = 1; i <= 9; i++) {
	    generateNumber(i, N, K, result, 1);
	}

	int[] res = result.stream().mapToInt(i -> i).toArray();

	return res;
    }

    private void generateNumber(int i, int N, int K, List<Integer> result, int n) {
	if (N == n) {
	    result.add(i);
	    return;
	}
	
	int lastD = i % 10;
	if (lastD + K >= 0 && lastD + K <= 9) {
	    int newVal = i * 10 + (lastD + K);
	    generateNumber(newVal, N, K, result, n + 1);
	}

	if (lastD - K >= 0 && lastD - K <= 9 && K != 0) {
	    int newVal = i * 10 + (lastD - K);
	    generateNumber(newVal, N, K, result, n + 1);
	}

    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	s.numsSameConsecDiff(9, 3);
    }
}
