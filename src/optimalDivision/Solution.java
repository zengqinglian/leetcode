package optimalDivision;

public class Solution {
  // beat 60%. meet avg
  public String optimalDivision(int[] nums) {
    if (nums.length == 1) {
      return String.valueOf(nums[0]);
    }
    if (nums.length == 2) {
      return nums[0] + "/" + nums[1];
    } else {
      StringBuilder sb = new StringBuilder();
      sb.append(nums[0]);
      sb.append("/(");
      for (int i = 1; i < nums.length; i++) {
        sb.append(nums[i]);
        if (i < nums.length - 1) {
          sb.append("/");
        }
      }
      sb.append(")");
      return sb.toString();
    }

  }
}
