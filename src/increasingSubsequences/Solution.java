package increasingSubsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
  // 280ms solution - beat 0.5%
  public List<List<Integer>> findSubsequences(int[] nums) {
    Set<String> cache = new HashSet<>();
    List<List<Integer>> result = new ArrayList<>();
    generateResult(0, cache, new ArrayList<Integer>(), result, nums);
    return result;
  }

  private void generateResult(int index, Set<String> cache, List<Integer> temp,
      List<List<Integer>> result, int[] nums) {
    if (index == nums.length) {
      return;
    }

    for (int i = index; i < nums.length; i++) {
      boolean added = false;
      if (temp.isEmpty()) {
        added = true;
        temp.add(nums[i]);
      } else if (temp.get(temp.size() - 1) <= nums[i]) {
        added = true;
        temp.add(nums[i]);
      }
      if (temp.size() >= 2) {
        String key = temp.toString();
        if (!cache.contains(temp.toString())) {
          cache.add(key);
          result.add(new ArrayList<Integer>(temp));
        }
      }
      generateResult(i + 1, cache, temp, result, nums);
      if (added)
        temp.remove(temp.size() - 1);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {7, 7, 4, 6};
    s.findSubsequences(nums);
  }
}
