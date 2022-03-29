package intervalsBetweenIdenticalElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution1 {
  public long[] getDistances(int[] arr) {
    Map<Integer, List<Integer>> map = new HashMap();
    long[] res = new long[arr.length];
    for(int i=0; i<arr.length; i++) {
      List<Integer> li = map.get(arr[i]);
      if(li == null) {
        li = new ArrayList<>();
        map.put(i, li);
      }else{
        long v = 0L;
        for(int idx : li) {
          long addon = (long)(i-idx);
          res[idx]+=addon;
          v += addon;
        }
        res[i] = v;
      }
      li.add(i);
    }
    return res;
  }
}
