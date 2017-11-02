package subarrayProductLessThanK;

public class Solution {
  // O(N*N) solution - over time limit, failed on 79/84 test case
  public int numSubarrayProductLessThanK(int[] nums, int k) {
    int result = 0;

    for (int i = 0; i < nums.length; i++) {
      int total = nums[i];
      if (nums[i] < k) {
        result++;
        for (int j = i + 1; j < nums.length; j++) {
          total *= nums[j];
          if (total < k) {
            result++;
          } else {
            break;
          }
          if (j == nums.length - 1) {
            long a = 1 + j - i;
            long b = j - i;
            long temp = a * b / 2;
            result += (int) temp;
            return result;
          }
        }
      }
    }

    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {1, 1, 1};
    s.numSubarrayProductLessThanK(nums, 0);
  }

}
