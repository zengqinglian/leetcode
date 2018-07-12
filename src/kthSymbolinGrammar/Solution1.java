package kthSymbolinGrammar;

import java.util.BitSet;

public class Solution1 {
    // over time limit
    public int kthGrammar(int N, int K) {
	if (K == 1) {
	    return 0;
	}

	BitSet dp = new BitSet((int) Math.pow(2, N - 1) + 1);

	dp.set(2);

	int start = 2;
	int newIndex = 3;

	while (newIndex <= K) {
	    int loopEnd = newIndex;
	    int loopStart = start;
	    for (int i = loopStart; i < loopEnd; i++) {
		if (dp.get(i)) {
		    dp.set(newIndex);
		} else {
		    dp.set(newIndex + 1);
		}
		newIndex += 2;
		start++;
		if (newIndex > K) {
		    break;
		}
	    }

	}

	if (dp.get(K)) {
	    return 1;
	} else {
	    return 0;
	}

    }
}
