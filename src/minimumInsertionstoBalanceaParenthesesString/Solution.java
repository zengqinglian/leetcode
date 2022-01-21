package minimumInsertionstoBalanceaParenthesesString;

import java.util.Stack;
/*
Runtime: 77 ms, faster than 5.04% of Java online submissions for Minimum Insertions to Balance a Parentheses String.
Memory Usage: 52.5 MB, less than 6.32% of Java online submissions for Minimum Insertions to Balance a Parentheses String.
 */
public class Solution {
  public int minInsertions(String s) {
    Stack<Character> stack = new Stack<>();
    int idx = 0;
    int res = 0;
    while(idx<s.length()) {
      char c = s.charAt(idx++);
      if(c == '(') {
        if(stack.isEmpty() || stack.peek()=='(') {
          stack.push(c);
        }else{
          res++;
          stack.pop();
          stack.pop();
          stack.push(c);
        }
      }else{
        if(stack.isEmpty()) {
          stack.push('(');
          res++;
          stack.push(c);
        }else if (stack.peek() == '('){
          stack.push(c);
        }else{
          stack.pop();
          stack.pop();
        }
      }
    }
    if(stack.isEmpty()) {
      return res;
    }
    while(!stack.isEmpty()){
      if(stack.peek()=='(') {
        stack.pop();
        res+=2;
      }else{
        stack.pop();
        stack.pop();
        res+=1;
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.minInsertions("))())(");
  }
}
