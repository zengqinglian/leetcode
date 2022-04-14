package minimumOperationstoReduceXtoZero;
/* slide window solve mas length of subarray
Think in reverse; instead of finding the minimum prefix + suffix, find the maximum subarray.
* */

public class Solution2 {
  int maxSub = 0;

  public int minOperations(int[] nums, int x) {
    long sum = 0;
    for(int n : nums)
      sum += n;

    if(x == sum) return nums.length;

    long current = 0;
    int left = 0,right = 0;

    while(right < nums.length)
    {
      current += nums[right];

      while(current > sum - x && left <= right)
      {
        current -= nums[left];
        left++;
      }
      if(current == (sum - x))
        maxSub = Math.max(maxSub, right - left + 1);
      right++;
    }

    return maxSub != 0 ? nums.length - maxSub : -1;
  }
}
