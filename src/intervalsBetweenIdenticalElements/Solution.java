package intervalsBetweenIdenticalElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*

56 / 61 test cases passed.
Time Limit over
 */
public class Solution {
  public long[] getDistances(int[] arr) {
    Map<Integer, List<int[]>> map = new HashMap<>();
    if(arr.length == 1) {
      long[] res = {0};
      return res;
    }
      int startIndex = 0;
      for (int i = 1; i < arr.length; i++) {
        if (arr[i] != arr[i - 1]) {
          List<int[]> list = map.get(arr[i - 1]);
          if (list == null) {
            list = new ArrayList<>();
            map.put(arr[i - 1], list);
          }
          int[] pos = {startIndex, i - 1};
          list.add(pos);
          startIndex = i;
        }
        if (i == arr.length - 1) {
          List<int[]> list = map.get(arr[i]);
          if (list == null) {
            list = new ArrayList<>();
            map.put(arr[i], list);
          }
          int[] pos = {startIndex, i};
          list.add(pos);
        }
      }

    long[] res = new long[arr.length];
    for(int i=0; i<arr.length; i++) {
      List<int[]> list = map.get(arr[i]);
      long sum = 0;
      for(int[] pos : list) {
        if(i<pos[0]) {
          long t = ((long)pos[0] + (long)pos[1]) * (long)(pos[1]-pos[0]+1) / 2L;
          sum+=(t - (long)i * (long)(pos[1]-pos[0]+1));
        }else if (pos[0]<= i && pos[1]>=i) {
          long t = ((long)pos[0] + i) * (long)(i-pos[0]+1) / 2L;
          sum+=( (long)i * (long)(i-pos[0]+1) -t);

          t = ((long)i + (long)pos[1]) * (long)(pos[1]-i+1) / 2L;
          sum+=(t-(long)i * (long)(pos[1]-i+1));
        }else{
          long t = ((long)pos[0] + (long)pos[1]) * (long)(pos[1]-pos[0]+1) / 2L;
          sum+=((long)i * (long)(pos[1]-pos[0]+1) - t);
        }
      }
      res[i] = sum;
    }
    return res;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] arr= {11266};
    s.getDistances(arr);
  }
}
