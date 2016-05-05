package nQueensII;

public class Solution2
{
    public int totalNQueens( int n ) {
        int[] next = new int[n + 1]; // linked list of columns
        for( int i = 0; i < next.length; ++i ) {
            next[i] = i + 1;
        }
        boolean[] main = new boolean[2 * n - 1]; // attacked diagonals
        boolean[] counter = new boolean[2 * n - 1]; // attacked diagonals
        return totalNQueens( n, 1, next, main, counter );
    }

    private static int totalNQueens( int n, int i, int[] next, boolean[] main, boolean[] counter ) {
        if( i > n ) {
            return 1; // one way has been found
        } else {
            int ways = 0;
            for( int j = next[0], jp = 0; j <= n; jp = j, j = next[j] ) {
                int m = j - i + (n - 1); // main diagonal index starts at bottom-left
                int c = j + i - 2; // counter diagonal index starts at top-left
                if( !main[m] && !counter[c] ) {
                    next[jp] = next[j];
                    main[m] = true;
                    counter[c] = true;
                    ways += totalNQueens( n, i + 1, next, main, counter );
                    main[m] = false; // backtrack
                    counter[c] = false;
                    next[jp] = j;
                }
            }
            return ways;
        }
    }
}
