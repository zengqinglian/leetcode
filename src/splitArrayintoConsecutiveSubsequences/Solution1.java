package splitArrayintoConsecutiveSubsequences;

import java.util.HashMap;
import java.util.Map;

public class Solution1 {
  // improved solution beat 80%
  public boolean isPossible(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> group3 = new HashMap<>();
    for (int i : nums) {
      if (map.containsKey(i - 3) && map.get(i - 3) > 0) {
        return false;
      }
      if (map.containsKey(i - 1) && map.get(i - 1) > 0
          && (map.containsKey(i) && map.get(i) < map.get(i - 1) || !map.containsKey(i))) {
        if (map.containsKey(i - 2) && map.get(i - 2) > 0) {
          map.put(i - 1, map.get(i - 1) - 1);
          map.put(i - 2, map.get(i - 2) - 1);
          if (group3.containsKey(i)) {
            group3.put(i, group3.get(i) + 1);
          } else {
            group3.put(i, 1);
          }
        } else {
          if (map.containsKey(i)) {
            map.put(i, map.get(i) + 1);
          } else {
            map.put(i, 1);
          }
        }
      } else if (group3.containsKey(i - 1) && group3.get(i - 1) > 0) {
        group3.put(i - 1, group3.get(i - 1) - 1);
        if (group3.containsKey(i)) {
          group3.put(i, group3.get(i) + 1);
        } else {
          group3.put(i, 1);
        }
      } else {
        if (map.containsKey(i)) {
          map.put(i, map.get(i) + 1);
        } else {
          map.put(i, 1);
        }
      }
    }

    for (int k : map.keySet()) {
      if (map.get(k) > 0) {
        return false;
      }
    }

    return true;

  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    int[] nums = {1, 2, 3, 3, 4, 5};
    s.isPossible(nums);
  }
}
