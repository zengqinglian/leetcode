package grayCode;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<Integer> grayCode( int n ) {

        List<Integer> result = new ArrayList<>();
        result.add( 0 );
        if( n == 0 ) {
            return result;
        }
        result.add( 1 );

        if( n == 1 ) {
            return result;
        }

        int loop = 1;
        while( loop < n ) {
            ;
            for( int j = result.size() - 1; j >= 0; j-- ) {
                result.add( (int) Math.pow( 2, loop ) + result.get( j ) );
            }
            loop++;
        }

        return result;
    }
}
