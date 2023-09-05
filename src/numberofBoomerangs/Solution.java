package numberofBoomerangs;

import java.util.HashMap;
import java.util.Map;
/*
Runtime
153 ms
Beats
29.11%
Memory
70 MB
Beats
5.16%
 */
public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        Map<Integer, Integer>[] maps = new Map[points.length];
        int res = 0;
        for(int i=0; i<points.length; i++) {
            int a1 = points[i][0];
            int b1 = points[i][1];
            if (maps[i] == null ) {
                maps[i] = new HashMap<>();
            }
            for(int j=i+1; j<points.length; j++) {
                int a2 = points[j][0];
                int b2 = points[j][1];
                int distance = (a1-a2) * (a1-a2) + (b1-b2) * (b1-b2);
                maps[i].put(distance, maps[i].getOrDefault(distance,0) + 1);
                if (maps[j] == null ) {
                    maps[j] = new HashMap<>();
                }
                maps[j].put(distance, maps[j].getOrDefault(distance,0) + 1);
            }
            for(int value : maps[i].values()) {
                if (value >=2) {
                    res += (value*value - value);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] points = {{0,0},{1,0},{2,0},{3,0},{2,1}};
        s.numberOfBoomerangs(points);
    }
}
