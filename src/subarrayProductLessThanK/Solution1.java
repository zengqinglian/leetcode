package subarrayProductLessThanK;

public class Solution1 {
  // O(N) solution 28ms meet avg speed. - 50%
  public int numSubarrayProductLessThanK(int[] nums, int k) {

    int result = 0;
    int startIndex = 0;
    int endIndex = startIndex + 1;
    int total = nums[startIndex];

    while (startIndex < nums.length && endIndex < nums.length) {
      if (nums[startIndex] >= k) {
        startIndex++;
        endIndex = startIndex + 1;
        total = nums[startIndex];
      } else {
        if (total >= k) {
          result += (endIndex - 1 - startIndex);
          total /= nums[startIndex];
          startIndex++;
        } else {
          total *= nums[endIndex];
          endIndex++;
        }
      }
    }

    while (total >= k && startIndex < nums.length) {
      result += (endIndex - 1 - startIndex);
      total /= nums[startIndex];
      startIndex++;
    }

    if (endIndex > startIndex) {
      long a = (endIndex - startIndex);
      long b = (endIndex - startIndex + 1);
      long s = a * b / 2;
      result += s;
    }

    return result;
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    int[] nums = {1, 2, 3};
    s.numSubarrayProductLessThanK(nums, 0);
  }
}
