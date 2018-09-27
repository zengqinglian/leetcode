package scoreofParentheses;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    // 6ms solution , beat 40%
    public int scoreOfParentheses(String S) {
	Stack<Integer> weights = new Stack<>();
	LinkedList<String> queue = new LinkedList<>();

	for (int i = 0; i < S.length(); i++) {
	    char c = S.charAt(i);
	    if (c == '(') {
		if (weights.isEmpty()) {
		    queue.add("1");
		    weights.push(1);
		} else {
		    int weight = weights.peek();

		    if (weight == 1) {
			weights.pop();
			weights.push(2);
			weights.push(1);
			queue.removeLast();
			queue.add("2");
			queue.add("(");
			queue.add("1");
		    } else {
			queue.add("1");
			weights.push(1);
		    }
		}
	    } else {
		if (weights.pop() == 2)
		    queue.add(")");
	    }
	}
	int result = calculate(queue);
	return result;
    }

    private int calculate(LinkedList<String> queue) {
	int result = 0;

	while (!queue.isEmpty()) {
	    String v = queue.removeFirst();
	    if (v.equals("1")) {
		result += 1;
	    } else if (v.equals("2")) {
		queue.removeFirst();
		result += 2 * calculate(queue);
	    } else {
		return result;
	    }
	}
	return result;
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.scoreOfParentheses("(()(()()))()");
    }

}
