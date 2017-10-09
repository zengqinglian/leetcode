package maximumSumof3NonOverlappingSubarrays;

public class Solution {
  // time over limit solution - die on test case 19
  private int totalMax = -1;
  private int[] ret = new int[3];

  public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
    if (3 * k == nums.length) {
      int[] result = new int[3];
      result[0] = 0;
      result[1] = k;
      result[2] = 2 * k;
      return result;
    }

    int[] sums = new int[nums.length - k + 1];

    for (int i = 0; i < sums.length; i++) {
      for (int j = 0; j < k; j++) {
        sums[i] += nums[i + j];
      }
    }
    int[] result = new int[3];
    getSum(sums, 3, k, 0, result, 0);

    return ret;
  }

  private int getSum(int[] sums, int n, int k, int start, int[] result, int sum) {
    if (n == 1) {
      int max = sums[start];
      int index = start;
      for (int i = start + 1; i < sums.length; i++) {
        if (max < sums[i]) {
          max = sums[i];
          index = i;
        }
      }
      result[3 - n] = index;
      if (sum + max > totalMax) {
        totalMax = sum + max;
        ret[0] = result[0];
        ret[1] = result[1];
        ret[2] = result[2];
      }
      return sum + max;
    } else {
      int max = -1;
      int index = -1;
      for (int i = start; sums.length > (n - 1) * k + i; i++) {
        int tp = result[3 - n];
        result[3 - n] = i;
        int temp = getSum(sums, n - 1, k, i + k, result, sum + sums[i]);
        if (temp > max) {
          max = temp;
          index = i;
        }
        result[3 - n] = tp;
      }
      result[3 - n] = index;
      return sum + max;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {1, 2, 1, 2, 6, 7, 5, 1};
    System.out.print(s.maxSumOfThreeSubarrays(nums, 2));
  }
}
