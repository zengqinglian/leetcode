package combinationSumIII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution
{
    public List<List<Integer>> combinationSum3( int k, int n ) {
        Set<Set<Integer>> setResult = new HashSet<>();
        int[] availables = new int[10];

        getCombinationsSum( k, n, new HashSet<Integer>(), setResult, availables );

        List<List<Integer>> result = new ArrayList<>();

        for( Set<Integer> set : setResult ) {
            List<Integer> li = new ArrayList<>( set );
            result.add( li );
        }
        return result;
    }

    private void getCombinationsSum( int k, int n, Set<Integer> temp, Set<Set<Integer>> result, int[] availables ) {
        int min = 0;
        int max = 0;

        Set<Integer> minSet = new HashSet<>();
        for( int i = 1, loop = k; i < 9 && loop > 0; i++ ) {
            if( availables[i] == 0 ) {
                min += i;
                minSet.add( i );
                loop--;
            }
        }

        Set<Integer> maxSet = new HashSet<>();
        for( int j = 9, loop = k; j >= 1 && loop > 0; j-- ) {
            if( availables[j] == 0 ) {
                max += j;
                maxSet.add( j );
                loop--;
            }
        }

        if( n < min || n > max ) {
            return;
        }

        if( n == min ) {
            temp.addAll( minSet );
            result.add( temp );
            return;
        }

        if( n == max ) {
            temp.addAll( maxSet );
            result.add( temp );
            return;
        }

        if( k == 1 ) {
            if( availables[n] == 0 ) {
                temp.add( n );
                result.add( temp );
            } else {
                return;
            }
        } else {
            for( int i = 1; i <= 9; i++ ) {
                if( availables[i] == 0 ) {
                    Set<Integer> newTemp = new HashSet<Integer>( temp );
                    newTemp.add( i );
                    int[] newAvailable = Arrays.copyOf( availables, 10 );
                    newAvailable[i] = -1;
                    getCombinationsSum( k - 1, n - i, newTemp, result, newAvailable );
                }
            }
        }
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        s.combinationSum3( 3, 9 );
    }
}
