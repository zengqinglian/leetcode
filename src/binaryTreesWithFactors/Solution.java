package binaryTreesWithFactors;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 60ms solution beat 30%
    public int numFactoredBinaryTrees(int[] A) {
	Arrays.sort(A);
	Map<Integer, Long> resultMap = new HashMap<>(A.length);
	int max = 0;
	for (int i : A) {
	    resultMap.put(i, 1L);
	    max = Math.max(max, i);
	}

	for (int i = 0; i < A.length; i++) {
	    for (int j = 0; j <= i; j++) {
		long total = (long) A[i] * (long) A[j];
		if (total <= max && resultMap.containsKey((int) total)) {
		    long newvalue = resultMap.get(A[i]) * resultMap.get(A[j]);
		    if (i != j) {
			newvalue = newvalue * 2;
		    }
		    newvalue = (resultMap.get((int) total) + newvalue) % 1_000_000_007;
		    resultMap.put((int) total,newvalue);
		}
	    }
	}
	
	long result = 0;
	for (long v : resultMap.values()) {
	    result += v;
	}
	return (int) (result % 1_000_000_007L);
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28,
		29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 60, 70, 74, 80, 92,
		96, 99 };
	s.numFactoredBinaryTrees(A);
    }
}
