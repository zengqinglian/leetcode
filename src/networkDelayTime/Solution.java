package networkDelayTime;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
  // 337 ms solution.
  public int networkDelayTime(int[][] times, int N, int K) {
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
    for (int[] arr : times) {
      if (map.containsKey(arr[0])) {
        map.get(arr[0]).put(arr[1], arr[2]);
      } else {
        Map<Integer, Integer> newRoute = new HashMap<>();
        newRoute.put(arr[1], arr[2]);
        map.put(arr[0], newRoute);
      }
    }
    Queue<int[]> q = new LinkedList<>();
    Map<Integer, Integer> visitied = new HashMap<>();

    if (map.containsKey(K)) {
      int[] node = new int[2];
      node[0] = K;
      node[1] = 0;
      q.add(node);
    } else {
      return -1;
    }

    while (!q.isEmpty()) {
      int[] node = q.poll();
      if (visitied.containsKey(node[0])) {
        visitied.put(node[0], Math.min(node[1], visitied.get(node[0])));
      } else {
        visitied.put(node[0], node[1]);
      }
      int val = node[1];
      Map<Integer, Integer> nextNode = map.get(node[0]);
      if (nextNode == null) {
        continue;
      }
      for (int key : nextNode.keySet()) {
        int newVal = val + nextNode.get(key);
        if (!visitied.containsKey(key) || visitied.get(key) > newVal) {
          int[] newN = {key, newVal};
          q.add(newN);
        }
      }
    }
    if (visitied.size() == N) {
      int result = 0;
      for (int val : visitied.values()) {
        result = Math.max(result, val);
      }
      return result;
    }

    return -1;

  }

  public static void main(String[] args) {
    int[][] times = { {1, 2, 1}, {2, 3, 2}, {1, 3, 4}};
    Solution s = new Solution();
    s.networkDelayTime(times, 3, 1);
  }
}
