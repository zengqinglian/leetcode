package rangeFrequencyQueries;

import java.util.HashMap;
import java.util.Map;

/*
time over limits
15 / 20

 */
public class RangeFreqQuery1 {

  HashMap<Integer, Integer> map;
  HashMap<Integer, Integer>[] maps;
  int[] arr;
  public RangeFreqQuery1(int[] arr) {
    this.arr = arr;
    map = new HashMap<>();
    maps = new HashMap[arr.length];
    for(int i =0; i<arr.length; i++) {
      Integer cnt = map.get(arr[i]);
      if(cnt == null) {
        cnt =0;
      }
      map.put(arr[i], cnt+1);
      maps[i] = (HashMap<Integer, Integer>)map.clone();
    }
  }

  public int query(int left, int right, int value) {
    int cntLeft = maps[left].getOrDefault(value,0);
    int cntRight = maps[right].getOrDefault(value,0);
    int diff = cntRight - cntLeft;
    if(arr[left] == value) {
      return diff+1;
    }
    return diff;
  }

  /**
   * Your RangeFreqQuery object will be instantiated and called as such:
   * RangeFreqQuery obj = new RangeFreqQuery(arr);
   * int param_1 = obj.query(left,right,value);
   */
}
