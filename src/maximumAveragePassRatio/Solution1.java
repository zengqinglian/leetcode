package maximumAveragePassRatio;

import java.util.PriorityQueue;
/*
Runtime
432 ms
Beats
82.54%
Memory
86.1 MB
Beats
73.2%
 */
public class Solution1 {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<Node> q = new PriorityQueue<>((b, a)-> Double.compare(a.ranking, b.ranking));

        for (int[] clazz : classes) {
            q.add(new Node(clazz[0], clazz[1]));
        }

        for(int i=0; i<extraStudents; i++) {
            Node p = q.poll();
            q.add(new Node(p.a+1, p.b+1));
        }
        double sum = 0.0;
        while(!q.isEmpty()){
            Node p = q.poll();
            sum += p.pct;
        }
        return sum / classes.length;
    }

    private static class Node {
        private int a;
        private int b;
        private double pct;
        private double ranking;

        Node(int a, int b) {
            this.a = a;
            this.b = b;
            this.pct = 1.0*a/b;
            this.ranking = 1.0*(a+1)/(b+1) - 1.0*a/b;
        }
    }

}
