package removeDuplicatesfromSortedArrayII;

public class Solution1
{
    // faster solution.
    public int removeDuplicates( int[] nums ) {
        if( nums.length <= 2 ) {
            return nums.length;
        }

        int total = 2;
        int loop = 2;
        int newIndex = 2;
        int[] newRet = new int[nums.length];
        newRet[0] = nums[0];
        newRet[1] = nums[1];
        while( loop < nums.length ) {
            if( nums[loop - 2] == nums[loop] ) {
                loop++;
            } else {
                newRet[newIndex] = nums[loop];
                total++;
                loop++;
                newIndex++;
            }
        }

        for( int i = 0; i < total; i++ ) {
            nums[i] = newRet[i];
        }
        return total;
    }

    public static void main( String[] args ) {
        Solution1 s = new Solution1();
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        s.removeDuplicates( nums );
    }
}
