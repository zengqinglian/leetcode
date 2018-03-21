package subsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
  // 5ms solution - beat 50%.
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    generateResult(nums, 0, new ArrayList<>(), result);
    result.add(new ArrayList<>());
    return result;
  }

  private void generateResult(int[] nums, int s, List<Integer> temp, List<List<Integer>> result) {

    for (int j = s; j < nums.length; j++) {
      if (j != s && nums[j] == nums[j - 1]) {
        continue;
      }

      temp.add(nums[j]);
      result.add(new ArrayList<>(temp));
      generateResult(nums, j + 1, temp, result);
      temp.remove(temp.size() - 1);
    }
  }


  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {1, 2, 3};
    s.subsetsWithDup(nums);
  }
}
