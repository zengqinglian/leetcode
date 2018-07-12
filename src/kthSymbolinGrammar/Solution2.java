package kthSymbolinGrammar;

public class Solution2 {
    // 3ms solution beat 90%
    public int kthGrammar(int N, int K) {
	if (K == 1) {
	    return 0;
	}
	if (K == 2) {
	    return 1;
	}

	if (K % 2 == 1) {
	    return kthGrammar(N, K / 2 + 1) == 0 ? 0 : 1;
	} else {
	    return kthGrammar(N, K / 2) == 0 ? 1 : 0;
	}
    }

}
