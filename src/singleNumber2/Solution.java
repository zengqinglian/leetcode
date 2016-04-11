package singleNumber2;

import java.util.HashSet;
import java.util.Set;

public class Solution
{
    public int singleNumber( int[] nums ) {
        Set<Integer> resultSet = new HashSet<>( (nums.length + 2) / 3 );
        long realSum = 0;
        long uniqueNumSum = 0;
        for( int i : nums ) {
            realSum += i;
            if( !resultSet.contains( i ) ) {
                resultSet.add( i );
                uniqueNumSum += i;
            }
        }

        int ret = (int) ((uniqueNumSum * 3 - realSum) / 2);
        return ret;
    }

    public static void main( String[] args ) {
        int[] nums = { 43, 16, 45, 89, 45, -2147483648, 45, 2147483646, -2147483647, -2147483648, 43, 2147483647, -2147483646,
                -2147483648, 89, -2147483646, 89, -2147483646, -2147483647, 2147483646, -2147483647, 16, 16, 2147483646, 43 };

        Solution s = new Solution();
        s.singleNumber( nums );
    }
}
