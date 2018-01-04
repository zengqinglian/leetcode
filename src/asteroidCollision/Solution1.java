package asteroidCollision;

import java.util.Stack;

public class Solution1 {
  // slower solution, using a stack. beat 60%
  public int[] asteroidCollision(int[] asteroids) {

    if (asteroids.length < 2) {
      return asteroids;
    }

    Stack<Integer> stack = new Stack<>();

    for (int i : asteroids) {
      boolean addI = true;
      if (i < 0) {
        while (!stack.isEmpty()) {
          if (stack.peek() < 0) {
            break;
          } else if (stack.peek() > Math.abs(i)) {
            addI = false;
            break;
          } else if (stack.peek() == Math.abs(i)) {
            stack.pop();
            addI = false;
            break;
          } else {
            stack.pop();
          }
        }

        if (addI) {
          stack.push(i);
        }


      } else {
        stack.push(i);
      }
    }

    int[] result = new int[stack.size()];
    for (int i = result.length - 1; i >= 0; i--) {
      result[i] = stack.pop();
    }

    return result;
  }
}
