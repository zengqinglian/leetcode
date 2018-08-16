package minimumSwapsToMakeSequencesIncreasing;

public class Solution {
    // recursion , over time limit solution
    public int minSwap(int[] A, int[] B) {

	if (A.length == 1) {
	    return 0;
	}
	int result = minSwap(A, B, 0);
	return result;
    }


    public int minSwap(int[] A, int[] B, int index) {
	if(index==0) {
	    int s1 = minSwap(A, B, index + 1);
	    swap(A, B, index);
	    int s2 = 1 + minSwap(A, B, index + 1);
	    swap(A, B, index);
	    return Math.min(s1, s2);
	} else if (index == A.length - 1) {
	    if (A[index - 1] < A[index] && B[index - 1] < B[index]) {
		return 0;
	    } else {
		swap(A, B, index);
		return 1;
	    }
	} else {
	    int s1 = Integer.MAX_VALUE;
	    int s2 = Integer.MAX_VALUE;
	    if (A[index - 1] < A[index] && B[index - 1] < B[index]) {
		s1 = minSwap(A, B, index + 1);
	    }
	    swap(A, B, index);
	    if (A[index - 1] < A[index] && B[index - 1] < B[index]) {
		s2 = 1 + minSwap(A, B, index + 1);
	    }
	    swap(A, B, index);
	    return Math.min(s1, s2);
	}

    }

    private void swap(int[] A, int[] B, int index) {
	int temp = A[index];
	A[index] = B[index];
	B[index] = temp;
   }

    public static void main(String[] args) {
	Solution s = new Solution();
	// int[] A = { 0, 7, 8, 10, 10, 11, 12, 13, 19, 18 };
	// int[] B = { 4, 4, 5, 7, 11, 14, 15, 16, 17, 20 };
	int[] A = { 1, 3, 5, 4 };
	int[] B = { 1, 2, 3, 7 };
	s.minSwap(A, B);
    }
}
