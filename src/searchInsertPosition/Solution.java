package searchInsertPosition;

public class Solution
{
    public int searchInsert( int[] nums, int target ) {

        int length = nums.length;

        if( length == 1 ) {
            if( nums[0] == target ) {
                return 0;
            } else if( nums[0] > target ) {
                return 0;
            } else {
                return 1;
            }
        }

        if( nums[0] >= target ) {
            return 0;
        }

        if( nums[length - 1] == target ) {
            return length - 1;
        }

        if( nums[length - 1] < target ) {
            return length;
        }

        int searchStart = 0;
        int searchEnd = length - 1;
        while( searchStart < searchEnd ) {
            if( (searchEnd - searchStart) == 1 ) {
                if( nums[searchStart] == target ) {
                    return searchStart;
                } else {
                    return searchEnd;
                }
            } else {
                int mid = (searchEnd - searchStart) / 2;
                if( nums[searchStart + mid] == target ) {
                    return searchStart + mid;
                } else if( nums[searchStart + mid] > target ) {
                    searchEnd = searchStart + mid;
                } else {
                    searchStart = searchStart + mid;
                }
            }
        }
        return -1;
    }

    public static void main( String[] args ) {
        int[] nums = { 1, 3, 5, 7 };
        Solution s = new Solution();
        s.searchInsert( nums, 5 );
    }
}
