package kthSymbolinGrammar;

public class Solution {
    // over memory limit
    public int kthGrammar(int N, int K) {
	if (K == 1) {
	    return 0;
	}

	boolean[] dp = new boolean[(int) Math.pow(2, N - 1) + 1];

	dp[1] = false;
	dp[2] = true;

	int start = 2;
	int newIndex = 3;
	
	while (newIndex <= K) {
	    int loopEnd = newIndex;
	    int loopStart = start;
	    for (int i = loopStart; i < loopEnd; i++) {
		if(dp[i]) {
		    dp[newIndex] = true;
		    dp[newIndex + 1] = false;
		} else {
		    dp[newIndex] = false;
		    dp[newIndex + 1] = true;
		}
		newIndex += 2;
		start++;
	    }
	}
	
	if(dp[K]) {
	    return 1;
	}else {
	    return 0;
	}

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.kthGrammar(4, 5);
    }

}
