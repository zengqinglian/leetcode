package setMatrixZeroes;

public class Solution1
{
    // meet avg speed.
    public void setZeroes( int[][] matrix ) {
        int rows = matrix.length;
        if( rows == 0 ) {
            return;
        }
        int cols = matrix[0].length;
        if( cols == 0 ) {
            return;
        }

        int[] zeroRows = new int[rows];

        int[] zeroCols = new int[cols];

        if( rows == 1 && cols == 1 ) {
            return;

        } else {
            for( int i = 0; i < rows; i++ ) {
                for( int j = 0; j < cols; j++ ) {
                    if( matrix[i][j] == 0 ) {
                        zeroRows[i] = -1;
                        zeroCols[j] = -1;
                    }
                }
            }

            for( int i = 0; i < rows; i++ ) {
                for( int j = 0; j < cols; j++ ) {
                    if( zeroRows[i] == -1 || zeroCols[j] == -1 ) {
                        matrix[i][j] = 0;
                    }
                }
            }

        }
    }

    public static void main( String[] args ) {
        Solution1 s = new Solution1();
        int[][] matrix = { { 0, 0, 0, 5 }, { 4, 3, 1, 4 }, { 0, 1, 1, 4 }, { 1, 2, 1, 3 }, { 0, 0, 1, 1 } };
        s.setZeroes( matrix );
    }

}
