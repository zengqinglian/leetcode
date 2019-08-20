package binaryStringWithSubstringsRepresenting1Ton;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    // 1m solution , beat 50%
    public boolean queryString(String S, int N) {
	double L = Math.log(N) / Math.log(2);
	int len = (int) Math.floor(L) + 1;
	if (N == Math.pow(2, len) - 1) {
	    return checkAll(S, len);
	}else {
	    return checkNumberRange(S, N, (int) Math.pow(2, len - 1)) && checkAll(S, len - 1);
	    
	}
    }

    private boolean checkNumberRange(String S, int N, int start) {
	for (int i = start; i <= N; i++) {
	    if (!S.contains(Integer.toBinaryString(i))) {
		return false;
	    }
	}
	return true;
    }

    private boolean checkAll(String S, int len) {
	Set<String> set = new HashSet<>();
	for (int i = 0; i < S.length() - len + 1; i++) {
	    set.add(S.substring(i, i + len));
	}
	if (set.size() >= Math.pow(2, len) - 1) {
	    return true;
	}

	return false;

    }



    public static void main(String[] args) {
	Solution s = new Solution();
	s.queryString("0110", 3);
    }
}
