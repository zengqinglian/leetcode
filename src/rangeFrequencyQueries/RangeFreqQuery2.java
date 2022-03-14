package rangeFrequencyQueries;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class RangeFreqQuery2{
  Map<Integer, TreeMap<Integer, Integer>> map;
  Map<Integer, Integer> value;

  public RangeFreqQuery2(int[] arr) {
    map = new HashMap();
    value = new HashMap();

    int idx = 0;
    for(int i : arr) {
      value.put(i, value.getOrDefault(i, 0) + 1);
      map.computeIfAbsent(i, k -> new TreeMap()).put(idx, value.get(i));
      idx++;
    }
  }

  public int query(int left, int right, int value) {
    if(map.containsKey(value)) {
      Integer x = map.get(value).ceilingKey(left);
      Integer y = map.get(value).floorKey(right);
      if(x == null || y == null) return 0;
      return map.get(value).get(y) - map.get(value).get(x) + 1;
    }
    return 0;
  }

}
