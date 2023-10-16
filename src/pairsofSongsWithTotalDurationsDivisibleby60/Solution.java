package pairsofSongsWithTotalDurationsDivisibleby60;

import java.util.HashMap;
import java.util.Map;
/*
Runtime
16 ms
Beats
42.6%
Memory
49.8 MB
Beats
72.63%
 */
public class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int t : time) {
            int mod = t % 60;
            if (mod == 0) {
                Integer v = map.get(0);
                if (v == null) {
                    map.put(0,1);
                }else{
                    count += v;
                    map.put(0,v+1);
                }
            }else {
                Integer v = map.get(60 - mod);
                if (v != null) {
                    count += v;
                }
                Integer countV = map.get(mod);
                if (countV == null) {
                    map.put(mod, 1);
                } else {
                    map.put(mod, 1 + countV);
                }
            }
        }
        return count;
    }
}
