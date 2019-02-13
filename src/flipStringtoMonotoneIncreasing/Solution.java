package flipStringtoMonotoneIncreasing;

public class Solution {
    // 8ms solution, beat 60%
    public int minFlipsMonoIncr(String S) {
	int min = S.length();
	int cntZero = 0;
	int totalZero = 0;
	for (int i = 0; i < S.length(); i++) {
	    char c = S.charAt(i);
	    if (c == '0') {
		totalZero++;
	    }
	}

	for (int i = 0; i < S.length(); i++) {
	    char c = S.charAt(i);
	    if (c == '0') {
		cntZero++;
	    }
	    int val = i - cntZero;
	    val = val + totalZero - cntZero;
	    if (c == '0') {
		val++;
	    }
	    min = Math.min(min, val);


	}


	return min;
    }

    public static void main(String[] args) {
	// "10011111110010111011"
	Solution s = new Solution();
	s.minFlipsMonoIncr("10011111110010111011");
    }
}
