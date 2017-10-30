package increasingSubsequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
  // 120ms solution - beat 3%
  public List<List<Integer>> findSubsequences(int[] nums) {
    Map<String, List<Integer>> result = new HashMap<>();

    List<List<Integer>> res = new ArrayList<>();

    for (int i = 1; i < nums.length; i++) {
      Map<String, List<Integer>> newMap = new HashMap<>();
      for (String key : result.keySet()) {
        if (nums[i] >= result.get(key).get(result.get(key).size() - 1)) {
          List<Integer> newList = new ArrayList<>(result.get(key));
          newList.add(nums[i]);
          String newKey = newList.toString();
          if (!result.containsKey(newKey)) {
            newMap.put(newKey, newList);
          }
        }
      }
      result.putAll(newMap);
      for (int j = 0; j < i; j++) {
        if (nums[i] >= nums[j]) {
          List<Integer> newList = new ArrayList<>();
          newList.add(nums[j]);
          newList.add(nums[i]);
          String key = newList.toString();
          if (!result.containsKey(key)) {
            result.put(key, newList);
          }
        }

      }
    }

    for (List<Integer> li : result.values()) {
      res.add(li);
    }

    return res;
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    int[] nums = {4, 6, 7, 7};
    s.findSubsequences(nums);
  }

}
