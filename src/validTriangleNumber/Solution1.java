package validTriangleNumber;

import java.util.Arrays;

public class Solution1 {
  public int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int result = 0;
    for (int i = 0; i < nums.length - 2; i++) {
      int s = i + 1;
      for (int j = i + 1; j < nums.length - 1; j++) {
        for (int m = s + 1; m <= nums.length - 1 && nums[i] + nums[j] > nums[m]; m++) {
          s = m;
        }
        /*
         * for (int m = s + 1; m <= nums.length - 1 ; m++) { // this is much slower if move if
         * inside the for. Why if(nums[i] + nums[j] > nums[m]){ s = m; } }
         */
        result += (s - j);
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    int[] nums = {2, 2, 3, 4};
    s.triangleNumber(nums);
  }

}
