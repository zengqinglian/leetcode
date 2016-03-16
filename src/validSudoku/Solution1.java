package validSudoku;

import java.util.HashSet;
import java.util.Set;

public class Solution1
{
    public boolean isValidSudoku( char[][] board ) {
        Set<Character>[] rowSet = new Set[9];
        Set<Character>[] colSet = new Set[9];
        Set<Character>[] cellSet = new Set[9];

        for( int i = 0; i < 9; i++ ) {
            rowSet[i] = new HashSet<Character>();
            colSet[i] = new HashSet<Character>();
            cellSet[i] = new HashSet<Character>();
        }

        for( int i = 0; i < 9; i++ ) {
            for( int j = 0; j < 9; j++ ) {
                if( board[i][j] == '.' ) {
                    continue;
                } else {
                    if( !rowSet[i].add( board[i][j] ) ) {
                        return false;
                    }
                    if( !colSet[j].add( board[i][j] ) ) {
                        return false;
                    }
                    int cellIndex = 0;
                    if( j <= 2 ) {
                        if( i <= 2 ) {
                            cellIndex = 0;
                        } else if( i > 2 && i <= 5 ) {
                            cellIndex = 1;
                        } else {
                            cellIndex = 2;
                        }
                    } else if( j > 2 && j <= 5 ) {
                        if( i <= 2 ) {
                            cellIndex = 3;
                        } else if( i > 2 && i <= 5 ) {
                            cellIndex = 4;
                        } else {
                            cellIndex = 5;
                        }
                    } else {
                        if( i <= 2 ) {
                            cellIndex = 6;
                        } else if( i > 2 && i <= 5 ) {
                            cellIndex = 7;
                        } else {
                            cellIndex = 8;
                        }
                    }
                    if( !cellSet[cellIndex].add( board[i][j] ) ) {
                        return false;
                    }

                }

            }
        }
        return true;
    }

}
