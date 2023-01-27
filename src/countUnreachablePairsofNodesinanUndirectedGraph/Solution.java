package countUnreachablePairsofNodesinanUndirectedGraph;

import java.util.*;
/*
99 ms solution, beat 40%
*/
public class Solution {
    public long countPairs(int n, int[][] edges) {
        boolean[] marks = new boolean[n];
        Map<Integer, List<Integer>> links = new HashMap<>();
        for (int[] edge : edges) {
            int p1 = edge[0];
            int p2 = edge[1];
            List<Integer> l1 = links.get(p1);
            if (l1==null ) {
                l1 = new ArrayList<>();
                links.put(p1, l1);
            }
            l1.add(p2);

            List<Integer> l2 = links.get(p2);
            if (l2==null ) {
                l2 = new ArrayList<>();
                links.put(p2, l2);
            }
            l2.add(p1);
        }
        long res = 0;
        for (int i=0; i<marks.length; i++) {
            if (!marks[i]) {
                int count = 0;
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                count++;
                marks[i]=true;
                while (!q.isEmpty()) {
                    int point = q.poll();
                    List<Integer> list = links.get(point);
                    if (list!= null) {
                        for(int v : list) {
                            if (!marks[v]) {
                                q.add(v);
                                count++;
                                marks[v]=true;
                            }
                        }
                    }
                }
                res += ((long)(n-count) * (long)count);
            }
        }
        return res/2;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] edges = {{1,0},{3,1},{0,4},{2,1}};
        s.countPairs(5, edges);
    }
}
