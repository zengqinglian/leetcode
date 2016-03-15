package reverseInteger;

public class Solution
{
    public int reverse( int x ) {
        if( x > Integer.MAX_VALUE || x <= Integer.MIN_VALUE ) {
            return 0;
        }

        if( Math.abs( x ) < 10 ) {
            return x;
        }

        int original = Math.abs( x );
        int returnVal = 0;
        while( original > 0 ) {

            if( returnVal > Integer.MAX_VALUE / 10 || -returnVal < Integer.MIN_VALUE / 10 ) {
                return 0;
            }
            returnVal = returnVal * 10;

            if( returnVal > Integer.MAX_VALUE - (original % 10) || -returnVal < Integer.MIN_VALUE + (original % 10) ) {
                return 0;
            }

            returnVal = returnVal + (original % 10);

            original = original / 10;
        }

        return x >= 0 ? returnVal : -returnVal;
    }
}