package countNumberswithUniqueDigits;

public class Solution
{
    // math solution
    public int countNumbersWithUniqueDigits( int n ) {
        int total = 0;
        for( int i = 2; i <= n; i++ ) {
            total += countNumberWithNUniqueDigits( n, i ) * calculateCombinations( n, i );
        }

        return (int) Math.pow( 10, n ) - total;
    }

    private int countNumberWithNUniqueDigits( int totalDigits, int N ) {
        return 9 * (factoria( 9 ) / factoria( 9 - N ));
    }

    private int calculateCombinations( int totalDigits, int N ) {
        return factoria( totalDigits ) / (factoria( N ) * factoria( totalDigits - N ));
    }

    private int factoria( int n ) {
        if( n == 0 ) {
            return 1;
        }
        if( n == 1 ) {
            return 1;
        }

        return n * factoria( n - 1 );
    }

    public static void main( String[] args ) {

    }
}
