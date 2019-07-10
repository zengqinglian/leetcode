package maximumNestingDepthofTwoValidParenthesesStrings;

import java.util.Stack;

public class Solution {
    // 4ms soltuion , beat 20%
    public int[] maxDepthAfterSplit(String seq) {
	int[] res = new int[seq.length()];
	Stack<Character> stack = new Stack<>();
	for (int i = 0; i < seq.length(); i++) {
	    char c = seq.charAt(i);

	    if (c == '(') {
		if (stack.size() % 2 == 0) {
		    res[i] = 0;
		} else {
		    res[i] = 1;
		}
		stack.push('(');
	    } else {
		if (stack.size() % 2 == 1) {
		    res[i] = 0;
		} else {
		    res[i] = 1;
		}
		stack.pop();
	    }
	}
	return res;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.maxDepthAfterSplit("(()())");
    }
}
