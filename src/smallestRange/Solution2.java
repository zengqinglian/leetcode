package smallestRange;

import java.util.List;
import java.util.PriorityQueue;

public class Solution2 {
  public int[] smallestRange(List<List<Integer>> nums) {
    PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
      return o1[2] - o2[2];
    });

    int max = Integer.MIN_VALUE;

    for (int i = 0; i < nums.size(); i++) {
      int[] e = new int[3];
      e[0] = i;
      e[1] = 0;
      e[2] = nums.get(i).get(0);
      queue.add(e);
      max = Math.max(e[2], max);
    }

    int gap = Integer.MAX_VALUE;
    int min = 0;
    int[] result = new int[2];
    while (queue.size() == nums.size()) {
      int[] e = queue.poll();
      min = e[2];
      if (max - min < gap) {
        gap = max - min;
        result[0] = min;
        result[1] = max;
      }

      if (e[1] + 1 < nums.get(e[0]).size()) {
        int[] n = new int[3];
        n[0] = e[0];
        n[1] = e[1] + 1;
        n[2] = nums.get(n[0]).get(n[1]);
        queue.add(n);
        max = Math.max(n[2], max);
      }
    }

    return result;
  }
}
