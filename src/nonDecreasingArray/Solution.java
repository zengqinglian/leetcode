package nonDecreasingArray;

public class Solution {
  // solution beat 50%
  public boolean checkPossibility(int[] nums) {
    if (nums.length == 1) {
      return true;
    }
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < nums.length - 1; i++) {
      if (nums[i] > nums[i + 1]) {
        boolean res = checkNums(i, nums, max);
        if (res) {
          return true;
        }
        nums[i + 1] = nums[i];
        return checkNums(i, nums, nums[i]);
      } else {
        max = nums[i];
      }


    }
    return true;

  }

  private boolean checkNums(int i, int[] nums, int max) {
    int temp = nums[i];
    nums[i] = max;
    for (int m = i; m < nums.length - 1; m++) {
      if (nums[m] > nums[m + 1]) {
        nums[i] = temp;
        return false;
      }
    }
    nums[i] = temp;
    return true;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {3, 4, 2, 3};
    s.checkPossibility(nums);
  }

}
