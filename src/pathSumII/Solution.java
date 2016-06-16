package pathSumII;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution
{
    public List<List<Integer>> pathSum( TreeNode root, int sum ) {
        List<List<Integer>> result = new ArrayList<>();
        if( root == null ) {
            return result;
        }
        traversal( root, sum, new ArrayList<Integer>(), result );
        return result;
    }

    private void traversal( TreeNode node, int sum, List<Integer> temp, List<List<Integer>> result ) {
        if( node.val == sum && node.left == null && node.right == null ) {
            temp.add( node.val );
            result.add( temp );
        } else {
            if( node.left != null ) {
                List<Integer> newTemp = new ArrayList<>( temp );
                newTemp.add( node.val );
                traversal( node.left, sum - node.val, newTemp, result );
            }
            if( node.right != null ) {
                List<Integer> newTemp = new ArrayList<>( temp );
                newTemp.add( node.val );
                traversal( node.right, sum - node.val, newTemp, result );
            }
        }
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
