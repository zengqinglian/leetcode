package pathwithMaximumProbability;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Runtime: 32 ms, faster than 91.93% of Java online submissions for Path with Maximum Probability.
Memory Usage: 51.4 MB, less than 60.47% of Java online submissions for Path with Maximum Probability.
 */
public class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        if(start == end) {
            return 1d;
        }
        List<Node>[] list = new List[n];
        for(int i=0; i<edges.length; i++) {
            int[] edge = edges[i];
            if(list[edge[0]] == null){
                list[edge[0]] = new ArrayList<>();
            }
            Node n1 = new Node(edge[1], succProb[i]);
            list[edge[0]].add(n1);

            if(list[edge[1]] == null){
                list[edge[1]] = new ArrayList<>();
            }
            Node n2 = new Node(edge[0], succProb[i]);
            list[edge[1]].add(n2);
        }

        Queue<Node> q = new LinkedList<>();
        double[] visited = new double[n];
        Node startNode = new Node(start, 1);
        q.add(startNode);
        visited[start] = 1;
        double res = 0;
        while(!q.isEmpty()) {
            int len = q.size();
            for(int i=0;i<len; i++) {
                Node node = q.poll();
                List<Node> targets = list[node.point];
                if(targets!=null) {
                    for (Node targetNode : targets) {
                        double newProb = node.prob * targetNode.prob;
                        if(visited[targetNode.point]<newProb) {
                            if (targetNode.point == end) {
                                res = Math.max(newProb, res);
                            } else {
                                Node newNode = new Node(targetNode.point, newProb);
                                q.add(newNode);
                                visited[targetNode.point] = newProb;
                            }
                        }
                    }
                }
            }
        }

        return res;
    }

    private static class Node {
        private int point;
        private double prob;

        private Node(int point, double prob) {
            this.point = point;
            this.prob = prob;
        }
    }
}
