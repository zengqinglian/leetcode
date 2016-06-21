package slidingWindowMaximum;

import java.util.Deque;
import java.util.LinkedList;

public class Solution
{
    public int[] maxSlidingWindow( int[] nums, int k ) {
        if( nums == null || nums.length == 0 ) {
            return new int[0];
        }
        if( nums.length == 1 ) {
            return nums;
        }
        int length = nums.length;
        int retLen = length - k + 1;

        Deque<Integer> deque = new LinkedList<>();

        int[] ret = new int[retLen];

        for( int i = 0; i < length; i++ ) {
            while( !deque.isEmpty() && nums[i] > deque.peekLast() ) {
                deque.pollLast();
            }
            deque.offerLast( nums[i] );
            if( i >= k - 1 ) {
                ret[i - k + 1] = deque.peekFirst();
                if( nums[i - k + 1] == deque.peekFirst() ) {//
                    deque.pollFirst();
                }
            }
        }
        return ret;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        s.maxSlidingWindow( nums, 3 );
    }
}
