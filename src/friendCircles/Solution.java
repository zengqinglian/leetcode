package friendCircles;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  // solution beat 50%
  public int findCircleNum(int[][] M) {
    if (M == null) {
      return 0;
    }
    int N = M.length;
    if (N == 0) {
      return 0;
    }

    Queue<Integer> queue = new LinkedList<>();
    boolean[] checkedList = new boolean[N];
    int result = 0;

    for (int i = 0; i < N; i++) {
      if (!checkedList[i]) {
        checkedList[i] = true;
        if (queue.isEmpty()) {
          result++;
        }
        queue.add(i);
      } else {
        continue;
      }

      while (!queue.isEmpty()) {
        int n = queue.poll();
        for (int j = 0; j < N; j++) {
          if (n != j && !checkedList[j] && M[n][j] == 1) {
            queue.add(j);
            checkedList[j] = true;
          }
        }
      }
    }

    return result;

  }
}
