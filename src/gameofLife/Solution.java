package gameofLife;

public class Solution
{
    /*
     * case 1 01 -> 01 live<2 no change
     * 
     * 2 01 -> 11 live=2 or 3 changed!
     * 
     * 3 01 -> 01 live>3 no change
     * 
     * 4 00 -> 10 live=3 changed!
     */
    final int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 }, { 1, 1 }, { 1, -1 }, { -1, 1 }, { -1, -1 } };

    public void gameOfLife( int[][] board ) {
        if( board == null ) {
            return;
        }

        for( int i = 0; i < board.length; i++ ) {
            for( int j = 0; j < board[0].length; j++ ) {
                int live = getNumOfLiveNeighbors( board, i, j );
                if( (board[i][j] == 1 && (live == 2 || live == 3)) || (board[i][j] == 0 && live == 3) ) {
                    board[i][j] |= 2; // case 2, 4 has state change and can be combined by adding 1 in bit 1
                }
            }
        }

        for( int i = 0; i < board.length; i++ ) {
            for( int j = 0; j < board[0].length; j++ ) {
                board[i][j] >>= 1;
            }
        }
    }

    private int getNumOfLiveNeighbors( int[][] board, int row, int col ) {
        int live = 0;
        for( int[] direction : directions ) {
            int row1 = row + direction[0];
            int col1 = col + direction[1];
            if( row1 < 0 || row1 == board.length || col1 < 0 || col1 == board[0].length || (board[row1][col1] & 1) == 0 ) {
                continue; // check bit 0
            }
            live++;
        }
        return live;
    }
}
