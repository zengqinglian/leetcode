package scrambleString;

public class Solution {
    // Over time limit solution , fail 250/283
    public boolean isScramble(String s1, String s2) {
	boolean result = isScramble(s1, s2, 0, s1.length() - 1, 0, s2.length() - 1);
	return result;
    }

    private boolean isScramble(String s1, String s2, int start, int end, int start2, int end2) {
	if(start ==  end) {
	    return (s1.charAt(start) == s2.charAt(start2));
	}
	
	if (s1.charAt(start) == s2.charAt(start2)) {
	    return isScramble(s1, s2, start + 1, end, start2 + 1, end2);
	}

	int len = end - start + 1;
	for (int l = 0; l < len - 1; l++) {
	    if ((isScramble(s1, s2, start, start + l, start2, start2 + l)
		    && isScramble(s1, s2, start + l + 1, end, start2 + l + 1, end2))
		    || (isScramble(s1, s2, start, start + l, end2 - l, end2)
			    && isScramble(s1, s2, start + l + 1, end, start2, end2 - l - 1))) {
		return true;
	    }
	}
	return false;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.isScramble("great", "rgtae");
    }
}
