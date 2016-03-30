package bulbSwitcher;

import java.util.Arrays;

public class Solution
{
    public int bulbSwitch( int n ) {
        if( n == 0 ) {
            return 0;
        }
        if( n == 1 ) {
            return 1;
        }

        boolean[] result = new boolean[n + 1];
        Arrays.fill( result, true );
        int counter = 1;
        for( int i = 2; i <= n; i++ ) {
            int j = 1;
            while( i * j <= n ) {
                result[i * j] = !result[i * j];
                j++;
            }
            if( result[i] ) {
                counter++;
            }
        }
        System.out.print( counter );
        return counter;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        s.bulbSwitch( 10000000 );
    }
}
