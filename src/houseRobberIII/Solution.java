package houseRobberIII;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution
{
    public int rob( TreeNode root ) {
        return getMaxAmount( root );
    }

    private int getMaxAmount( TreeNode tn ) {
        if( tn == null ) {
            return 0;

        }
        if( tn.left == null && tn.right == null ) {
            return tn.val;
        }

        int leftSubTreeSum = 0;
        int rightSubTreeSum = 0;
        int leftChildAndSub = 0;
        int rightChildAndSub = 0;

        if( tn.left != null ) {
            leftSubTreeSum = getMaxAmount( tn.left.left ) + getMaxAmount( tn.left.right );
            leftChildAndSub = getMaxAmount( tn.left );
        }
        if( tn.right != null ) {
            rightSubTreeSum = getMaxAmount( tn.right.left ) + getMaxAmount( tn.right.right );
            rightChildAndSub = getMaxAmount( tn.right );
        }

        return Math.max( tn.val + leftSubTreeSum + rightSubTreeSum, leftChildAndSub + rightChildAndSub );

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