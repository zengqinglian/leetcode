package spiralMatrixII;

public class Solution
{
    public int[][] generateMatrix( int n ) {
        int[][] result = new int[n][n];
        if( n == 1 ) {
            result[0][0] = 1;
            return result;
        }

        int counter = 1;
        int i = 0, j = 0;
        int circle = 0;
        while( counter <= n * n ) {
            if( i == circle && j < n - 1 - circle ) {
                result[i][j] = counter;
                j++;
            } else if( i < n - circle - 1 && j == n - 1 - circle ) {
                result[i][j] = counter;
                i++;
            } else if( i == n - 1 - circle && j > circle ) {
                result[i][j] = counter;
                j--;
            } else if( i > circle && j == circle ) {
                result[i][j] = counter;
                i--;
            }

            if( i == circle && j == circle ) {
                i++;
                j++;
                circle++;
                if( counter == n * n - 1 ) {
                    result[i][j] = counter + 1;
                }
            }
            counter++;
        }

        return result;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        s.generateMatrix( 3 );
    }
}
