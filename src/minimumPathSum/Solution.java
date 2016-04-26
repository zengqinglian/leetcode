package minimumPathSum;

public class Solution
{
    public int minPathSum( int[][] grid ) {

        int n = grid[0].length;
        int m = grid.length;
        int[][] dp = new int[m][n];

        for( int i = 0; i < m; i++ ) {
            for( int j = 0; j < n; j++ ) {
                if( i == 0 && j == 0 ) {
                    dp[i][j] = grid[i][j];
                } else if( i == 0 && j != 0 ) {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                } else if( i != 0 && j == 0 ) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                } else {
                    dp[i][j] = Math.min( dp[i - 1][j] + grid[i][j], dp[i][j - 1] + grid[i][j] );
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main( String[] args ) {
        int[][] grid = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 } };
        Solution s = new Solution();
        s.minPathSum( grid );
    }
}
