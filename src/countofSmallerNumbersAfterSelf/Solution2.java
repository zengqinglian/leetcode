package countofSmallerNumbersAfterSelf;

import java.util.LinkedList;
import java.util.List;

public class Solution2
{
    // BIT binary index tree from someone.
    // good solution but hard to understand. the data structure BIT can be found from
    // https://www.topcoder.com/community/data-science/data-science-tutorials/binary-indexed-trees/
    public List<Integer> countSmaller( int[] nums ) {
        List<Integer> res = new LinkedList<Integer>();
        if( nums == null || nums.length == 0 ) {
            return res;
        }
        // find min value and minus min by each elements, plus 1 to avoid 0 element
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for( int i = 0; i < nums.length; i++ ) {
            min = (nums[i] < min) ? nums[i] : min;
        }
        int[] nums2 = new int[nums.length];
        for( int i = 0; i < nums.length; i++ ) {
            nums2[i] = nums[i] - min + 1;
            max = Math.max( nums2[i], max );
        }
        int[] tree = new int[max + 1];
        for( int i = nums2.length - 1; i >= 0; i-- ) {
            res.add( 0, get( nums2[i] - 1, tree ) );
            update( nums2[i], tree );
        }
        return res;
    }

    private int get( int i, int[] tree ) {
        int num = 0;
        while( i > 0 ) {
            num += tree[i];
            i -= i & (-i);
        }
        return num;
    }

    private void update( int i, int[] tree ) {
        while( i < tree.length ) {
            tree[i]++;
            i += i & (-i);
        }
    }

    public static void main( String[] args ) {
        Solution2 s = new Solution2();
        int[] nums = { 5, 2, 1, 0 };
        s.countSmaller( nums );
    }
}
