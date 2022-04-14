package minimumOperationstoReduceXtoZero;

import java.util.HashMap;
import java.util.Map;
/*
Runtime: 159 ms, faster than 21.76% of Java online submissions for Minimum Operations to Reduce X to Zero.
Memory Usage: 207.7 MB, less than 5.93% of Java online submissions for Minimum Operations to Reduce X to Zero.
 */
public class Solution1 {
  /*
  Calculate max length of subarray.
   */
  public int minOperations(int[] nums, int x) {
    Map<Integer, Integer> prefixSumMap = new HashMap<>();
    prefixSumMap.put(nums[0], 0);
    for(int i=1;i<nums.length; i++) {
      nums[i]=nums[i-1] + nums[i];
      prefixSumMap.put(nums[i], i);
    }
    int targetSubArray = nums[nums.length-1] - x;
    if(targetSubArray == 0) {
      return nums.length;
    }
    int res = 0;
    for(int i =0; i<nums.length; i++) {
      if(prefixSumMap.containsKey(targetSubArray)) {
        res = Math.max(res, prefixSumMap.get(targetSubArray)+1);
      }
      Integer target = prefixSumMap.get(nums[i] + targetSubArray);
      if(target != null) {
        res = Math.max(res, target -i);
      }
    }
    if(res == 0) {
      return -1;
    }
    return nums.length-res;
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    int[] nums={1,1,4,2,3};
    s.minOperations(nums, 5);
  }
}
