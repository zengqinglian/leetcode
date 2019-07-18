package checkIfWordIsValidAfterSubstitutions;

public class Solution {
    // 636ms solution , beat 5%
    public boolean isValid(String S) {
	if(S.length()<3) {
	    return false;
	}
	if (S.length() == 3) {
	    return S.equals("abc");
	}
	for (int i = 0; i < S.length() - 3; i++) {
	    if(S.substring(i, i+3).equals("abc")) {
		return isValid(S.substring(0, i) + S.substring(i + 3));
	    }
	}
	
	return false;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.isValid("aabcbc");
    }
}
