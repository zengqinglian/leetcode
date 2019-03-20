package bagOfTokens;

import java.util.Arrays;

public class Solution {
    // 6ms solution , meet avg speed.
    public int bagOfTokensScore(int[] tokens, int P) {
	Arrays.sort(tokens);

	int i = 0;
	int j = tokens.length - 1;
	int point = 0;
	int max = 0;

	while (i <= j) {
	    if (P < tokens[i]) {
		if (point == 0) {
		    return max;
		} else {
		    point--;
		    P += tokens[j];
		    j--;
		}
	    } else {
		point++;
		P -= tokens[i];
		i++;
		max = Math.max(max, point);
	    }
	}
	return max;

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	int[] tokens = { 100, 200, 300, 400 };
	s.bagOfTokensScore(tokens, 200);
    }
}
