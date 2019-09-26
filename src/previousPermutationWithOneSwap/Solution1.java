package previousPermutationWithOneSwap;

public class Solution1 {
    // 0ms solution , beat 100%
    public int[] prevPermOpt1(int[] A) {
	int track = A.length - 1;
	int mark = track;
	while (track >= 1) {
	    track--;
	    if (A[track] > A[mark]) {
		int max = mark;
		for (int i = mark + 1; i < A.length; i++) {
		    if (A[i] >= A[max] && A[i] < A[track]) {
			max = i;
		    }
		}
		int temp = A[track];
		A[track] = A[max];
		A[max] = temp;
		return A;
	    } else if (A[track] < A[mark]) {
		mark = track;
	    }
	}
	return A;
    }
}
