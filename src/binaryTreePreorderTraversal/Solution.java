package binaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<Integer> preorderTraversal( TreeNode root ) {
        List<Integer> result = new ArrayList<>();
        if( root == null ) {
            return result;
        }
        traversal( root, result );
        return result;

    }

    private void traversal( TreeNode node, List<Integer> list ) {
        if( node == null ) {
            return;
        }
        list.add( node.val );
        traversal( node.left, list );
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
