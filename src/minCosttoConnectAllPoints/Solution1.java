package minCosttoConnectAllPoints;

public class Solution1 {
  public int minCostConnectPoints(int[][] points) {
    if(points.length==1){
      return 0;
    }
    boolean[] tracker_connect = new boolean[points.length];
    int res = 0;
    tracker_connect[0] = true;
    int dis = Integer.MAX_VALUE;
    int index = -1;
    for(int i=1;i<points.length; i++) {
      int d = Math.abs(points[0][0] - points[i][0]) + Math.abs(points[0][1] - points[i][1]);
      if(d<dis) {
        dis = d;
        index = i;
      }
    }
    res+=dis;
    tracker_connect[index] = true;
    dis = Integer.MAX_VALUE;
    index = -1;
    while(true) {
      for (int i = 0; i < points.length; i++) {
        if (!tracker_connect[i]) {
          for (int j = 0; j < tracker_connect.length; j++) {
            if (tracker_connect[j]) {
              int d = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
              if (d < dis) {
                dis = d;
                index = i;
              }
            }
          }
        }
      }
      if(index==-1){
        break;
      }
      tracker_connect[index] = true;
      res+=dis;
      index=-1;
      dis=Integer.MAX_VALUE;
    }
    return res;
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    int[][] points =  {{0,0},{2,2},{3,10},{5,2},{7,0}};
    s.minCostConnectPoints(points);
  }
}
