package setMatrixZeroes;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    // bad structure - List
    public void setZeroes( int[][] matrix ) {
        int rows = matrix.length;
        if( rows == 0 ) {
            return;
        }
        int cols = matrix[0].length;
        if( cols == 0 ) {
            return;
        }

        List<Integer> zeroRows = new ArrayList<>();
        List<Integer> zeroCols = new ArrayList<>();

        if( rows == 1 && cols == 1 ) {
            return;

        } else {
            for( int i = 0; i < rows; i++ ) {
                for( int j = 0; j < cols; j++ ) {
                    if( matrix[i][j] == 0 ) {
                        zeroRows.add( i );
                        zeroCols.add( j );
                    }
                }
            }

            for( int i = 0; i < rows; i++ ) {
                if( zeroRows.contains( i ) ) {
                    for( int j = 0; j < cols; j++ ) {
                        matrix[i][j] = 0;
                    }
                } else {
                    for( int j = 0; j < cols; j++ ) {
                        if( zeroCols.contains( j ) ) {
                            matrix[i][j] = 0;
                        }
                    }
                }
            }

        }

    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[][] matrix = { { 0, 1 } };
        s.setZeroes( matrix );
    }
}
