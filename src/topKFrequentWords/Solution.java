package topKFrequentWords;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
  // solution beat 20%
  // extra O(N) + K space and time complexity is O(N)+O(NLOGK)+O(K)
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map = new HashMap<>();
    for (String str : words) {
      if (map.containsKey(str)) {
        map.put(str, map.get(str) + 1);
      } else {
        map.put(str, 1);
      }
    }
    PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>((x, y) -> {
      if (x.getValue() - y.getValue() > 0) {
        return 1;
      } else if (x.getValue() - y.getValue() < 0) {
        return -1;
      } else {
        return -x.getKey().compareTo(y.getKey());
      }
    });
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      if (q.size() < k) {
        q.add(entry);
      } else if (q.size() == k) {
        if (q.peek().getValue() < entry.getValue()) {
          q.poll();
          q.add(entry);
        } else if (q.peek().getValue() == entry.getValue()
            && q.peek().getKey().compareTo(entry.getKey()) > 0) {
          q.poll();
          q.add(entry);
        }
      }
    }

    String[] list = new String[k];
    while (!q.isEmpty()) {
      list[k - 1] = q.poll().getKey();
      k--;
    }

    return Arrays.asList(list);

  }

  public static void main(String[] args) {
    String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
    Solution s = new Solution();
    s.topKFrequent(words, 4);
  }
}
