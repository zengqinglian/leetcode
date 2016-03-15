package divideTwoIntegers;

public class Solution
{
    public int divide( int dividend, int divisor ) {
        if( divisor == 0 ) {
            return Integer.MAX_VALUE;
        }
        if( dividend == 0 ) {
            return 0;
        }
        if( divisor == 1 ) {
            return dividend;
        }
        if( divisor == -1 ) {
            return -dividend;
        }
        long absdividend = Math.abs( dividend );
        long absdivisor = Math.abs( divisor );

        if( absdividend < absdivisor ) {
            return 0;
        }
        if( absdividend == absdivisor ) {
            if( (dividend > 0 && dividend > 0) || (dividend < 0 && dividend < 0) )
                return 1;
            else
                return -1;
        }

        long remain = absdividend;
        int result = 0;
        while( remain >= absdivisor ) {
            remain = remain - absdivisor;
            result++;
        }

        if( (dividend > 0 && dividend > 0) || (dividend < 0 && dividend < 0) )
            return result;
        else
            return -result;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        System.out.print( s.divide( 2147483647, 3 ) );
    }

}