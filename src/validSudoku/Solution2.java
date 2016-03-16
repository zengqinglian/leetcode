package validSudoku;

public class Solution2
{
    // Best solution from leetcode.
    public boolean isValidSudoku( char[][] board ) {
        boolean[][] rowValid = new boolean[9][9];
        boolean[][] colValid = new boolean[9][9];
        boolean[][] subValid = new boolean[9][9];

        for( int i = 0; i < 9; i++ ) {
            for( int j = 0; j < 9; j++ ) {
                if( board[i][j] == '.' ) {
                    continue;
                }

                int index = board[i][j] - '1';
                if( rowValid[i][index] || colValid[j][index] || subValid[(i / 3) * 3 + j / 3][index] ) {
                    return false;
                }

                rowValid[i][index] = colValid[j][index] = subValid[(i / 3) * 3 + j / 3][index] = true;
            }
        }

        return true;
    }
}
