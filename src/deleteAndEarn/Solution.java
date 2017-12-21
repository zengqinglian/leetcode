package deleteAndEarn;

import java.util.TreeMap;

public class Solution {
  // use a sorted map to group the numbers. loop through the map
  // from largest number. 26ms solution. time O(N)+O(max - min) , space O(Max -
  // min)
  public int deleteAndEarn(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    TreeMap<Integer, Integer> map = new TreeMap<>();
    for (int i : nums) {
      if (map.containsKey(i)) {
        map.put(i, map.get(i) + i);
      } else {
        map.put(i, i);
      }
    }

    int min = map.firstKey();
    int max = map.lastKey();

    int[] dp = new int[max - min + 1];

    for (int i = dp.length - 1; i >= 0; i--) {
      int val = i + min;
      if (i == dp.length - 1) {
        dp[i] = map.get(val);
      } else {
        if (i + 2 <= dp.length - 1) {
          dp[i] = Math.max(dp[i + 1], dp[i + 2] + map.getOrDefault(val, 0));
        } else {
          dp[i] = Math.max(dp[i + 1], map.getOrDefault(val, 0));
        }
      }

    }



    return dp[0];
  }
}
