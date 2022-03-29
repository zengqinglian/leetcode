package kRadiusSubarrayAverages;

import java.util.Arrays;
/*
Runtime: 9 ms, faster than 97.05% of Java online submissions for K Radius Subarray Averages.
Memory Usage: 62.7 MB, less than 79.85% of Java online submissions for K Radius Subarray Averages.
 */
public class Solution {
  public int[] getAverages(int[] nums, int k) {
    if(k==0) {
      return nums;
    }
    int minLen = 2 * k +1;
    long sum = 0L;
    int[] res = new int[nums.length];
    int idx = k;
    for(int i=0; i<nums.length; i++) {
      if(i<minLen-1) {
        res[i] = -1;
        sum += nums[i];
      }else if(i==minLen-1){
        sum+=nums[i];
        res[idx++] = (int)(sum / minLen);
      }else{
        sum+=nums[i];
        sum-=nums[i-minLen];
        res[idx++] = (int)(sum / minLen);
      }
    }
    if(idx<nums.length) {
      Arrays.fill(res, idx, nums.length, -1);
    }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {7,4,3,9,1,8,5,2,6};
    s.getAverages(nums,3);
  }
}
