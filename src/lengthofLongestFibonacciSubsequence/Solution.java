package lengthofLongestFibonacciSubsequence;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // 60ms solution beat 60%
    public int lenLongestFibSubseq(int[] A) {
	// newSum, preNumber, length
	Set<Integer> set = new HashSet<>();
	for (int i = 1; i < A.length; i++) {
	    set.add(A[i]);
	}
	int max = 0;
	int lastA = A[A.length-1];
	for (int i = 1; i < A.length - 1; i++) {
	    for(int j=0; j<i; j++) {
		int sum = A[j]+ A[i];
		if (sum < lastA) {
		    max = Math.max(max, getLength(sum, set, A[i], 2, lastA));
		}
		if (sum == lastA) {
		    max = Math.max(max, 3);
		}
	    }
	}
	return max >= 3 ? max : 0;
    }

    private int getLength(int sum, Set<Integer> set, int pre, int len, int max) {
	if (set.contains(sum)) {
	    len++;
	    int newsum = pre + sum;
	    if (newsum <= max) {
		int newpre = sum;
		return getLength(newsum, set, newpre, len, max);
	    } else {
		return len;
	    }
	} else {
	    return len;
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int A[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };
	s.lenLongestFibSubseq(A);
    }
}
