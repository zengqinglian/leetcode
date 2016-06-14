package sumRoottoLeafNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution1
{
    // quicker solution.- match average.
    public int sumNumbers( TreeNode root ) {
        List<String> list = new ArrayList<>();
        return traversal( root, 0 );

    }

    private int traversal( TreeNode node, int sum ) {
        if( node == null ) {
            return 0;
        }

        int newSum = 0;

        sum = 10 * sum + node.val;
        if( node.left == null && node.right == null ) {
            return sum;
        } else {
            if( node.left != null ) {
                newSum += traversal( node.left, sum );
            }
            if( node.right != null ) {
                newSum += traversal( node.right, sum );
            }
        }
        return newSum;
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
