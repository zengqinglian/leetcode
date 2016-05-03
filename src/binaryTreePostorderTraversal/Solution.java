package binaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Solution
{
    // Non recursive way
    public List<Integer> postorderTraversal( TreeNode root ) {
        List<Integer> result = new ArrayList<>();
        if( root == null ) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add( root );

        Set<TreeNode> markedNode = new HashSet<>();

        while( !stack.isEmpty() ) {

            TreeNode node = stack.peek();
            if( (node.left == null && node.right == null) || markedNode.contains( node ) ) {
                stack.pop();
                result.add( node.val );
            } else {
                if( node.right != null ) {
                    stack.push( node.right );
                }

                if( node.left != null ) {
                    stack.push( node.left );
                }

            }

            markedNode.add( node );
        }

        return result;
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

    public static void main( String[] args ) {
        Solution s = new Solution();
        TreeNode root = new TreeNode( 1 );
        TreeNode node1 = new TreeNode( 2 );
        root.left = node1;
        s.postorderTraversal( root );
    }
}
