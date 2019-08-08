package minimumDominoRotationsForEqualRow;

public class Solution {
    // 5ms solution , beat 70%
    public int minDominoRotations(int[] A, int[] B) {
	int[] counterA = new int[7];
	int[] counterB = new int[7];
	int[] counter = new int[7];
	for (int i = 0; i < A.length; i++) {
	    int a = A[i];
	    int b = B[i];
	    counterA[a]++;
	    counterB[b]++;

	    if (a != b) {
		counter[a]++;
		counter[b]++;
	    } else {
		counter[a]++;
	    }
	}

	int min = A.length;
	boolean found = false;
	for (int i = 1; i <= 6; i++) {
	    if (counter[i] == A.length) {
		found = true;
		min = Math.min(min, Math.min(A.length - counterA[i], A.length - counterB[i]));
	    }
	}

	if (found) {
	    return min;
	}
	return -1;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 2, 1, 2, 4, 2, 2 };
	int[] B = { 5, 2, 6, 2, 3, 2 };

	s.minDominoRotations(A, B);
    }
}
