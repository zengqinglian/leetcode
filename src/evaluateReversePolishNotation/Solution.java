package evaluateReversePolishNotation;

import java.util.Stack;
/*
Runtime
9 ms
Beats
21.45%
Memory
43.9 MB
Beats
15.24%
 */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for(String s : tokens) {
            if (!s.equals("+") && !s.equals("-")&& !s.equals("*")&& !s.equals("/")) {
                stack.push(s);
            } else {
                int v1 = Integer.valueOf(stack.pop());
                int v2 = Integer.valueOf(stack.pop());
                if (s.equals("+")) {
                    stack.push(String.valueOf(v2+v1));
                }
                if (s.equals("-")) {
                    stack.push(String.valueOf(v2-v1));
                }
                if (s.equals("*")) {
                    stack.push(String.valueOf(v2*v1));
                }
                if (s.equals("/")) {
                    stack.push(String.valueOf(v2/v1));
                }
            }
        }
        return Integer.valueOf(stack.peek());

    }

    public static void main(String[] args) {
        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        Solution s = new Solution();
        s.evalRPN(tokens);
    }
}
