package numberofSubarrayswithBoundedMaximum;

public class Solution {
    // 7 ms solution beat only 30% O(N)
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
	int result = 0;
	int markStart = -1;
	int end = markStart;
	int deductStart = -1;
	int deductEnd = -1;
	boolean found = false;
	int deductval = 0;
	for (int i = 0; i < A.length; i++) {
	    if (A[i] > R) {
		if (found) {
		    if (deductStart >= 0)
			deductval += calculateDeduct(deductStart, deductEnd);
		    result += calculate(markStart, end);
		}
		markStart = -1;
		found = false;
		deductStart = -1;
	    } else {
		if (markStart < 0) {
		    markStart = i;
		}
		end = i;
		
		if (A[i] < L) {
		    if (deductStart < 0) {
			deductStart = i;
		    }
		    deductEnd = i;
		} else {
		    found = true;
		    if (deductStart >= 0) {
			deductval += calculateDeduct(deductStart, deductEnd);
		    }
		    deductStart = -1;
		}
	    }

	}


	if (found) {
	    if (deductStart >= 0) {
		deductval += calculateDeduct(deductStart, deductEnd);
	    }
	    result += calculate(markStart, end);
	}
	return result - deductval;
    }

    private int calculate(int markStart, int end) {
	int len1 = end - markStart + 1;
	int result = (len1 + 1) * len1 / 2;
	return result;
    }

    private int calculateDeduct(int start, int end) {
	int deduct = 0;
	int i = end - start + 1;
	deduct = ((1 + i) * i / 2);

	return deduct;
    }

    public static void main(String[] args) {
	int[] A = { 2, 9, 2, 5, 6 };
	Solution s = new Solution();
	s.numSubarrayBoundedMax(A, 2, 8);
    }
}
