package kthSmallestNumberinMultiplicationTable;


import java.util.PriorityQueue;

public class Solution {
  // use priority queue
  // Time over solution
  public int findKthNumber(int m, int n, int k) {
    if (k == 1 || k == m * n) {
      return k;
    }

    PriorityQueue<Node> queue;
    boolean[][] visited = new boolean[m + 1][n + 1];
    int counter = 0;

    if (k > (m * n) / 2) {
      queue = new PriorityQueue<Node>((x, y) -> {
        return y.val - x.val;
      });
      int bigK = m * n + 1 - k;
      queue.add(new Node(m, n, m * n));
      visited[m][n] = true;
      counter = 0;
      Node node = null;
      while (counter < bigK) {
        node = queue.poll();
        counter++;
        if (node.i - 1 >= 1 && !visited[node.i - 1][node.j]) {
          queue.add(new Node(node.i - 1, node.j, (node.i - 1) * node.j));
          visited[node.i - 1][node.j] = true;
        }

        if (node.j - 1 >= 1 && !visited[node.i][node.j - 1]) {
          queue.add(new Node(node.i, node.j - 1, (node.i) * (node.j - 1)));
          visited[node.i][node.j - 1] = true;
        }

      }
      return node.val;
    } else {
      queue = new PriorityQueue<Node>((x, y) -> {
        return x.val - y.val;
      });
      queue.add(new Node(1, 1, 1));
      visited[1][1] = true;
      counter = 0;
      Node node = null;
      while (counter < k) {
        node = queue.poll();
        counter++;
        if (node.i + 1 <= m && !visited[node.i + 1][node.j]) {
          queue.add(new Node(node.i + 1, node.j, (node.i + 1) * node.j));
          visited[node.i + 1][node.j] = true;
        }

        if (node.j + 1 <= n && !visited[node.i][node.j + 1]) {
          queue.add(new Node(node.i, node.j + 1, (node.i) * (node.j + 1)));
          visited[node.i][node.j + 1] = true;
        }
      }
      return node.val;
    }
  }

  public static void main(String[] args) {
    // 9895
    // 28405
    // 100787757
    Solution s = new Solution();
    s.findKthNumber(9895, 28405, 100787757);
  }

  private static class Node {
    private int i;
    private int j;
    private int val;

    public Node(int i, int j, int val) {
      this.i = i;
      this.j = j;
      this.val = val;
    }

    @Override
    public String toString() {
      return "Node [i=" + i + ", j=" + j + ", val=" + val + "]";
    }

  }
}
