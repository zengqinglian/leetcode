package deleteColumnstoMakeSortediii;

public class Solution {
    // 13ms solution beat 75%
    public int minDeletionSize(String[] A) {
	if (A.length < 1) {
	    return 0;
	}

	int[] marker = new int[A[0].length()];
	marker[0] =1;
	int maxLen = 0;
	for (int i = 1; i < A[0].length(); i++) {
	    for (int j = 0; j < i; j++) {
		boolean jumpout = false;
		for (String str : A) {
		    char cur = str.charAt(i);
		    char pre = str.charAt(j);
		    if (cur < pre) {
			jumpout = true;
			break;
		    }
		}
		if (jumpout) {
		    marker[i] = Math.max(marker[i], 1);

		} else {
		    marker[i] = Math.max(marker[i], marker[j] + 1);
		}
	    }
	    maxLen = Math.max(maxLen, marker[i]);

	}
	return A[0].length() - maxLen;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	String[] A = { "aaabaaa" };
	s.minDeletionSize(A);
    }
}
