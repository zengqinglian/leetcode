package magneticForceBetweenTwoBalls;

import java.util.Arrays;
/*
Runtime: 42 ms, faster than 86.93% of Java online submissions for Magnetic Force Between Two Balls.
Memory Usage: 54.2 MB, less than 67.74% of Java online submissions for Magnetic Force Between Two Balls.

solution looked hint1
 */
public class Solution {
  public int maxDistance(int[] position, int m) {
    Arrays.sort(position);
    if(m == 2) {
      return position[position.length-1] - position[0];
    }
    int min = 1;
    int max = position[position.length-1] - position[0];
    while(min<=max) {
      int mid = (max + min) / 2 ;
      int pre=position[0];
      int count = 0;
      for(int i = 1; i<position.length; i++) {
        int diff = position[i] - pre;
        if(diff > mid) {
          count++;
          pre= position[i];
        }
      }
      if(count+1>=m){
        min = mid+1;
      }else{
        max = mid-1;
      }
    }
    return min;
  }

  public static void main(String[] args) {
    Solution s= new Solution();
    int[] arr = {1,2,3,4,5,6,7,8,9,10};
    s.maxDistance(arr, 4);
  }
}
