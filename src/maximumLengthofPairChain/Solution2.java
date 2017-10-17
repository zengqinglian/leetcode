package maximumLengthofPairChain;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution2 {
  // quickest solution - beat 80%
  public int findLongestChain(int[][] pairs) {
    if (pairs.length == 0)
      return 0;
    Arrays.sort(pairs, new Comparator<int[]>() {
      public int compare(int[] a, int[] b) {
        return a[0] - b[0];
      }
    });
    PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
    pq.offer(pairs[0][1]);
    for (int i = 1; i < pairs.length; i++) {
      // if the max number of the chain greater than cur right number,
      // replace the max with the smaller one
      if (pq.peek() > pairs[i][1]) {
        pq.poll();
        pq.offer(pairs[i][1]);
      } else {
        // add the cur right number if chain can be formed;
        if (pq.peek() < pairs[i][0])
          pq.offer(pairs[i][1]);
      }
    }
    return pq.size();
  }
}
