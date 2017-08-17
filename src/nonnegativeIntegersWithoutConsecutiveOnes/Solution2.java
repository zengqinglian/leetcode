package nonnegativeIntegersWithoutConsecutiveOnes;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
  // improve solution -- still over time
  public int findIntegers(int num) {
    Queue<Integer> q = new LinkedList<>();

    if (num == 0) {
      return 1;
    }
    if (num == 1) {
      return 2;
    }

    int count = 3;
    int e = 2;
    while (e * 2 <= num) {
      if (e % 2 == 0) {
        q.add(e * 2);
        count++;
        if (e * 2 + 1 <= num) {
          q.add(e * 2 + 1);
          count++;
        }
      } else {
        q.add(e * 2);
        count++;
      }
      e = q.poll();
    }

    return count;
  }
}
