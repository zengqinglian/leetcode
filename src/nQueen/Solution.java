package nQueen;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<List<String>> solveNQueens( int n ) {
        List<List<String>> result = new ArrayList<>();
        if( n < 4 ) {
            if( n == 1 ) {
                List<String> li = new ArrayList<>();
                li.add( "Q" );
                result.add( li );
            }
            return result;
        }

        int[][] available = new int[n][n];
        getResult( available, result, 0, n );

        return result;
    }

    private void getResult( int[][] available, List<List<String>> result, int rowIndex, int n ) {
        if( rowIndex == n - 1 ) {
            for( int i = 0; i < n; i++ ) {
                if( available[rowIndex][i] == 0 ) {
                    available[rowIndex][i] = 1;
                    addResult( available, result, n );
                }
            }
        } else {
            boolean found = false;
            for( int i = 0; i < n; i++ ) {
                if( available[rowIndex][i] == 0 ) {
                    found = true;
                    int[][] newAvailable = getNewAvailable( available, rowIndex, i, n );
                    getResult( newAvailable, result, rowIndex + 1, n );
                }
            }
            if( !found ) {
                return;
            }
        }

    }

    private int[][] getNewAvailable( int[][] available, int rowIndex, int colIndex, int n ) {
        int[][] newArray = new int[n][n];
        for( int i = 0; i < n; i++ ) {
            for( int j = 0; j < n; j++ ) {
                if( i == rowIndex && j == colIndex ) {
                    newArray[i][j] = 1;
                } else if( i == rowIndex || j == colIndex ) {
                    newArray[i][j] = -1;
                } else if( Math.abs( i - rowIndex ) == Math.abs( j - colIndex ) ) {
                    newArray[i][j] = -1;
                } else {
                    newArray[i][j] = available[i][j];
                }
            }
        }

        return newArray;
    }

    private void addResult( int[][] available, List<List<String>> result, int n ) {
        List<String> li = new ArrayList<>();
        for( int i = 0; i < n; i++ ) {
            StringBuilder sb = new StringBuilder();
            for( int j = 0; j < n; j++ ) {
                if( available[i][j] == 1 ) {
                    sb.append( "Q" );
                } else {
                    sb.append( "." );
                }
            }

            li.add( sb.toString() );
        }
        result.add( li );
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        s.solveNQueens( 4 );
    }

}
