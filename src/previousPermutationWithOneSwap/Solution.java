package previousPermutationWithOneSwap;

import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {
    // 33ms solution , beat 5%
    public int[] prevPermOpt1(int[] A) {
	TreeSet<Integer> set = new TreeSet<>((a,b) -> {
	    if(Integer.compare(A[a], A[b])!=0)
		return Integer.compare(A[a], A[b]);
	    else 
		return Integer.compare(a, b);
	});

	for (int i = A.length - 1; i >= 0; i--) {
	    if (set.isEmpty()) {
		set.add(i);
	    }else {
		set.add(i);
		SortedSet<Integer> sorted = set.headSet(i);
		if (!sorted.isEmpty()) {
		    int idx = -1;
		    for (int index : sorted) {
			if (idx == -1) {
			    idx = index;
			} else if (A[idx] != A[index]) {
			    idx = index;
			}
		    }
		    int temp = A[idx];
		    A[idx] = A[i];
		    A[i] = temp;
		    return A;
		}
	    }
	}
	return A;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 3, 1, 1, 3 };
	s.prevPermOpt1(A);
    }
}
