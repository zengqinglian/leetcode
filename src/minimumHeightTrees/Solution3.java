package minimumHeightTrees;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution3
{
    // improve solution2
    public List<Integer> findMinHeightTrees( int n, int[][] edges ) {
        List<Integer> result = new ArrayList<>();
        if( n == 1 ) {
            result.add( 0 );
            return result;
        }
        if( n == 2 ) {
            result.add( edges[0][0] );
            result.add( edges[0][1] );
            return result;
        }

        int[] array = new int[n];
        Set<Integer>[] setArray = new HashSet[n];

        for( int i = 0; i < n; i++ ) {
            setArray[i] = new HashSet<>();
        }

        for( int[] edge : edges ) {
            array[edge[0]] = array[edge[0]] + 1;
            array[edge[1]] = array[edge[1]] + 1;
            setArray[edge[0]].add( edge[1] );
            setArray[edge[1]].add( edge[0] );
        }

        int leaives = 0;
        Set<Integer> leavies = new HashSet<>();
        for( int i = 0; i < n; i++ ) {
            if( array[i] == 1 ) {
                leavies.add( i );
            }
        }

        if( n - leaives > 2 ) {
            while( true ) {
                Set<Integer> newLeavies = new HashSet<>();
                for( int i : leavies ) {
                    array[i] = 0;
                    leaives++;
                    for( int j : setArray[i] ) {
                        if( array[j] > 0 ) {
                            array[j] = array[j] - 1;
                            if( array[j] == 1 ) {
                                newLeavies.add( j );
                            }
                        }

                    }
                }
                if( n - leaives == 1 ) {
                    result.addAll( newLeavies );
                    break;
                }
                if( n - leaives == 2 ) {
                    break;
                }

                leavies = newLeavies;
            }
        }

        for( int i = 0; i < n; i++ ) {
            if( array[i] > 0 ) {
                result.add( i );
            }
        }

        return result;

    }

    public static void main( String[] args ) {
        // int[][] edges = { { 0, 1 }, { 1, 2 }, { 1, 3 }, { 2, 4 }, { 3, 5 }, { 4, 6 } };
        int[][] edges = { { 1, 0 }, { 1, 2 }, { 1, 3 } };
        // int[][] edges = { { 0, 1 }, { 0, 2 }, { 0, 3 }, { 3, 4 }, { 4, 5 } };
        Solution3 s = new Solution3();
        s.findMinHeightTrees( 4, edges );
    }
}
