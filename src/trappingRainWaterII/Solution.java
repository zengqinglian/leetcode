package trappingRainWaterII;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    // 1. start from most outside borders and put them in the queue. and Find
    // out min height element to process.
    // 2. BFS, find adjacent node of this min node. It is BFS, so all node will
    // be visited from outside to inside
    // 3. if any node smaller than current node, it can preserve water since the
    // select node has smallest height. make the node as vistied, add the node
    // to queue with height of current node height.
    // 4. if any node higher than current node, add it to the queue. make it as
    // vistied.
    public int trapRainWater(int[][] heightMap) {
        int h = heightMap.length;
        if (h < 2) {
            return 0;
        }

        int w = heightMap[0].length;
        if (w < 2) {
            return 0;
        }

        PriorityQueue<Node> minQueue = new PriorityQueue<>(20, new Comparator<Node>() {
            public int compare(Node a, Node b) {
                return a.height - b.height;
            }
        });

        boolean[][] visited = new boolean[h][w];
        // left and right
        for (int i = 0; i < h; i++) {
            Node a = new Node(i, 0, heightMap[i][0]);
            Node b = new Node(i, w - 1, heightMap[i][w - 1]);

            minQueue.offer(a);
            minQueue.offer(b);

            visited[i][0] = true;
            visited[i][w - 1] = true;
        }
        // top and bottom border
        for (int j = 0; j < w; j++) {
            Node a = new Node(0, j, heightMap[0][j]);
            Node b = new Node(h - 1, j, heightMap[h - 1][j]);

            minQueue.offer(a);
            minQueue.offer(b);

            visited[0][j] = true;
            visited[h - 1][j] = true;
        }

        int[] row = { -1, 1, 0, 0 };
        int[] col = { 0, 0, -1, 1 };

        int result = 0;

        while (!minQueue.isEmpty()) {
            Node curr = minQueue.poll();

            for (int i = 0; i < 4; i++) {
                int nextH = curr.h + row[i];
                int nextW = curr.w + col[i];

                if (nextH >= 0 && nextH < h && nextW >= 0 && nextW < w && !visited[nextH][nextW]) {
                    result += Math.max(0, curr.height - heightMap[nextH][nextW]);
                    int newHeight = Math.max(curr.height, heightMap[nextH][nextW]);
                    minQueue.offer(new Node(nextH, nextW, newHeight));
                    visited[nextH][nextW] = true;
                }
            }
        }

        return result;

    }

    private static class Node {
        private int h;
        private int w;
        private int height;

        public Node(int h, int w, int height) {
            this.h = h;
            this.w = w;
            this.height = height;
        }
    }

}
