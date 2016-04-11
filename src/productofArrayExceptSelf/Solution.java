package productofArrayExceptSelf;

public class Solution
{

    public int[] productExceptSelf( int[] nums ) {
        int zeroCount = 0;
        int total = 1;
        int totalExclZero = 1;

        for( int i : nums ) {
            if( i != 0 ) {
                totalExclZero *= i;
            } else {
                zeroCount++;
            }
            total *= i;
        }
        if( zeroCount >= 2 ) {
            totalExclZero = 0;
        }
        int[] result = new int[nums.length];
        for( int i = 0; i < nums.length; i++ ) {
            if( nums[i] == 0 ) {
                result[i] = totalExclZero;
            } else {
                result[i] = total / nums[i];
            }
        }

        return result;
    }
}
