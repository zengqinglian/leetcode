package dailyTemperatures;

import java.util.Stack;

public class Solution {
  // 70ms O(N) solution.
  public int[] dailyTemperatures(int[] temperatures) {
    int[] result = new int[temperatures.length];

    if (temperatures.length == 0) {
      return result;
    }

    if (temperatures.length == 1) {
      result[0] = 0;
      return result;
    }

    Stack<Integer> stack = new Stack<>();

    for (int i = 0; i < temperatures.length; i++) {
      if (stack.isEmpty()) {
        stack.push(i);
      } else {
        int newTemp = temperatures[i];
        while (!stack.isEmpty()) {
          if (temperatures[stack.peek()] < newTemp) {
            result[stack.peek()] = i - stack.pop();
          } else {
            stack.push(i);
            break;
          }
        }
        if (stack.isEmpty()) {
          stack.push(i);
        }
      }
    }

    while (stack.isEmpty()) {
      result[stack.pop()] = 0;
    }

    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
    s.dailyTemperatures(temperatures);
  }
}
