package partitionArrayintoDisjointIntervals;

public class Solution {
    // 7ms solution , meet avg speed.
    public int partitionDisjoint(int[] A) {
	int max = A[0];
	int length = 1;
	int newMax = max;
	for (int i = 1; i < A.length; i++) {
	    if (A[i] >= max) {
		length = i;
		newMax = A[i];
		for (int j = i + 1; j < A.length; j++) {
		    if (A[j] < max) {
			max = newMax;
			length = 0;
			i = j;
			if (j == A.length - 1) {
			    return length;
			} else {
			    break;
			}
		    } else {
			newMax = Math.max(newMax, A[j]);
			if (j == A.length - 1) {
			    return length;
			}
		    }
		}
	    } else {
		max = newMax;
	    }
	}
	return length;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 5, 0, 3, 8, 6 };
	s.partitionDisjoint(A);
    }
}
