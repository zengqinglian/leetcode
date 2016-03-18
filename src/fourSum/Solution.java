package fourSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//algo http://www.geeksforgeeks.org/print-all-possible-combinations-of-r-elements-in-a-given-array-of-size-n/
public class Solution
{
    public List<List<Integer>> fourSum( int[] nums, int target ) {
        Set<List<Integer>> result = new HashSet<>();
        Set<List<Integer>> tempresult = new HashSet<>();
        List<List<Integer>> ret = new ArrayList<>();
        Arrays.sort( nums );

        if( nums.length >= 4 ) {
            if( nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] + nums[nums.length - 4] < target ) {
                return ret;
            }
            List<Integer> temp = new ArrayList<>();
            getSum( nums, 0, target, temp, tempresult, result );
        }
        for( List<Integer> li : result ) {
            if( li.size() == 4 ) {
                ret.add( li );
            }
        }
        return ret;
    }

    private void getSum( int[] nums, int startIndex, int target, List<Integer> temp, Set<List<Integer>> tempresult,
            Set<List<Integer>> result ) {
        if( nums.length == 4 && nums[0] + nums[1] + nums[2] + nums[3] == target ) {
            List<Integer> li = new ArrayList<>();
            li.add( nums[0] );
            li.add( nums[1] );
            li.add( nums[2] );
            li.add( nums[3] );
            result.add( li );
            return;
        }
        if( temp.size() < 4 ) {
            for( int i = startIndex; i < nums.length; i++ ) {
                if( nums[i] <= target ) {
                    if( tempresult.contains( temp ) ) {
                        tempresult.remove( temp );
                    }
                    List<Integer> newList = new ArrayList<>( temp );
                    newList.add( nums[i] );
                    tempresult.add( newList );
                    if( nums[i] == target ) {
                        result.add( newList );
                    }
                    if( i + 1 <= nums.length - 1 ) {
                        getSum( nums, i + 1, target - nums[i], newList, tempresult, result );
                    }
                } else {
                    return;
                }
            }
        } else {
            return;
        }

    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { -493, -470, -464, -453, -451, -446, -445, -407, -406, -393, -328, -312, -307, -303, -259, -253, -252, -243,
                -221, -193, -126, -126, -122, -117, -106, -105, -101, -71, -20, -12, 3, 4, 20, 20, 54, 84, 98, 111, 148, 149, 152,
                171, 175, 176, 211, 218, 227, 331, 352, 389, 410, 420, 448, 485 };
        s.fourSum( nums, 1057 );
    }
}
