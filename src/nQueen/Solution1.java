package nQueen;

import java.util.ArrayList;
import java.util.List;

public class Solution1
{
    // back tracking solution
    // Core idea: greedy + backtracking.
    //
    // A little bit more words:
    //
    // Put Q in the board column after column starting from the first column (col=1)
    // Check if it is safe to put Q at current location (row, col)
    // If safe, put Q at (row, col) (greedy part) and move to next column and check if safe
    // If no row in next column is safe, meaning we can not put Q at (row, col), so remove Q (backtracking part) and continue, i.e.,
    // check (row+1, col) if row<N or remove Q at previous column, etc.
    // If col gets to N, meaning we are done filling all N queens. In this case, add board into res. And return false so that it
    // will backtrack as illustrated in the last step.
    // keep running till exhausted, i.e., backtracked to last row, first column
    // Code in Java:
    public List<List<String>> solveNQueens( int N ) {
        List<List<String>> res = new ArrayList<List<String>>();
        if( N < 1 )
            return res;
        char[][] board = new char[N][N];
        for( char[] row : board ) {
            for( int j = 0; j < N; j++ ) {
                row[j] = '.';
            }
        }
        solve( board, N, 0, res );
        return res;
    }

    private boolean solve( char[][] board, int N, int col, List<List<String>> res ) {
        if( col == N ) { // done soving, simply add the board into the result
            List<String> list = new ArrayList<String>();
            for( int i = 0; i < N; i++ ) {
                list.add( String.valueOf( board[i] ) );
            }
            res.add( list );
            return false; // return false so will backtrack
        }
        for( int i = 0; i < N; i++ ) {
            if( isSafe( board, N, i, col ) ) {
                board[i][col] = 'Q'; // greedy
                if( solve( board, N, col + 1, res ) )
                    return true;
                else
                    board[i][col] = '.'; // backtrack
            }
        }
        return false;
    }

    private boolean isSafe( char[][] board, int N, int row, int col ) {
        for( int i = 0; i < N; i++ ) {
            if( board[i][col] != '.' )
                return false;
            if( board[row][i] != '.' )
                return false;
        }
        int step = 1;
        while( row - step >= 0 && col - step >= 0 )
            if( board[row - step][col - step++] != '.' )
                return false;
        step = 1;
        while( row + step < N && col - step >= 0 )
            if( board[row + step][col - step++] != '.' )
                return false;
        return true;
    }
}
