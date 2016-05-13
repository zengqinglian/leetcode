package permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<List<Integer>> permute( int[] nums ) {
        List<List<Integer>> result = new ArrayList<>();
        getPermute( nums, new ArrayList<Integer>(), result );
        return result;

    }

    private void getPermute( int[] nums, List<Integer> temp, List<List<Integer>> result ) {
        if( nums.length == 1 ) {
            temp.add( nums[0] );
            result.add( temp );
            return;
        }

        for( int i : nums ) {
            List<Integer> newTemp = new ArrayList<>( temp );
            newTemp.add( i );
            int[] newNums = removeI( nums, i );
            getPermute( newNums, newTemp, result );
        }
    }

    private int[] removeI( int[] nums, int i ) {
        int[] newNums = new int[nums.length - 1];
        int index = 0;
        for( int n : nums ) {
            if( n != i ) {
                newNums[index] = n;
                index++;
            }
        }

        return newNums;
    }

}
