package maxAreaofIsland;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  // bfs solution - no statistics show
  public int maxAreaOfIsland(int[][] grid) {
    if (grid == null) {
      return 0;
    }

    if (grid.length == 0) {
      return 0;
    }

    if (grid[0].length == 0) {
      return 0;
    }
    int max = 0;
    boolean[][] visited = new boolean[grid.length][grid[0].length];

    Queue<int[]> q = new LinkedList<>();

    int[] x = {1, -1, 0, 0};
    int[] y = {0, 0, 1, -1};

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1 && !visited[i][j]) {
          int[] node = {i, j};
          q.add(node);
          visited[i][j] = true;
        }
        int size = 0;
        while (!q.isEmpty()) {
          int[] node = q.poll();
          for (int m = 0; m < 4; m++) {
            if (node[0] + x[m] >= 0 && node[0] + x[m] <= grid.length - 1 && node[1] + y[m] >= 0
                && node[1] + y[m] <= grid[0].length - 1 && !visited[node[0] + x[m]][node[1] + y[m]]
                && grid[node[0] + x[m]][node[1] + y[m]] == 1) {
              int[] newNode = {node[0] + x[m], node[1] + y[m]};
              visited[node[0] + x[m]][node[1] + y[m]] = true;
              q.add(newNode);
            }
          }
          size++;
        }

        max = Math.max(size, max);
      }
    }
    return max;
  }

  public static void main(String[] args) {
    int[][] grid = { {1, 1, 0, 0, 0}, {1, 1, 0, 0, 0}, {0, 0, 0, 1, 1}, {0, 0, 0, 1, 1}};
    Solution s = new Solution();
    s.maxAreaOfIsland(grid);
  }
}
