package intervalsBetweenIdenticalElements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/*
Runtime: 107 ms, faster than 72.18% of Java online submissions for Intervals Between Identical Elements.
Memory Usage: 180.9 MB, less than 72.54% of Java online submissions for Intervals Between Identical Elements.
 */
public class Solution2 {
  public long[] getDistances(int[] arr) {
    Map<Integer, List<Long>> map = new HashMap();
    long[] res = new long[arr.length];
    for(int i=0; i<arr.length; i++) {
      List<Long> list = map.get(arr[i]);
      if(list == null) {
        list = new ArrayList<>();
        list.add( (long)i);
        map.put(arr[i], list);
      }else {
        list.add(list.get(list.size()-1) + i);
      }
    }
    for(int key : map.keySet()) {
      List<Long> list = map.get(key);
      for(int i=0; i<list.size(); i++) {
        long v = 0L;
        int idx = (int)(i==0? list.get(i) : list.get(i)-list.get(i-1));
        if(i==0) {
          v += (list.get(list.size()-1) - (long)list.size() * (long)idx);
          res[idx] = v;
        }else if (i>0 && i<list.size()-1){
          v += ((long)idx * i - list.get(i-1));
          v+= (list.get(list.size()-1) - list.get(i) - (long)idx * (long)(list.size()-i-1));
          res[idx] = v;
        }else {
          v += ((long)idx * (long)(list.size()) - list.get(list.size()-1));
          res[idx] = v;
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Solution2 s = new Solution2();
    int[] arr= {2,1,3,1,2,3,3};
    s.getDistances(arr);
  }
}
