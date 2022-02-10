package maximumSumObtainedofAnyPermutation;

import java.util.Arrays;
import java.util.Comparator;

/*
Over Time limit
78 / 84 test cases passed.
 */
public class Solution1 {
  public int maxSumRangeQuery(int[] nums, int[][] requests) {
    int[] countArray = new int[nums.length];
    for(int i=0; i<nums.length; i++) {
      for (int[] request : requests) {
        if (i>=request[0] && i<=request[1]){
          countArray[i]++;
        }
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
