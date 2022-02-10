package maximumSumObtainedofAnyPermutation;

import java.util.Arrays;
/*
Over Time limit
80 / 84 test cases passed.
 */
public class Solution {
  public int maxSumRangeQuery(int[] nums, int[][] requests) {
    int[] countArray = new int[nums.length];
    for(int[] request : requests) {
      for(int i=request[0]; i<=request[1]; i++) {
        countArray[i]++;
      }
    }
    Arrays.sort(nums);
    Arrays.sort(countArray);
    long res = 0;
    for(int i=nums.length-1; i>=0; i--) {
      if(countArray[i]>0) {
        res+= (nums[i] * 1l * countArray[i]);
        res %= 1_000_000_007;
      }else{
        break;
      }
    }
    return (int)res;
  }
}
