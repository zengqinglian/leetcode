package minimumAddtoMakeParenthesesValid;

import java.util.Stack;

public class Solution {
    // meet avg speed beat 50%
    public int minAddToMakeValid(String S) {
	Stack<Character> stack = new Stack<>();
	int res = 0;
	for (char c : S.toCharArray()) {
	    if (c == '(') {
		stack.push(c);
	    } else {
		if (stack.isEmpty()) {
		    res++;
		} else {
		    stack.pop();
		}
	    }
	}
	return res + stack.size();
    }
}
