package parsingABooleanExpression;

import java.util.Stack;

public class Solution {
    // 12 ms solution , beat 50%
    public boolean parseBoolExpr(String expression) {
	Stack<Character> stack = new Stack<>();
	for (char c : expression.toCharArray()) {
	    if (c == ')') {
		boolean hasTrue = false;
		boolean hasFalse = false;
		while (true) {
		    char chr = stack.pop();
		    if (chr == 't') {
			hasTrue = true;
		    }
		    if (chr == 'f') {
			hasFalse = true;
		    }
		    if (chr == '(') {
			break;
		    }
		}
		char op = stack.pop();
		if (op == '!') {
		    if (hasTrue) {
			stack.push('f');
		    } else {
			stack.push('t');
		    }
		}
		if (op == '&') {
		    if (hasFalse) {
			stack.push('f');
		    } else {
			stack.push('t');
		    }
		}
		if (op == '|') {
		    if (hasTrue) {
			stack.push('t');
		    } else {
			stack.push('f');
		    }
		}
	    } else {
		stack.push(c);
	    }
	}

	char c = stack.pop();
	if (c == 'f') {
	    return false;
	} else {
	    return true;
	}
    }
}
