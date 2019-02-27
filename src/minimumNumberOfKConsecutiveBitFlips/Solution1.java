package minimumNumberOfKConsecutiveBitFlips;

public class Solution1 {
    // someone's 8ms solution , beat 100%
    /*
     * When we flip a subarray, let's call the set of indices we flipped an
     * interval. We'll keep track of flip, the number of overlapping intervals in
     * our current position. We only care about the value of flip modulo 2.
     * 
     * When we flip an interval starting at i, we create a hint for a closing event
     * at i+K telling us to flip our writing state back.
     * 
     * Please see the inline comments for more details.
     */
    public int minKBitFlips(int[] A, int K) {
	int N = A.length;
	int[] hint = new int[N];
	int ans = 0, flip = 0;

	// When we flip a subarray like A[i], A[i+1], ..., A[i+K-1]
	// we can instead flip our current writing state, and put a hint at
	// position i+K to flip back our writing state.
	for (int i = 0; i < N; ++i) {
	    flip ^= hint[i];
	    if (A[i] == flip) { // If we must flip the subarray starting here...
		ans++; // We're flipping the subarray from A[i] to A[i+K-1]
		if (i + K > N)
		    return -1; // If we can't flip the entire subarray, its impossible
		flip ^= 1;
		if (i + K < N)
		    hint[i + K] ^= 1;
	    }
	}

	return ans;
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	int[] A = { 0, 0, 0, 1, 0, 1, 1, 0 };
	s.minKBitFlips(A, 3);
    }
}
