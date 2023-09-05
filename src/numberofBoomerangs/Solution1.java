package numberofBoomerangs;

import java.util.HashMap;
/*
optimal solution
Runtime
51 ms
Beats
96.71%
Memory
43.6 MB
Beats
77%
 */
public class Solution1 {
    public int numberOfBoomerangs(int[][] points) {
        HashMap<Integer, Integer> map = new HashMap();
        int boomerangs = 0;
        for (int[] p1 : points) {
            for (int[] p2 : points)
                boomerangs += map.merge((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]), 1, Integer::sum) - 1;
            map.clear();
        }
        return boomerangs * 2;
    }
}
