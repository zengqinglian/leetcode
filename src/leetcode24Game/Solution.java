package leetcode24Game;

public class Solution {
  // solution pass but not good. need to considering using Fraction class in
  // common math
  public boolean judgePoint24(int[] nums) {
    double[] newNums = new double[nums.length];
    for (int i = 0; i < nums.length; i++) {
      newNums[i] = nums[i] * 1.0;
    }
    return check24(newNums, 0, nums.length - 1);
  }

  private boolean check24(double[] nums, int l, int r) {
    if (r - l == 1) {
      if (Math.abs(24 - (nums[l] + nums[r])) <= 0.00001
          || Math.abs(24 - (Math.abs(nums[l] - nums[r]))) <= 0.00001
          || (nums[r] != 0 && Math.abs(24 - (nums[l] / nums[r])) <= 0.00001)
          || (nums[l] != 0 && Math.abs(24 - (nums[r] / nums[l])) <= 0.00001)
          || Math.abs(24 - (nums[l] * nums[r])) <= 0.00001) {
        return true;
      }
      return false;
    } else {
      for (int j = l; j <= r; j++) {
        double swap = nums[l];
        nums[l] = nums[j];
        nums[j] = swap;
        for (int i = l + 1; i <= r; i++) {
          double temp = nums[i];
          double newNumPlus = nums[l] + nums[i];
          double newNumMinus = Math.abs(nums[l] - nums[i]);
          double newNumMulti = nums[l] * nums[i];
          boolean divCase1 = (nums[i] != 0);
          double divNum1 = -1d;
          if (divCase1) {
            divNum1 = nums[l] / nums[i];
          }
          boolean divCase2 = (nums[l] != 0);
          double divNum2 = -1;
          if (divCase2)
            divNum2 = nums[i] / nums[l];
          nums[i] = newNumPlus;
          if (check24(nums, l + 1, r)) {
            return true;
          }
          nums[i] = newNumMinus;
          if (check24(nums, l + 1, r)) {
            return true;
          }
          nums[i] = newNumMulti;
          if (check24(nums, l + 1, r)) {
            return true;
          }
          if (divCase1) {
            nums[i] = divNum1;
            if (check24(nums, l + 1, r)) {
              return true;
            }
          }

          if (divCase2) {
            nums[i] = divNum2;
            if (check24(nums, l + 1, r)) {
              return true;
            }
          }
          nums[i] = temp;
        }
        swap = nums[l];
        nums[l] = nums[j];
        nums[j] = swap;
      }
      return false;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] nums = {8, 3, 3, 8}; // 6 * (1-3/4)
    System.out.print(s.judgePoint24(nums));
  }
}
