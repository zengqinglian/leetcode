package integerBreak;

public class Solution
{
    public int integerBreak( int n ) {
        if( n < 2 ) {
            return 0;
        }

        if( n == 2 ) {
            return 1;
        }

        if( n == 3 ) {
            return 2;
        }

        if( n == 4 ) {
            return 4;
        }

        int div = n / 3;
        int mod = n % 3;

        if( mod == 0 ) {
            return (int) Math.pow( 3, div );
        } else if( mod == 1 ) {
            return (int) Math.pow( 3, div - 1 ) * 4;
        } else {
            return (int) Math.pow( 3, div ) * 2;
        }

    }
}
