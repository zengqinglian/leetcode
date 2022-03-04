package minimumTimetoCompleteTrips;

import java.util.HashMap;
import java.util.Map;
/*
time over limite
62/122
 */
public class Solution1 {
  public long minimumTime(int[] times, int totalTrips) {
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> counterMap = new HashMap<>();
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
    long s = 1L * min * (totalTrips / times.length);
    for(int key : map.keySet()) {
      counterMap.put(key, (int)(s / key));
    }
    while(true) {
      long tripCount = 0;
      int target = 0;
      long time = Long.MAX_VALUE;
      for(int key : counterMap.keySet()) {
        long t = 1l * key * counterMap.get(key);
        if(t<time){
          target = key;
          time = t;
        }
      }

      for(int key : map.keySet()) {
        tripCount += (time / key * map.get(key));
      }
      if(tripCount >= totalTrips) {
        return time;
      }
      counterMap.put(target, counterMap.get(target)+1);
    }
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    int[] time = {10000};
    s.minimumTime(time,10000000);
  }
}
