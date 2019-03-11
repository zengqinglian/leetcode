package validateStackSequences;

import java.util.Stack;

public class Solution {
    // 9ms solution , beat 75%
    public boolean validateStackSequences(int[] pushed, int[] popped) {

	Stack<Integer> stack = new Stack<>();
	int idxPush = 0;
	for (int i = 0; i < popped.length; i++) {
	    while (idxPush < pushed.length && (stack.isEmpty() || stack.peek() != popped[i])) {
		stack.push(pushed[idxPush]);
		idxPush++;
	    }

	    while (!stack.isEmpty() && stack.peek() == popped[i]) {
		stack.pop();
	    }
	}
	
	return stack.isEmpty();
    }
}
