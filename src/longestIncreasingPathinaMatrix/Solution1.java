package longestIncreasingPathinaMatrix;

public class Solution1
{
    // dfs is much quicker.
    int[][] pathLen;

    public int longestIncreasingPath( int[][] matrix ) {
        if( matrix == null || matrix.length == 0 ) {
            return 0;
        }
        int max = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        pathLen = new int[rows][cols];
        for( int i = 0; i < rows; ++i ) {
            for( int j = 0; j < cols; ++j ) {
                dfs( matrix, i, j, Integer.MIN_VALUE );
                max = max > pathLen[i][j] ? max : pathLen[i][j];
            }
        }

        return max;
    }

    private int dfs( int[][] matrix, int x, int y, int pre ) {
        if( x < 0 || x >= matrix.length || y < 0 || y >= matrix[0].length || matrix[x][y] <= pre ) {
            return 0;
        }
        if( pathLen[x][y] > 0 ) {
            return pathLen[x][y];
        }
        int max = 1;
        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };
        for( int i = 0; i < 4; ++i ) {
            int curX = x + dx[i];
            int curY = y + dy[i];
            int temp = dfs( matrix, curX, curY, matrix[x][y] ) + 1;
            max = max > temp ? max : temp;
        }
        pathLen[x][y] = max;
        return max;
    }

    public static void main( String[] args ) {
        Solution1 s = new Solution1();
        int[][] matrix = { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } };
        s.longestIncreasingPath( matrix );
    }
}
