package longestIncreasingPathinaMatrix;

public class Solution
{
    public int longestIncreasingPath( int[][] matrix ) {

        int sizeI = matrix.length;
        if( sizeI == 0 ) {
            return 0;
        }

        int sizeJ = matrix[0].length;

        int[][] result = new int[sizeI][sizeJ];

        for( int i = 0; i < sizeI; i++ ) {
            for( int j = 0; j < sizeJ; j++ ) {
                if( result[i][j] > 1 ) {
                    continue;
                } else {
                    result[i][j] = 1;
                    if( i + 1 <= sizeI - 1 && matrix[i + 1][j] > matrix[i][j] ) {
                        updateResultArray( 2, result, matrix, i + 1, j, sizeI, sizeJ );
                    }
                    if( i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j] ) {
                        updateResultArray( 2, result, matrix, i - 1, j, sizeI, sizeJ );
                    }
                    if( j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j] ) {
                        updateResultArray( 2, result, matrix, i, j - 1, sizeI, sizeJ );
                    }

                    if( j + 1 <= sizeJ - 1 && matrix[i][j + 1] > matrix[i][j] ) {
                        updateResultArray( 2, result, matrix, i, j + 1, sizeI, sizeJ );
                    }
                }
            }
        }

        int max = 0;
        for( int i = 0; i < sizeI; i++ ) {
            for( int j = 0; j < sizeJ; j++ ) {
                if( result[i][j] > max ) {
                    max = result[i][j];
                }

            }
        }
        return max;
    }

    private int updateResultArray( int currentLength, int[][] result, int[][] matrix, int startI, int startJ, int sizeI, int sizeJ ) {
        int max = currentLength;
        int temp =0;
        if( currentLength > result[startI][startJ] ) {
            result[startI][startJ] = currentLength;
            if( startI + 1 <= sizeI - 1 && matrix[startI + 1][startJ] > matrix[startI][startJ] ) {
                temp=updateResultArray( currentLength + 1, result, matrix, startI + 1, startJ, sizeI, sizeJ );
                max = max>=temp?max:temp;
            }
            if( startI - 1 >= 0 && matrix[startI - 1][startJ] > matrix[startI][startJ] ) {
                temp=updateResultArray( currentLength + 1, result, matrix, startI - 1, startJ, sizeI, sizeJ );
                max = max>=temp?max:temp;
            }
            if( startJ - 1 >= 0 && matrix[startI][startJ - 1] > matrix[startI][startJ] ) {
                temp=updateResultArray( currentLength + 1, result, matrix, startI, startJ - 1, sizeI, sizeJ );
                max = max>=temp?max:temp;
            }

            if( startJ + 1 <= sizeJ - 1 && matrix[startI][startJ + 1] > matrix[startI][startJ] ) {
                temp=updateResultArray( currentLength + 1, result, matrix, startI, startJ + 1, sizeI, sizeJ );
                max = max>=temp?max:temp;
            }
        }
        return max;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[][] matrix = { { 0 }, { 1 }, { 5 }, { 5 } };
        s.longestIncreasingPath( matrix );
    }
}
