package longestArithmeticSequence;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 345ms solution , beat 60%
    public int longestArithSeqLength(int[] A) {
	Map<Integer, Integer>[] maps = new Map[A.length];
	maps[0] = new HashMap<>();
	int max = 0;
	for (int i = 1; i < A.length; i++) {
	    maps[i] = new HashMap<>();
	    for (int j = 0; j < i; j++) {
		int diff = A[i] - A[j];
		Integer cnt = maps[j].get(diff);

		if (cnt == null) {
		    cnt = 2;
		} else {
		    cnt += 1;
		}
		maps[i].put(diff, Math.max(maps[i].getOrDefault(diff, 0), cnt));
		max = Math.max(max, cnt);
	    }

	}



	return max;
    }
}
