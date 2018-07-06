package globalandLocalInversions;

public class Solution1 {
    // 10ms solution - beat 100%
    // 0,1,2,3,4,5,6...n-1 Only possible to match requirement is you just swap
    // number adjacent each other.
    // So just need to check Math.abs(i - A[i]) > 1 exists.
    public boolean isIdealPermutation(int[] A) {
	for (int i = 0; i < A.length; i++) {
	    if (Math.abs(i - A[i]) > 1) {
		return false;
	    }
	}

	return true;
    }
}
