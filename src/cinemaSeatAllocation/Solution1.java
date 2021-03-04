package cinemaSeatAllocation;

import java.util.HashMap;
import java.util.Map;
/*
Runtime: 24 ms, faster than 63.07% of Java online submissions for Cinema Seat Allocation.
Memory Usage: 81.2 MB, less than 13.64% of Java online submissions for Cinema Seat Allocation.
 */
public class Solution1 {
  public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
    short case1 = (1 << 8) + (1<<7) + (1<<6) + (1<<5) + (1<<4) + (1<<3) + (1<<2) + (1<<1);
    short case2 = (1 << 8) + (1<<7) + (1<<6) + (1<<5);
    short case3 = (1<<6) + (1<<5) + (1<<4) + (1<<3);
    short case4 = (1<<4) + (1<<3) + (1<<2) + (1<<1);

    Map<Integer,Integer> map = new HashMap<>();
    for(int i=0; i<reservedSeats.length; i++){
      Integer v = map.get(reservedSeats[i][0]);
      if(v==null){
        v=(1<<reservedSeats[i][1]-1);
      }else{
        v+=(1<<reservedSeats[i][1]-1);
      }
      map.put(reservedSeats[i][0],v);
    }
    int cnt=0;
    for(int v : map.values()){
      if(v == 0 || (v & case1) == 0){
        cnt+=2;
      }else if ((v & case2) == 0 || (v & case3) == 0 || (v & case4) == 0){
        cnt+=1;
      }
    }
    cnt += ((n-map.size()) * 2);
    return cnt;
  }
}
