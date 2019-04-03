package numbersWithSameConsecutiveDifferences;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    // 38ms solution , beat 25%
    public int[] numsSameConsecDiff(int N, int K) {

	if (N == 1) {
	    int[] digits = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	    return digits;
	}
	
	List<Integer> result = new ArrayList<>();
	for (int i = 1; i <= 9; i++) {
	    Queue<Integer> q = new LinkedList<>();
	    q.add(i);
	    generateNumber(q, N, K, result, 1);
	}

	int[] res = result.stream().mapToInt(i -> i).toArray();

	return res;

    }

    private void generateNumber(Queue<Integer> q, int N, int K, List<Integer> result, int n) {
	if (n == N) {
	    while (!q.isEmpty()) {
		result.add(q.poll());
	    }
	    return;
	}

	int len = q.size();
	for (int i = 0; i < len; i++) {
	    int val = q.poll();
	    int lastD = val % 10;
	    if (lastD + K >= 0 && lastD + K <= 9) {
		int newVal = val * 10 + (lastD + K);
		q.add(newVal);
	    }
	    if (lastD - K >= 0 && lastD - K <= 9 && K != 0) {
		int newVal = val * 10 + (lastD - K);
		q.add(newVal);
	    }
	}

	generateNumber(q, N, K, result, n + 1);

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.numsSameConsecDiff(9, 3);
    }
}
