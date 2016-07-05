package validPerfectSquare;

public class Solution
{
    public boolean isPerfectSquare( int num ) {
        if( num == 0 || num == 1 ) {
            return true;
        }

        double result = Math.sqrt( num );

        if( Math.round( result ) == result ) {
            return true;
        }

        return false;
    }
}
