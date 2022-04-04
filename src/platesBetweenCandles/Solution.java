package platesBetweenCandles;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;
/*
Runtime: 117 ms, faster than 22.76% of Java online submissions for Plates Between Candles.
Memory Usage: 141.6 MB, less than 57.81% of Java online submissions for Plates Between Candles.
 */
public class Solution {
  public int[] platesBetweenCandles(String s, int[][] queries) {
    Map<Integer, Integer> map = new HashMap<>();
    int plateCnt = 0;
    TreeSet<Integer> treeSet = new TreeSet<>();
    for(int i=0; i<s.length(); i++) {
      if(s.charAt(i) == '*') {
        plateCnt++;
      }else{
        treeSet.add(i);
        map.put(i, plateCnt);
      }
    }
    int[] res = new int[queries.length];
    for(int i=0; i<queries.length; i++) {
      int start = queries[i][0];
      int end = queries[i][1];
      Integer candleStart = treeSet.ceiling(start);
      Integer candleEnd = treeSet.floor(end);
      if(candleStart!=null && candleEnd!=null && candleStart < candleEnd) {
        res[i] = map.get(candleEnd) - map.get(candleStart);
      }
    }
    return res;
  }
}
