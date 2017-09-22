package validParenthesisString;

import java.util.LinkedList;

public class Solution {
  // over time limit
  public boolean checkValidString(String s) {
    LinkedList<Character> stack = new LinkedList<>();
    if (s.isEmpty()) {
      return true;
    }

    return checkString(s, stack);
  }

  private boolean checkString(String s, LinkedList<Character> stack) {
    char c = s.charAt(0);

    if (s.length() == 1) {

      if (c == '(') {
        return false;
      }

      if (c == ')') {
        if (stack.isEmpty()) {
          return false;
        } else {
          char ch = stack.pop();
          if (!stack.isEmpty()) {
            return false;
          }
          if (ch == '(') {
            return true;
          } else {
            return false;
          }
        }
      }

      if (c == '*') {
        if (stack.isEmpty()) {
          return true;
        } else {
          stack.pop();
          return stack.isEmpty();
        }
      }

      return stack.isEmpty();

    } else {
      if (c == '(') {
        stack.add(c);
        if (checkString(s.substring(1), new LinkedList<Character>(stack))) {
          return true;
        }
      }

      if (c == ')') {
        if (stack.isEmpty()) {
          return false;
        } else {
          char ch = stack.pop();
          if (ch == '(') {
            return checkString(s.substring(1), new LinkedList<Character>(stack));
          } else {
            return false;
          }
        }
      }

      if (c == '*') {
        if (checkString(s.substring(1), new LinkedList<Character>(stack))) {
          return true;
        } else {
          stack.add('(');
          if (checkString(s.substring(1), new LinkedList<Character>(stack))) {
            return true;
          }
          stack.pop();
          if (stack.isEmpty()) {
            return false;
          }
          char ch = stack.pop();
          if (ch == '(') {
            return checkString(s.substring(1), new LinkedList<Character>(stack));
          } else {
            return false;
          }
        }
      }

      return checkString(s.substring(1), new LinkedList<Character>(stack));
    }


  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.print(s.checkValidString("(*))"));
  }
}
