package validTriangleNumber;

import java.util.Arrays;

public class Solution {
  // first solution beat 20% only
  public int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int result = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int m = nums.length - 1; m > j; m--) {
          if (nums[i] + nums[j] > nums[m]) {
            result += (m - j);
            break;
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {2, 2, 3, 4};
    s.triangleNumber(nums);
  }

}
