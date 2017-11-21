package removeComments;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
  // 8ms solution - beat 20%
  public List<String> removeComments(String[] source) {
    Stack<String> stack = new Stack<>();
    List<String> result = new ArrayList<>();
    StringBuilder sb = null;
    boolean newLine = true;
    int sourceIndex = 0;
    for (String s : source) {
      if (sb == null || newLine) {
        sb = new StringBuilder();
      }
      int index = 0;
      boolean hasLineComment = false;
      while (index < s.length()) {
        String top = stack.isEmpty() ? "ANY" : stack.peek();
        if (top.equals("/*")) {
          if (s.charAt(index) == '*' && index + 1 < s.length() && s.charAt(index + 1) == '/') {
            stack.pop();
            newLine = true;
            index++;
          }
        } else if (!hasLineComment) {
          if (s.charAt(index) == '/' && index + 1 < s.length() && s.charAt(index + 1) == '/') {
            index++;
            hasLineComment = true;
          } else if (s.charAt(index) == '/' && index + 1 < s.length() && s.charAt(index + 1) == '*') {
            stack.push("/*");
            index++;
          } else {
            sb.append(s.charAt(index));
          }
        }
        index++;
      }

      if (!stack.isEmpty() && stack.peek().equals("/*")) {
        newLine = false;
      }

      if ((newLine && !sb.toString().equals("")) || sourceIndex == source.length - 1) {
        result.add(sb.toString());
      }
      sourceIndex++;
    }

    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    String[] source = {"a//*b/*/c", "blank", "d/*/e/*/f"};
    s.removeComments(source);
  }
}
