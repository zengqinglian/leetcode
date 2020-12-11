package reduceArraySizetoTheHalf;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  //34ms solution, meet avg 50%
  public int minSetSize(int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for(int v : arr){
      Integer c = map.get(v);
      if (c==null){
        map.put(v,1);
      }else {
        map.put(v, c + 1);
      }
    }
    List<Integer> sorted = new ArrayList(map.values());
    Collections.sort(sorted);
    int total = arr.length;
    int sum = 0;
    for(int i=sorted.size()-1; i>=0;i--){
      sum+=sorted.get(i);
      if(sum * 2 >= total){
        return sorted.size() - i;
      }
    }
    return -1;
  }
}
