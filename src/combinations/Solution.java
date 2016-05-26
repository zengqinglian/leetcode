package combinations;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<List<Integer>> combine( int n, int k ) {

        List<List<Integer>> result = new ArrayList<>();
        if( k > n ) {
            return result;
        } else if( k == n ) {
            List<Integer> list = new ArrayList<>();
            for( int i = 1; i <= n; i++ ) {
                list.add( i );
            }
            result.add( list );
        } else {
            getCombination( n, 1, k, new ArrayList<Integer>(), result );
        }

        return result;

    }

    private void getCombination( int n, int s, int k, List<Integer> temp, List<List<Integer>> result ) {
        if( n - s + 1 < k ) {
            return;
        } else {
            if( k == 1 ) {
                for( int i = s; i <= n; i++ ) {
                    List<Integer> list = new ArrayList<>( temp );
                    list.add( i );
                    result.add( list );
                }
            } else {
                for( int i = s; i <= n; i++ ) {
                    List<Integer> list = new ArrayList<>( temp );
                    list.add( i );
                    getCombination( n, i + 1, k - 1, list, result );
                }
            }
        }
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        s.combine( 4, 2 );
    }
}
