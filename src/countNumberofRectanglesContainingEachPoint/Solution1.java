package countNumberofRectanglesContainingEachPoint;

import java.util.*;
/*
Runtime: 711 ms, faster than 39.01% of Java online submissions for Count Number of Rectangles Containing Each Point.
Memory Usage: 122.3 MB, less than 18.26% of Java online submissions for Count Number of Rectangles Containing Each Point.
 */
public class Solution1 {
    public int[] countRectangles(int[][] rectangles, int[][] points) {
        List<Integer>[]  list = new List[101];
        for (int[] rec: rectangles) {
            List<Integer> li = list[rec[1]];
            if (li == null) {
                li = new ArrayList<>();
                list[rec[1]] = li;
            }
            li.add(rec[0]);
        }
        for(List<Integer> li : list) {
            if(li !=null)
                Collections.sort(li);
        }
        int[] res = new int[points.length];
        for(int i=0; i<points.length; i++) {
            int total =0;
            for(int j=points[i][1]; j<=100; j++) {
                if(list[j] == null) {
                    continue;
                }
                int v = Collections.binarySearch(list[j],points[i][0]);
                if (v>=0) {
                    total += (list[j].size()-v);
                }else{
                    total += (list[j].size()+1+v);
                }
            }
            res[i]=total;
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] rectangles = {{1,2},{2,3},{2,5}};
        int[][] points = {{2,1},{1,4}};
        Solution1 s = new Solution1();
        s.countRectangles(rectangles, points);
    }
}
