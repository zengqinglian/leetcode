package subarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  // 96ms solution - beat 90% - o(N)
  public int subarraySum(int[] nums, int k) {
    int result = 0;
    Map<Integer, Integer> sumMap = new HashMap<>();

    sumMap.put(0, 1);
    int sum = 0;

    for (int i = 0; i < nums.length; i++) {
      sum += nums[i];

      if (sumMap.containsKey(sum - k)) {
        result += sumMap.get(sum - k);
      }

      if (sumMap.containsKey(sum)) {
        sumMap.put(sum, sumMap.get(sum) + 1);
      } else {
        sumMap.put(sum, 1);
      }

    }

    return result;

  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {1, 1, 1, 1, 1, 1};
    s.subarraySum(nums, 2);
  }
}
