package gameofLife;

public class Solution1
{
    // in order not to copy the board, we need 1 cell indicate two state. new state and old state.
    // 0 and 1 can use bit op
    // or we can use / or % normally . % is old state, / is the new state.
    // case 1 0/2 = 0 0%2=0
    // case 2 1/2=0 1%2=1
    // case 3 2/2 =1 2%2=0;
    // case 4 3/2=1 3%2=1
    final int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

    public void gameOfLife( int[][] board ) {
        if( board == null ) {
            return;
        }

        for( int i = 0; i < board.length; i++ ) {
            for( int j = 0; j < board[0].length; j++ ) {
                int live = getNumOfLiveNeighbors( board, i, j );
                if( (board[i][j] % 2) == 1 && live < 2 ) {
                    board[i][j] = 1;
                }
                if( ((board[i][j] % 2) == 1 && (live == 2 || live == 3)) ) {
                    board[i][j] = 3;
                }
                if( (board[i][j] % 2) == 0 && live == 3 ) {
                    board[i][j] = 2;
                }
            }
        }

        for( int i = 0; i < board.length; i++ ) {
            for( int j = 0; j < board[0].length; j++ ) {
                board[i][j] /= 2;
            }
        }
    }

    private int getNumOfLiveNeighbors( int[][] board, int row, int col ) {
        int live = 0;
        for( int[] direction : directions ) {
            int row1 = row + direction[0];
            int col1 = col + direction[1];
            if( row1 < 0 || row1 == board.length || col1 < 0 || col1 == board[0].length || (board[row1][col1] % 2) == 0 ) {
                continue; // check bit 0
            }
            live++;
        }
        return live;
    }
}
