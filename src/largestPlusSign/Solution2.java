package largestPlusSign;
/*
Runtime
99ms
Beats
34.56%
Analyze Complexity
Memory
57.25MB
Beats
8.26%
 */
public class Solution2 {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] board = new int[n][n];
        for (int[] mine : mines) {
            board[mine[0]][mine[1]] = 1;
        }
        int[][][] dp = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    dp[i][j][0] = i -1 >=0 ? dp[i-1][j][0] + 1 : 1;
                    dp[i][j][2] = j -1 >=0 ? dp[i][j-1][2] + 1 : 1;

                }
                int bottomIndexI = n-i-1;
                int bottomIndexJ = n-j-1;
                if (board[bottomIndexI][bottomIndexJ] == 0) {
                    dp[bottomIndexI][bottomIndexJ][1] = bottomIndexI + 1 < n ? dp[bottomIndexI+1][bottomIndexJ][1] + 1 : 1;
                    dp[bottomIndexI][bottomIndexJ][3] = bottomIndexJ + 1 <n ? dp[bottomIndexI][bottomIndexJ+1][3] + 1 : 1;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int min = Math.min(dp[i][j][3], dp[i][j][0]);
                min = Math.min(min, dp[i][j][1]);
                min = Math.min(min, dp[i][j][2]);
                max = Math.max(max,min);
            }
        }
        return max;
    }
}
