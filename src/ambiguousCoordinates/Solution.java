package ambiguousCoordinates;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 25ms solution - beat 30%
    public List<String> ambiguousCoordinates(String S) {
	List<String> result = new ArrayList<>();
	for (int i = 2; i < S.length() - 1; i++) {
	    String A = S.substring(1, i);
	    String B = S.substring(i, S.length() - 1);
	    generateResult(A, B, result);
	}
	return result;
    }

    private void generateResult(String A, String B, List<String> result) {
	for (int i = 0; i < A.length(); i++) {
	    String strA = "";
	    if (i == A.length() - 1) {
		strA = A;
	    } else {
		strA = A.substring(0, i + 1) + "." + A.substring(i + 1);
	    }

	    if (isValid(strA)) {
		for (int j = 0; j < B.length(); j++) {
		    String strB = "";
		    if (j == B.length() - 1) {
			strB = B;
		    } else {
			strB = B.substring(0, j + 1) + "." + B.substring(j + 1);
		    }
		    if (isValid(strB)) {
			result.add("(" + strA + ", " + strB + ")");
		    }
		}
	    }
	}
    }

    private boolean isValid(String str) {
	if (str.length() == 1) {
	    return true;
	}

	int dotIndex = str.indexOf(".");
	if (dotIndex < 0) {
	    if (!str.startsWith("0")) {
		return true;
	    }
	} else {
	    String preDot = str.substring(0, dotIndex);

	    if ((preDot.length() == 1 || !str.substring(0, dotIndex).startsWith("0"))
		    && !str.substring(dotIndex + 1).endsWith("0")) {
		return true;
	    }
	}
	return false;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.ambiguousCoordinates("(0123)");
    }
}
