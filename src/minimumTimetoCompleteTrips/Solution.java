package minimumTimetoCompleteTrips;

import java.util.HashMap;
import java.util.Map;
/*
binary search
Runtime: 1097 ms, faster than 5.00% of Java online submissions for Minimum Time to Complete Trips.
Memory Usage: 58.3 MB, less than 83.87% of Java online submissions for Minimum Time to Complete Trips.
 */
public class Solution {
  public long minimumTime(int[] times, int totalTrips) {
    Map<Integer, Integer> map = new HashMap<>();
    int min = Integer.MAX_VALUE;
    for(int time: times) {
      Integer v = map.get(time);
      if(v==null) {
        map.put(time, 1);
      }else{
        map.put(time, v+1);
      }
      min = Math.min(time, min);
    }
    if(totalTrips==1) {
      return min;
    }
    long s = 1L * min * (totalTrips / times.length);
    long e = 1L * min * (totalTrips / map.get(min) +1) ;
    while(s<e) {
      long m = (s+e) /2 ;
      long totalTripForm = 0;
      for(int key : map.keySet()) {
        totalTripForm += (m/key) * map.get(key) * 1L;
      }
      if(totalTripForm >= totalTrips) {
        e = m;
      }else{
        s = m+1;
      }
    }
    return s;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] time = {10000};
    s.minimumTime(time,10000000);
  }
}
