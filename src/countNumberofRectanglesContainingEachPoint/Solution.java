package countNumberofRectanglesContainingEachPoint;

import java.util.Collection;
import java.util.TreeMap;
import java.util.TreeSet;
/*
39 / 47 test cases passed.  time over
 */
public class Solution {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<>();
        for (int[] rec : rectangles) {
            var set = map.get(rec[0]);
            if (set == null) {
                set = new TreeSet<>();
                map.put(rec[0], set);
            }
            set.add(rec[1]);
        }
        int[] res = new int[points.length];
        for(int i=0; i<res.length; i++) {
            int total = 0;
            Collection<TreeSet<Integer>> allValues = map.tailMap(points[i][0]).values();
            for (TreeSet<Integer> set : allValues) {
                total+=(set.tailSet(points[i][1]).size());
            }
            res[i] = total;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] rectangles = {{1,2},{2,3},{2,5}};
        int[][] points = {{2,1},{1,4}};
        Solution s = new Solution();
        s.countRectangles(rectangles, points);
    }
}
