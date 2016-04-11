package binaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution1
{
    public List<Integer> preorderTraversal( TreeNode root ) {
        List<Integer> result = new ArrayList<>();
        if( root == null ) {
            return result;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push( root );
        while( !s.isEmpty() ) {
            TreeNode node = s.pop();
            result.add( node.val );
            if( node.right != null ) {
                s.push( node.right );
            }
            if( node.left != null ) {
                s.push( node.left );
            }
        }
        return result;
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
