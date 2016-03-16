package validSudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution
{
    public boolean isValidSudoku( char[][] board ) {
        // check row
        int length = board[0].length;
        for( int i = 0; i < length; i++ ) {
            char[] row = new char[length];
            for( int j = 0; j < length; j++ ) {
                row[j] = board[j][i];
            }
            if( !checkRowOrColumn( row ) ) {
                return false;
            }
        }
        // check column
        for( int i = 0; i < length; i++ ) {
            char[] col = board[i];
            if( !checkRowOrColumn( col ) ) {
                return false;
            }
        }

        // check 3*3
        for( int i = 0; i < length; i = i + 3 ) {
            for( int j = 0; j < length; j = j + 3 ) {
                char[][] cell = new char[3][3];
                cell[0][0] = board[i][j];
                cell[0][1] = board[i][j + 1];
                cell[0][2] = board[i][j + 2];
                cell[1][0] = board[i + 1][j];
                cell[1][1] = board[i + 1][j + 1];
                cell[1][2] = board[i + 1][j + 2];
                cell[2][0] = board[i + 2][j];
                cell[2][1] = board[i + 2][j + 1];
                cell[2][2] = board[i + 2][j + 2];
                if( !check3x3Cell( cell ) ) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean checkRowOrColumn( char[] row ) {
        Set<Character> res = new HashSet<>();
        for( char c : row ) {
            if( c != '.' && !res.add( c ) ) {
                return false;
            }
        }
        return true;
    }

    private boolean check3x3Cell( char[][] cell ) {
        Set<Character> res = new HashSet<>();
        for( int i = 0; i < 3; i++ ) {
            for( int j = 0; j < 3; j++ ) {
                if( cell[i][j] != '.' && !res.add( cell[i][j] ) ) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main( String[] args ) {

        char[][] board = { { '.', '.', '4', '.', '.', '.', '6', '3', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '5', '.', '.', '.', '.', '.', '.', '9', '.' }, { '.', '.', '.', '5', '6', '.', '.', '.', '.' },
                { '4', '.', '3', '.', '.', '.', '.', '.', '1' }, { '.', '.', '.', '7', '.', '.', '.', '.', '.' },
                { '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '.', '.', '.', '.', '.', '.', '.' },
                { '8', '.', '.', '8', '.', '.', '.', '.', '.' } };
        Solution s = new Solution();
        s.isValidSudoku( board );
    }
}
