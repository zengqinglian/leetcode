package tripleswithBitwiseANDEqualToZero;

public class Solution {
    // 364 ms solution, beat 65%
    public int countTriplets(int[] A) {
	int sum = 0;
	for (int x = 0; x < A.length; x++) {
	    if (A[x] == 0) {
		sum += 1;
	    }
	    for (int y = x + 1; y < A.length; y++) {
		int v = A[x] & A[y];
		if (v == 0) {
		    sum += 6;
		}
		for (int z = y + 1; z < A.length; z++) {
			if ((v & A[z]) == 0) {
			    sum += 6;
			}
		    }
		
	    }
	}
	return sum;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] A = { 2, 1, 3, 4 };
	s.countTriplets(A);
    }
}
