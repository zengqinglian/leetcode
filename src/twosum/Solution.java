package twosum;

import java.util.HashMap;

public class Solution
{
    public int[] twoSum( int[] nums, int target ) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for( int i = 0; i < nums.length; i++ ) {
            map.put( nums[i], i + 1 );
        }
        for( int i = 0; i < nums.length; i++ ) {
            if( map.containsKey( target - nums[i] ) && map.get( target - nums[i] ) > i + 1 )
                return new int[] { i + 1, map.get( target - nums[i] ) };
        }
        return new int[2];
    }
}
