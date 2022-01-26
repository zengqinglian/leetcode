package maximumNumberofNonOverlappingSubarraysWithSumEqualsTarget;

import java.util.HashMap;
import java.util.Map;
/*
Someone's map solution, O(N)
 */
public class Solution2 {
  public int maxNonOverlapping(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);
    int sum = 0, ans = 0, maxIndex = -2;
    for(int i=0;i<nums.length;i++) {
      sum += nums[i];
      if (map.containsKey(sum - target) && map.get(sum - target) >= maxIndex) {
        ans++;
        maxIndex = i;
      }
      map.put(sum, i);
    }

    return ans;
  }
}
