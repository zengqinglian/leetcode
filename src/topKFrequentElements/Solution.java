package topKFrequentElements;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution
{
    public List<Integer> topKFrequent( int[] nums, int k ) {
        List<Integer> result = new ArrayList<>( k );
        if( k == nums.length ) {
            for( int i : nums ) {
                result.add( i );
            }
            return result;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for( int i : nums ) {
            if( map.containsKey( i ) ) {
                map.put( i, map.get( i ) + 1 );
            } else {
                map.put( i, 1 );
            }
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>( nums.length,
                new ValueComparator<Integer, Integer>() );

        queue.addAll( map.entrySet() );

        int index = 0;
        while( index < k ) {
            result.add( queue.poll().getKey() );
            index++;
        }
        return result;
    }

    private static class ValueComparator<K, V extends Comparable<V>> implements Comparator<Map.Entry<K, V>>
    {
        @Override
        public int compare( Map.Entry<K, V> s1, Map.Entry<K, V> s2 ) {
            return -s1.getValue().compareTo( s2.getValue() );// desc order
        }
    }

    public static void main( String[] args ) {
        int[] nums = { 4, 1, -1, 2, -1, 2, 3 };
        Solution s = new Solution();
        s.topKFrequent( nums, 2 );
    }
}
