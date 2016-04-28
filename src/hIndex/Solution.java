package hIndex;

import java.util.Arrays;

public class Solution
{
    public int hIndex( int[] citations ) {
        if( citations.length == 0 ) {
            return 0;
        }
        Arrays.sort( citations );
        int result = 0;
        int currentIndex = 0;
        int loop = 0;

        while( loop <= citations.length && currentIndex < citations.length ) {

            if( loop > citations[currentIndex] ) {
                if( loop == citations.length - currentIndex - 1 ) {
                    result = Math.max( result, loop );
                }
                currentIndex++;
            } else if( loop == citations[currentIndex] ) {
                if( loop == citations.length - currentIndex ) {
                    result = Math.max( result, loop );
                }
                currentIndex++;
            } else {
                if( loop == citations.length - currentIndex ) {
                    result = Math.max( result, loop );
                }
                loop++;
            }
        }

        return result;
    }

    public static void main( String[] args ) {
        int[] citations = { 100 };
        Solution s = new Solution();
        s.hIndex( citations );
    }
}
