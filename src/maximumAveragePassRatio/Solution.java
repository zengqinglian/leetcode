package maximumAveragePassRatio;

import java.util.PriorityQueue;
/*
Runtime
722 ms
Beats
11.11%
Memory
74.3 MB
Beats
100%
 */
public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> q = new PriorityQueue<>((b,a)->{
            return Double.compare((1.0*a[0]+1)/(1.0*a[1]+1) - (1.0*a[0])/(1.0*a[1]), (1.0*b[0]+1)/(1.0*b[1]+1) - (1.0*b[0])/(1.0*b[1]));
        });

        for (int[] clazz : classes) {
            q.add(clazz);
        }

        for(int i=0; i<extraStudents; i++) {
            int[] p = q.poll();
            p[0] = p[0]+1;
            p[1] = p[1] + 1;
            q.add(p);
        }
        double sum = 0.0;
        while(!q.isEmpty()){
            int[] p = q.poll();
            sum += ((1.0*p[0])/(1.0*p[1]));
        }
        return sum / classes.length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] classes = {{2,4},{3,9},{4,5},{2,10}};
        s.maxAverageRatio(classes, 4);
    }
}
