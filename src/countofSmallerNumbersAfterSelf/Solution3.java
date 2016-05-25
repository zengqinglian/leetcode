package countofSmallerNumbersAfterSelf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3
{
    // Binary search tree solution
    public List<Integer> countSmaller( int[] nums ) {
        int len;
        List<Integer> res = new ArrayList<>();
        if( nums == null || (len = nums.length) == 0 ) {
            return res;
        }
        Integer[] tmp = new Integer[len];
        BST bst = new BST();
        for( int i = len - 1; i >= 0; i-- ) {
            tmp[i] = bst.insert( nums[i] );
        }
        res.addAll( Arrays.asList( tmp ) );
        return res;
    }

    private static class BST
    {
        private Node root;

        private int insert( int val ) {
            int sCnt = 0;
            if( root == null ) {
                root = new Node( val );
                return sCnt;
            }
            Node cur = root;
            while( true ) {
                if( cur.val < val ) {
                    sCnt += cur.lCnt + cur.selfCnt;
                    if( cur.right == null ) {
                        cur.right = new Node( val );
                        return sCnt;
                    } else {
                        cur = cur.right;
                    }
                } else if( cur.val > val ) {
                    cur.lCnt++;
                    if( cur.left == null ) {
                        cur.left = new Node( val );
                        return sCnt;
                    } else {
                        cur = cur.left;
                    }
                }
                // equal
                else {
                    sCnt += cur.lCnt;
                    cur.selfCnt++;
                    return sCnt;
                }
            }
        }
    }

    private static class Node
    {
        private int val;
        private Node left;
        private Node right;
        private int lCnt;// size for left sub-tree
        private int selfCnt; // cnt for self occurances - deal with equal element.

        private Node( int val ) {
            this.val = val;
            selfCnt = 1;
        }
    }

    public static void main( String[] args ) {
        Solution3 s = new Solution3();
        int[] nums = { 6, 5, 2, 6, 1 };
        s.countSmaller( nums );
    }
}
