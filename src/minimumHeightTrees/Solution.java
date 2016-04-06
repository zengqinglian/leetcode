package minimumHeightTrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution
{
    public List<Integer> findMinHeightTrees( int n, int[][] edges ) {
        List<Integer> result = new ArrayList<>();

        Set<Integer> setResult = new HashSet<>();

        Map<Integer, Integer> structureMap = new HashMap<>();
        Set<Integer> leavies = new HashSet<>();
        for( int[] edge : edges ) {
            if( structureMap.containsKey( edge[0] ) ) {
                leavies.remove( edge[0] );
                int value = structureMap.get( edge[0] );
                structureMap.put( edge[0], value + 1 );
                if( value + 1 == n - 1 ) {
                    result.add( edge[0] );
                    return result;
                }
            } else {
                leavies.add( edge[0] );
                structureMap.put( edge[0], 1 );
            }
            if( structureMap.containsKey( edge[1] ) ) {
                leavies.remove( edge[1] );
                int value = structureMap.get( edge[1] );
                structureMap.put( edge[1], value + 1 );
                if( value + 1 == n - 1 ) {
                    result.add( edge[1] );
                    return result;
                }
            } else {
                leavies.add( edge[1] );
                structureMap.put( edge[1], 1 );
            }
        }

        // find longest chain
        List<List<Integer>> allRouteFromLeavies = new ArrayList<>();

        for( int leaf : leavies ) {
            getAllPossibleRoute( leaf, edges, new ArrayList<Integer>(), allRouteFromLeavies );
        }

        int maxLength = -1;
        for( List<Integer> li : allRouteFromLeavies ) {
            if( li.size() > maxLength ) {
                maxLength = li.size();
                setResult.clear();
                if( li.size() % 2 == 0 ) {
                    setResult.add( li.get( li.size() / 2 - 1 ) );
                    setResult.add( li.get( li.size() / 2 ) );
                } else {
                    setResult.add( li.get( li.size() / 2 ) );
                }
            } else if( li.size() == maxLength ) {
                if( li.size() % 2 == 0 ) {
                    setResult.add( li.get( li.size() / 2 - 1 ) );
                    setResult.add( li.get( li.size() / 2 ) );
                } else {
                    setResult.add( li.get( li.size() / 2 ) );
                }
            }

        }

        result.addAll( setResult );
        return result;

    }

    private void getAllPossibleRoute( int node, int[][] edges, List<Integer> temp, List<List<Integer>> result ) {
        if( temp.isEmpty() ) {
            temp.add( node );
        }
        boolean findEdge = false;
        for( int[] edge : edges ) {
            if( edge[0] == node ) {
                if( !temp.contains( edge[1] ) ) {
                    List<Integer> newTempIntegers = new ArrayList<>();
                    newTempIntegers.addAll( temp );
                    findEdge = true;
                    newTempIntegers.add( edge[1] );
                    getAllPossibleRoute( edge[1], edges, newTempIntegers, result );
                }
            } else if( edge[1] == node ) {
                if( !temp.contains( edge[0] ) ) {
                    List<Integer> newTempIntegers = new ArrayList<>();
                    newTempIntegers.addAll( temp );
                    findEdge = true;
                    newTempIntegers.add( edge[0] );
                    getAllPossibleRoute( edge[0], edges, newTempIntegers, result );
                }
            }
        }
        if( !findEdge ) {
            result.add( temp );
        }
    }

    public static void main( String[] args ) {
        int[][] edges = { { 0, 3 }, { 1, 3 }, { 2, 3 }, { 4, 3 }, { 5, 4 } };
        Solution s = new Solution();
        s.findMinHeightTrees( 6, edges );
    }
}
