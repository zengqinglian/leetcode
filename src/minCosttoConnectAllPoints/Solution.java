package minCosttoConnectAllPoints;

import java.util.HashSet;
import java.util.Set;
/*
Overtime limit

71 / 72 test cases passed.
 */
public class Solution {
  public int minCostConnectPoints(int[][] points) {
    int res = 0;
    boolean[] checker = new boolean[points.length];
    checker[0] = true;
    int cnt = 1;
    while(cnt < points.length) {
      int dis = Integer.MAX_VALUE;
      int index = -1;
      for(int i=1; i<points.length; i++) {
        if(checker[i]) {
          continue;
        }
        for(int j=0; j<points.length; j++){
          if(!checker[j]){
            continue;
          }
          int d = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
          if(d<dis) {
            index = i;
            dis = d;
          }
        }
      }
      checker[index]=true;
      cnt++;
      res+=dis;
    }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[][] points =  {{0,0},{2,2},{3,10},{5,2},{7,0}};
    s.minCostConnectPoints(points);
  }
}
