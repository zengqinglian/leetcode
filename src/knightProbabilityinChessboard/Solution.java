package knightProbabilityinChessboard;

public class Solution {
  // over time limit solution
  public double knightProbability(int N, int K, int r, int c) {
    if (K == 0) {
      return 1;
    }
    double total = Math.pow(8, K);

    return totolNumberStayOnBorad(N, K, r, c) / total;
  }

  private int totolNumberStayOnBorad(int N, int K, int r, int c) {
    int total = 0;
    if (K == 1) {
      if (r - 2 >= 0) {
        if (c - 1 >= 0) {
          total++;
        }
        if (c + 1 <= N - 1) {
          total++;
        }
      }
      if (c - 2 >= 0) {
        if (r - 1 >= 0) {
          total++;
        }
        if (r + 1 <= N - 1) {
          total++;
        }
      }
      if (r + 2 <= N - 1) {
        if (c - 1 >= 0) {
          total++;
        }
        if (c + 1 <= N - 1) {
          total++;
        }
      }
      if (c + 2 <= N - 1) {
        if (r - 1 >= 0) {
          total++;
        }
        if (r + 1 <= N - 1) {
          total++;
        }
      }
      return total;
    } else {
      if (r - 2 >= 0) {
        if (c - 1 >= 0) {
          total += totolNumberStayOnBorad(N, K - 1, r - 2, c - 1);
        }
        if (c + 1 <= N - 1) {
          total += totolNumberStayOnBorad(N, K - 1, r - 2, c + 1);
        }
      }
      if (c - 2 >= 0) {
        if (r - 1 >= 0) {
          total += totolNumberStayOnBorad(N, K - 1, c - 2, r - 1);
        }
        if (r + 1 <= N - 1) {
          total += totolNumberStayOnBorad(N, K - 1, c - 2, r + 1);
        }
      }
      if (r + 2 <= N - 1) {
        if (c - 1 >= 0) {
          total += totolNumberStayOnBorad(N, K - 1, r + 2, c - 1);
        }
        if (c + 1 <= N - 1) {
          total += totolNumberStayOnBorad(N, K - 1, r + 2, c + 1);
        }
      }
      if (c + 2 <= N - 1) {
        if (r - 1 >= 0) {
          total += totolNumberStayOnBorad(N, K - 1, c + 2, r - 1);
        }
        if (r + 1 <= N - 1) {
          total += totolNumberStayOnBorad(N, K - 1, c + 2, r + 1);
        }
      }
      return total;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.print(s.knightProbability(3, 2, 0, 0));
  }
}
