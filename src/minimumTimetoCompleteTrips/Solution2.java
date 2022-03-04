package minimumTimetoCompleteTrips;

import java.util.Arrays;

public class Solution2 {
  public long minimumTime(int[] time, int totalTrips) {
    // Binary search from time scale {1 to max(time[]*totalTrips)}
    Arrays.sort(time);
    int len = time.length;
    long left = 1, right = (long)time[len-1]*totalTrips;
    while(left < right){
      long mid = left + (right-left)/2;
      if(canMakeTrip(time, totalTrips, mid)){
        right = mid;
      }else{
        left = mid+1;
      }
    }
    return left;
  }
  private boolean canMakeTrip(int[] time, int tt, long ti){
    long trips = 0;
    for(int t : time){
      trips += ti/t;
    }
    return trips >= tt;
  }
}
