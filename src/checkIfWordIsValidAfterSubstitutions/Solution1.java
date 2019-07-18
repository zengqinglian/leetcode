package checkIfWordIsValidAfterSubstitutions;

import java.util.Stack;

public class Solution1 {
    // 15ms solution , beat 80%
    public boolean isValid(String S) {
	Stack<Character> stack = new Stack<>();
	for (int i = 0; i < S.length(); i++) {
	    char c = S.charAt(i);
	    if (c == 'c') {
		if (stack.size() < 2) {
		    return false;
		} else {
		    if ('b' == stack.pop() && 'a' == stack.pop()) {
			continue;
		    } else {
			return false;
		    }
		}
	    } else {
		stack.push(c);
	    }
	}
	return stack.isEmpty();
    }

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	s.isValid("aabcbc");
    }
}
