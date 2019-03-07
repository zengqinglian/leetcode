package minimumIncrementtoMakeArrayUnique;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    // 35ms solution , beat 50%
    public int minIncrementForUnique(int[] A) {
	if (A.length <= 1) {
	    return 0;
	}

	Arrays.sort(A);
	Set<Integer> unique = new HashSet<>();
	int start = A[0];
	int next = A[0]+1;
	unique.add(A[0]);
	int step = 0;
	for (int i = 1; i < A.length; i++) {
	    if (unique.contains(A[i])) {
		step += (next - A[i]);
		unique.add(next);
		next++;
	    } else {
		unique.add(A[i]);
		next = A[i] + 1;
	    }
	}

	return step;

    }
}
