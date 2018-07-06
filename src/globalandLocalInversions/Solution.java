package globalandLocalInversions;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // time limit over solution
    public boolean isIdealPermutation(int[] A) {
	Set<Integer> set = new HashSet<>();
	for (int i = 0; i < A.length - 1; i++) {
	    if (A[i] > A[i + 1]) {
		for (int j = 0; j < A[i]; j++) {
		    if (j != A[i + 1]) {
			if (!set.contains(j)) {
			    return false;
			}
		    }
		}
		set.add(A[i]);
	    } else {
		for (int j = 0; j < A[i]; j++) {
		    if (j != A[i + 1]) {
			if (!set.contains(j)) {
			    return false;
			}
		    }
		}
		set.add(A[i]);
	    }
	}
	return true;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 1, 2, 0 };
	s.isIdealPermutation(A);
    }
}
