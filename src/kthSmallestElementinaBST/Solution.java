package kthSmallestElementinaBST;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public int kthSmallest( TreeNode root, int k ) {
        List<Integer> list = new ArrayList<>();
        traversal( root, list );
        return list.get( k - 1 );

    }

    private void traversal( TreeNode node, List<Integer> list ) {
        if( node == null ) {
            return;
        }

        traversal( node.left, list );
        list.add( node.val );
        traversal( node.right, list );
    }

    private static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode( int x ) {
            val = x;
        }
    }
}
