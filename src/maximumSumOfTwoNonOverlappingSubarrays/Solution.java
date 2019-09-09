package maximumSumOfTwoNonOverlappingSubarrays;

public class Solution {
    // 1ms solution , beat 90%
    public int maxSumTwoNoOverlap(int[] A, int L, int M) {
	int[] nodeM = new int[A.length - M + 1];
	int[] nodeL = new int[A.length - L + 1];
	int sumM = 0;
	int sumL = 0;
	int indexL = 0;
	int indexM = 0;
	for (int i = 0; i < A.length; i++) {
	    if (i >= L - 1) {
		sumL += A[i];
		nodeL[indexL] = sumL;
		sumL -= A[indexL];
		indexL++;
	    } else {
		sumL += A[i];
	    }
	    if (i >= M - 1) {
		sumM += A[i];
		nodeM[indexM] = sumM;
		sumM -= A[indexM];
		indexM++;
	    } else {
		sumM += A[i];
	    }
	}
	int[] nodeLMaxHead = new int[nodeL.length];
	int[] nodeLMaxTail = new int[nodeL.length];
	for (int i = 0, j = nodeL.length - 1; i < nodeL.length; i++, j--) {
	    if (i - 1 < 0) {
		nodeLMaxHead[i] = nodeL[i];
	    } else {
		nodeLMaxHead[i] = Math.max(nodeLMaxHead[i - 1], nodeL[i]);
	    }
	    if (j + 1 >= nodeL.length) {
		nodeLMaxTail[j] = nodeL[j];
	    } else {
		nodeLMaxTail[j] = Math.max(nodeLMaxTail[j + 1], nodeL[j]);
	    }

	}

	int max = 0;
	for (int i = 0; i < nodeM.length; i++) {
	    max = Math.max(max, nodeM[i] + getMaxFromL(i - 1, i + M, nodeLMaxHead, nodeLMaxTail, L));
	}

	return max;
    }

    private int getMaxFromL(int i, int j, int[] nodeLMaxHead, int[] nodeLMaxTail, int L) {
	int res = 0;
	if (i - L + 1 >= 0) {
	    int index = i - L + 1;
	    res = nodeLMaxHead[index];
	}
	if (j < nodeLMaxTail.length) {
	    int index = j;
	    res = Math.max(res, nodeLMaxTail[index]);
	}

	return res;
    }

    public static void main(String[] args) {
	int[] A = { 0, 6, 5, 2, 2, 5, 1, 9, 4 };
	Solution s = new Solution();
	s.maxSumTwoNoOverlap(A, 1, 2);
    }
}
