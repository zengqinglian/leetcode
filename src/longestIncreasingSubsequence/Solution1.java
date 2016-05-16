package longestIncreasingSubsequence;

import java.util.TreeSet;

public class Solution1
{
    // O(nlogn) solution
    // explain -- http://stackoverflow.com/questions/6129682/longest-increasing-subsequenceonlogn
    // http://en.wikipedia.org/wiki/Patience_sorting
    // http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/

    // We need to maintain lists of increasing sequences.
    //
    // In general, we have set of active lists of varying length. We are adding an element A[i] to these lists. We scan the lists
    // (for end elements) in decreasing order of their length. We will verify the end elements of all the lists to find a list whose
    // end element is smaller than A[i] (floor value).
    //
    // Our strategy determined by the following conditions,
    // 1. If A[i] is smallest among all end candidates of active lists, we will start new active list of length 1.
    // 2. If A[i] is largest among all end candidates of active lists, we will clone the largest active list, and extend it by A[i].
    // 3. If A[i] is in between, we will find a list with largest end element that is smaller than A[i]. Clone and extend this list
    // by A[i]. We will discard all other lists of same length as that of this modified list.
    //
    // Note that at any instance during our construction of active lists, the following condition is maintained.
    //
    // “end element of smaller list is smaller than end elements of larger lists”.
    //
    // It will be clear with an example, let us take example from wiki :
    // {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}.
    //
    // A[0] = 0. Case 1. There are no active lists, create one.
    // 0.
    // -----------------------------------------------------------------------------
    // A[1] = 8. Case 2. Clone and extend.
    // 0.
    // 0, 8.
    // -----------------------------------------------------------------------------
    // A[2] = 4. Case 3. Clone, extend and discard.
    // 0.
    // 0, 4.
    // 0, 8. Discarded
    // -----------------------------------------------------------------------------
    // A[3] = 12. Case 2. Clone and extend.
    // 0.
    // 0, 4.
    // 0, 4, 12.
    // -----------------------------------------------------------------------------
    // A[4] = 2. Case 3. Clone, extend and discard.
    // 0.
    // 0, 2.
    // 0, 4. Discarded.
    // 0, 4, 12.
    // -----------------------------------------------------------------------------
    // A[5] = 10. Case 3. Clone, extend and discard.
    // 0.
    // 0, 2.
    // 0, 2, 10.
    // 0, 4, 12. Discarded.
    // -----------------------------------------------------------------------------
    // A[6] = 6. Case 3. Clone, extend and discard.
    // 0.
    // 0, 2.
    // 0, 2, 6.
    // 0, 2, 10. Discarded.
    // -----------------------------------------------------------------------------
    // A[7] = 14. Case 2. Clone and extend.
    // 0.
    // 0, 2.
    // 0, 2, 6.
    // 0, 2, 6, 14.
    // -----------------------------------------------------------------------------
    // A[8] = 1. Case 3. Clone, extend and discard.
    // 0.
    // 0, 1.
    // 0, 2. Discarded.
    // 0, 2, 6.
    // 0, 2, 6, 14.
    // -----------------------------------------------------------------------------
    // A[9] = 9. Case 3. Clone, extend and discard.
    // 0.
    // 0, 1.
    // 0, 2, 6.
    // 0, 2, 6, 9.
    // 0, 2, 6, 14. Discarded.
    // -----------------------------------------------------------------------------
    // A[10] = 5. Case 3. Clone, extend and discard.
    // 0.
    // 0, 1.
    // 0, 1, 5.
    // 0, 2, 6. Discarded.
    // 0, 2, 6, 9.
    // -----------------------------------------------------------------------------
    // A[11] = 13. Case 2. Clone and extend.
    // 0.
    // 0, 1.
    // 0, 1, 5.
    // 0, 2, 6, 9.
    // 0, 2, 6, 9, 13.
    // -----------------------------------------------------------------------------
    // A[12] = 3. Case 3. Clone, extend and discard.
    // 0.
    // 0, 1.
    // 0, 1, 3.
    // 0, 1, 5. Discarded.
    // 0, 2, 6, 9.
    // 0, 2, 6, 9, 13.
    // -----------------------------------------------------------------------------
    // A[13] = 11. Case 3. Clone, extend and discard.
    // 0.
    // 0, 1.
    // 0, 1, 3.
    // 0, 2, 6, 9.
    // 0, 2, 6, 9, 11.
    // 0, 2, 6, 9, 13. Discarded.
    // -----------------------------------------------------------------------------
    // A[14] = 7. Case 3. Clone, extend and discard.
    // 0.
    // 0, 1.
    // 0, 1, 3.
    // 0, 1, 3, 7. 0, 2, 6, 9. Discarded.
    // 0, 2, 6, 9, 11.
    // ----------------------------------------------------------------------------
    // A[15] = 15. Case 2. Clone and extend.
    // 0.
    // 0, 1.
    // 0, 1, 3.
    // 0, 1, 3, 7.
    // 0, 2, 6, 9, 11.
    // 0, 2, 6, 9, 11, 15. <-- LIS List
    //
    // Also, ensure we have maintained the condition, “end element of smaller list is smaller than end elements of larger lists“.
    // This algorithm is called Patience Sorting.
    // http://en.wikipedia.org/wiki/Patience_sorting
    //
    // So, pick a suit from deck of cards. Find the longest increasing sub-sequence of cards from the shuffled suit. You will never
    // forget the approach.
    //
    // Complexity : O(NlogN)
    //
    // Source: http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/

    public int lengthOfLIS( int[] nums ) {
        TreeSet<Integer> set = new TreeSet<>();
        for( int i : nums ) {
            Integer ceil = set.ceiling( i );
            if( null != ceil ) {
                set.remove( ceil );
            }
            set.add( i );
        }
        return set.size();
    }

    public static void main( String[] args ) {
        Solution1 s = new Solution1();
        int[] nums = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
        s.lengthOfLIS( nums );
    }
}
