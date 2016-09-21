package uniquePaths2;

public class Solution {
    // dp solution O(m*n)
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        if (m == 0) {
            return 0;
        }
        int n = obstacleGrid[0].length;
        if (n == 0) {
            return 0;
        }

        int[][] dp = new int[m][n];

        boolean hasBlock = false;
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                hasBlock = true;
            }
            if (!hasBlock) {
                dp[0][j] = 1;
            }
        }

        hasBlock = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                hasBlock = true;
            }
            if (!hasBlock) {
                dp[i][0] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] != 1) {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
