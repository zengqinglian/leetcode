package findUnsortedSubarray;

public class Solution {
  // Solution beat 90%
  public int findUnsortedSubarray(int[] nums) {
    if (nums == null || nums.length == 1) {
      return 0;
    }

    int startIndex = 0;
    int endIndex = 0;
    int Max = 0;

    for (int i = 1; i < nums.length; i++) {
      if (nums[i - 1] > nums[i]) {
        startIndex = i - 1;
        endIndex = i;
        Max = nums[i - 1];
        break;
      }
    }

    if (startIndex == endIndex) {
      return 0;
    }

    for (int i = endIndex; i < nums.length; i++) {
      if (nums[i] < nums[startIndex]) {
        startIndex = findStart(nums, startIndex, nums[i]);
        endIndex = i;
      } else if (nums[i] < Max) {
        endIndex = i;
      } else {
        Max = nums[i];
      }
    }


    return endIndex - startIndex + 1;
  }

  private int findStart(int[] nums, int startIndex, int target) {
    for (int i = startIndex - 1; i >= 0; i--) {
      if (nums[i] <= target) {
        return i + 1;
      }
    }
    return 0;
  }
}
