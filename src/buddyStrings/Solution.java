package buddyStrings;

public class Solution {
    // 2ms, beat 74%
    public boolean buddyStrings(String A, String B) {
	if (A.length() != B.length()) {
	    return false;
	}
	if (A.length() < 2) {
	    return false;
	}

	int diffIdx1 = -1;
	int diffIdx2 = -2;
	int diffcnt = 0;
	int[] letterCnt = new int[26];
	boolean equalStringsValidFlg = false;
	for (int i = 0; i < A.length(); i++) {
	    char a = A.charAt(i);
	    char b = B.charAt(i);
	    if (a != b) {
		diffcnt++;
		if (diffcnt > 2) {
		    return false;
		}
		if (diffIdx1 < 0) {
		    diffIdx1 = i;
		} else {
		    diffIdx2 = i;
		}
	    } else {
		letterCnt[a - 'a']++;
		if (letterCnt[a - 'a'] >= 2) {
		    equalStringsValidFlg = true;
		}
	    }
	}

	if (equalStringsValidFlg && diffIdx1 < 0 && diffIdx2 < 0) {
	    return true;
	}

	if (diffIdx1 < 0 || diffIdx2<0) {
	    return false;
	}
	

	return (A.charAt(diffIdx1) == B.charAt(diffIdx2) && A.charAt(diffIdx2) == B.charAt(diffIdx1));

    }
}
