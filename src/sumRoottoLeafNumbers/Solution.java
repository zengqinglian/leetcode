package sumRoottoLeafNumbers;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    public int sumNumbers( TreeNode root ) {
        List<String> list = new ArrayList<>();
        traversal( root, new StringBuilder(), list );
        int sum = 0;
        for( String s : list ) {
            sum += Integer.valueOf( s );
        }

        return sum;
    }

    private void traversal( TreeNode node, StringBuilder sb, List<String> list ) {
        if( node == null ) {
            return;
        }

        sb.append( node.val );
        if( node.left == null && node.right == null ) {
            list.add( sb.toString() );
        } else {
            if( node.left != null ) {
                traversal( node.left, new StringBuilder( sb.toString() ), list );
            }
            if( node.right != null ) {
                traversal( node.right, new StringBuilder( sb.toString() ), list );
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
