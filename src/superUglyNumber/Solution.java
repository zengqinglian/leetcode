package superUglyNumber;

public class Solution
{

    public int nthSuperUglyNumber( int n, int[] primes ) {
        if( n == 1 ) {
            return 1;
        }

        int len = primes.length;
        int[] ugly = new int[n], index = new int[len], factor = new int[len], mul = new int[len];

        for( int i = 0; i < len; i++ ) {
            index[i] = 0;
            factor[i] = primes[i];
            mul[i] = primes[i];
        }

        ugly[0] = 1;

        for( int i = 1; i < n; i++ ) {
            int min = Integer.MAX_VALUE;
            for( int j = 0; j < len; j++ ) {
                if( min > factor[j] )
                    min = factor[j];
            }
            ugly[i] = min;
            for( int j = 0; j < len; j++ ) {
                if( factor[j] == min )
                    factor[j] = mul[j] * ugly[++index[j]];
            }
        }
        return ugly[n - 1];
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] primes = { 2, 7, 13, 19 };
        s.nthSuperUglyNumber( 50, primes );
    }
}
