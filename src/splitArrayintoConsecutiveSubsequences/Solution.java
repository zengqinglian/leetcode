package splitArrayintoConsecutiveSubsequences;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
  // solution beat 25%
  public boolean isPossible(int[] nums) {

    if (nums.length < 3) {
      return false;
    }

    Map<Integer, Integer> map = new TreeMap<>();

    for (int i : nums) {
      if (map.containsKey(i)) {
        map.put(i, map.get(i) + 1);
      } else {
        map.put(i, 1);
      }
    }

    // group - find 3 consecutive integers or not
    Map<Integer, Integer> group3 = new HashMap<>();

    for (int k : map.keySet()) {
      if (map.get(k) > 0) {
        if (group3.containsKey(k - 1)) {
          if (group3.get(k - 1) >= map.get(k)) {
            group3.put(k - 1, group3.get(k - 1) - map.get(k));
            if (group3.containsKey(k)) {
              group3.put(k, group3.get(k) + map.get(k));
            } else {
              group3.put(k, map.get(k));
            }
            map.put(k, 0);
          } else {
            if (group3.containsKey(k)) {
              group3.put(k, group3.get(k) + group3.get(k - 1));
            } else {
              group3.put(k, group3.get(k - 1));
            }
            map.put(k, map.get(k) - group3.get(k - 1));
            group3.put(k - 1, 0);
          }
        }
      }

      if (map.get(k) == 0) {
        continue;
      } else if (map.get(k) > 0 && map.containsKey(k + 1) && map.get(k + 1) > 0
          && map.containsKey(k + 2) && map.get(k + 2) > 0 && map.get(k) <= map.get(k + 1)
          && map.get(k) <= map.get(k + 2)) {

        if (group3.containsKey(k + 2)) {
          group3.put(k + 2, group3.get(k + 2) + map.get(k));
        } else {
          group3.put(k + 2, map.get(k));
        }
        map.put(k + 1, map.get(k + 1) - map.get(k));
        map.put(k + 2, map.get(k + 2) - map.get(k));
        map.put(k, 0);
      } else {
        return false;
      }
    }

    return true;

  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {1, 2, 3, 3, 4, 5};
    s.isPossible(nums);
  }

}
