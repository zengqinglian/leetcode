package knightProbabilityinChessboard;

import java.util.LinkedList;
import java.util.Queue;

public class Solution1 {
  // over time limit
  public double knightProbability(int N, int K, int r, int c) {
    if (K == 0) {
      return 1;
    }

    Queue<int[]> q = new LinkedList<>();
    int[] start = {r, c, 0};
    q.add(start);

    int[] row = {2, 2, -2, -2, 1, -1, 1, -1};
    int[] col = {1, -1, 1, -1, 2, 2, -2, -2};
    int total = 0;

    while (!q.isEmpty()) {
      int[] point = q.poll();
      for (int i = 0; i < 8; i++) {
        if (point[0] + row[i] >= 0 && point[0] + row[i] <= N - 1 && point[1] + col[i] >= 0
            && point[1] + col[i] <= N - 1) {
          if (point[2] <= K - 2) {
            int[] newPoint = {point[0] + row[i], point[1] + col[i], point[2] + 1};
            q.add(newPoint);
          } else if (point[2] == K - 1) {
            total++;
          }

        }
      }
    }

    double all = Math.pow(8, K);
    return total / all;
  }

  public static void main(String[] args) {
    Solution1 s = new Solution1();
    System.out.print(s.knightProbability(3, 3, 0, 0));
  }
}
