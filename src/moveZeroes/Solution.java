package moveZeroes;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public void moveZeroes( int[] nums ) {
        int loopIndex = 0;
        List<Integer> zeroIndexList = new ArrayList<>();
        int zeroIndex = 0;
        while( loopIndex < nums.length ) {
            if( nums[loopIndex] == 0 ) {
                zeroIndexList.add( loopIndex );
                loopIndex++;
            } else {
                if( !zeroIndexList.isEmpty() && zeroIndex <= zeroIndexList.size() - 1 ) {
                    nums[zeroIndexList.get( zeroIndex )] = nums[loopIndex];
                    nums[loopIndex] = 0;
                    zeroIndexList.add( loopIndex );
                    zeroIndex++;
                    loopIndex++;
                } else {
                    loopIndex++;
                }
            }
        }
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { 1 };
        s.moveZeroes( nums );
    }
}
