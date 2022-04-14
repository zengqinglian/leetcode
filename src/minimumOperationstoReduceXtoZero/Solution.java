package minimumOperationstoReduceXtoZero;

import java.util.HashMap;
import java.util.Map;
/*
Runtime: 151 ms, faster than 23.56% of Java online submissions for Minimum Operations to Reduce X to Zero.
Memory Usage: 78.7 MB, less than 79.85% of Java online submissions for Minimum Operations to Reduce X to Zero.
 */
public class Solution {
  public int minOperations(int[] nums, int x) {
    Map<Integer,Integer> leftMap = new HashMap<>();
    Map<Integer,Integer> rightMap = new HashMap<>();
    int sumLeft = 0;
    int sumRight = 0;
    int res = Integer.MAX_VALUE;
    for(int i=0; i<nums.length; i++) {
      sumLeft += nums[i];
      if(sumLeft < x && rightMap.containsKey(x-sumLeft) && nums.length - rightMap.get(x-sumLeft) > i) {
        res = Math.min(res, i+1 + rightMap.get(x-sumLeft)) ;
      }else if (sumLeft == x) {
        res = Math.min(res, i+1);
      }
      leftMap.put(sumLeft, i+1);

      int right = nums.length-1-i;
      sumRight += nums[right];
      if(sumRight<x && leftMap.containsKey(x-sumRight) && right > leftMap.get(x-sumRight)-1) {
        res = Math.min(res, i+1 + leftMap.get(x-sumRight));
      }else if (sumRight == x) {
        res = Math.min(res, i+1);
      }
      rightMap.put(sumRight, i+1);

      if(sumLeft>x && sumRight>x) {
        break;
      }
    }

    if(res == Integer.MAX_VALUE) {
      return -1;
    }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {1,1};
    s.minOperations(nums, 3);
  }
}
