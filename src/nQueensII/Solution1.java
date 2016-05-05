package nQueensII;

public class Solution1
{// someone's bit man soltion. - best one so far
    int sum = 0, upperlim = 1;

    public int totalNQueens( int n ) {
        upperlim = (upperlim << n) - 1;
        helper( 0, 0, 0 );
        return sum;
    }

    void helper( int row, int ld, int rd ) {
        if( row != upperlim ) {
            int pos = upperlim & ~(row | ld | rd);
            while( pos > 0 ) {
                int p = pos & -pos;

                pos -= p;

                helper( row + p, (ld + p) << 1, (rd + p) >> 1 );
            }
        } else {
            sum++;
        }
    }
}
