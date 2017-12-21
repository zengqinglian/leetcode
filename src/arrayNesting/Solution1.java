package arrayNesting;

public class Solution1 {
  // improvement, no set needed. 35ms solution - beat 90%
  public int arrayNesting(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }

    if (nums.length == 1) {
      return 1;
    }

    boolean[] markers = new boolean[nums.length];

    int max = 0;

    for (int i = 0; i < nums.length; i++) {
      int index = i;
      int length = 0;
      while (!markers[i]) {
        index = nums[index];
        markers[index] = true;
        length++;
      }
      max = Math.max(max, length);
    }

    return max;
  }
}
