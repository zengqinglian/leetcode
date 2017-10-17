package topKFrequentWords;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution1 {
  // O(n) time with only O(k) extra space. beat 70%
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    int max = 0;
    for (String str : words) {
      if (map.containsKey(str)) {
        map.put(str, map.get(str) + 1);
      } else {
        map.put(str, 1);
      }
      max = Math.max(max, map.get(str));
    }

    PriorityQueue<String>[] q = new PriorityQueue[max];

    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (q[entry.getValue() - 1] == null) {
        q[entry.getValue() - 1] = new PriorityQueue<String>();
      }
      q[entry.getValue() - 1].add(entry.getKey());
    }

    List<String> result = new ArrayList<>();
    for (int j = max - 1; j >= 0; j--) {
      if (q[j] != null) {
        while (!q[j].isEmpty()) {
          result.add(q[j].poll());
          if (result.size() == k) {
            return result;
          }
        }
      }
    }
    return result;
  }

}
