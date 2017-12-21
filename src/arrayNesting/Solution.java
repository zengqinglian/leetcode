package arrayNesting;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  // 60ms solution beat 33% only
  public int arrayNesting(int[] nums) {

    if (nums.length == 0) {
      return 0;
    }

    if (nums.length == 1) {
      return 1;
    }

    boolean[] markers = new boolean[nums.length];

    int max = 0;

    for (int i = 0; i < nums.length; i++) {
      if (!markers[i]) {
        Set<Integer> set = new HashSet<>();
        int index = i;
        while (!set.contains(nums[index])) {
          set.add(nums[index]);
          index = nums[index];
          markers[index] = true;
        }
        max = Math.max(max, set.size());
      }

    }

    return max;

  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {5, 4, 0, 3, 1, 6, 2};
    s.arrayNesting(nums);
  }
}
