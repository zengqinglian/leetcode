package countofRangeSum;

import java.util.Arrays;

public class Solution1
{
    // merge sort
    public int countRangeSum( int[] nums, int lower, int upper ) {
        int length = nums.length;
        long[] sums = new long[length + 1];
        for( int i = 0; i < length; i++ ) {
            sums[i + 1] = sums[i] + nums[i];
        }// the sum i to j will be sum[j] - sum[i]

        int a = mergeSort( sums, lower, upper, 0, length + 1 );
        return a;
    }

    private int mergeSort( long[] sums, int lower, int upper, int low, int high ) {
        if( high - low <= 1 )
            return 0;
        int mid = (low + high) / 2;
        int m = mid, n = mid;
        int count = 0;
        count = mergeSort( sums, lower, upper, low, mid ) + mergeSort( sums, lower, upper, mid, high );
        // the two half will be sorted after this step. low to mid sorted, mid - high sorted

        for( int i = low; i < mid; i++ ) { // first half
            while( m < high && sums[m] - sums[i] < lower )
                m++;
            while( n < high && sums[n] - sums[i] <= upper )
                n++;
            count += n - m;
        }
        Arrays.sort( sums, low, high );// use merge sort
        return count;

    }

    public static void main( String[] args ) {
        Solution1 s = new Solution1();
        int[] nums = { -2, 5, -1 };
        s.countRangeSum( nums, -2, 2 );
    }
}
