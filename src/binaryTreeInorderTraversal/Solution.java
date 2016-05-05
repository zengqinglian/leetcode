package binaryTreeInorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public List<Integer> inorderTraversal( TreeNode root ) {
        List<Integer> result = new ArrayList<>();
        traversal( root, result );
        return result;

    }

    private void traversal( TreeNode node, List<Integer> result ) {
        if( node == null ) {
            return;
        } else {
            traversal( node.left, result );
            result.add( node.val );
            traversal( node.right, result );
        }

    }

    public static class TreeNode
    {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode( int x ) {
            val = x;
        }
    }
}
