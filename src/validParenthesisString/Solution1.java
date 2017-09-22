package validParenthesisString;

import java.util.Stack;

public class Solution1 {
  // improve - meet avg speed. beat 50%
  public boolean checkValidString(String s) {

    Stack<Character> stack = new Stack<>();
    char[] chars = s.toCharArray();
    for (int i = 0; i < chars.length; i++) {
      if (chars[i] == '(' || chars[i] == '*') {
        stack.push(chars[i]);
      } else {
        if (stack.isEmpty()) {
          return false;
        } else {
          int startCnt = 0;
          boolean foundLeft = false;
          while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(') {
              foundLeft = true;
              break;
            } else {
              startCnt++;
            }
          }
          int putBack = foundLeft ? startCnt : startCnt - 1;
          for (int j = 1; j <= putBack; j++) {
            stack.push('*');
          }

        }
      }
    }

    int countStar = 0;
    while (!stack.isEmpty()) {
      char c = stack.pop();
      if (c != '*') {
        if (countStar > 0) {
          countStar--;
        } else {
          return false;
        }
      } else {
        countStar++;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    System.out.print(s.checkValidString("(*()"));
  }
}
