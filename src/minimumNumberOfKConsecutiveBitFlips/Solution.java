package minimumNumberOfKConsecutiveBitFlips;

public class Solution {
    // 58s solution , beat 15%
    public int minKBitFlips(int[] A, int K) {
	int flip = 0;
	for (int i = 0; i < A.length; i++) {
	    if (A[i] == 0) {
		if (i + K - 1 <= A.length - 1) {
		    for (int j = i; j < i + K; j++) {
			if (A[j] == 0) {
			    A[j] = 1;
			} else {
			    A[j] = 0;
			}

		    }
		    flip++;
		} else {
		    return -1;
		}
	    }
	}
	return flip;
    }
}
