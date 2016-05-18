package binaryTreeRightSideView;

import java.util.ArrayList;
import java.util.List;

public class Solution
{
    // first solution - 3ms
    public List<Integer> rightSideView( TreeNode root ) {
        List<Integer> result = new ArrayList<>();
        if( root == null ) {
            return result;
        }

        List<TreeNode> children = new ArrayList<>();
        if( root.left != null )
            children.add( root.left );

        if( root.right != null ) {
            children.add( root.right );
        }
        result.add( root.val );
        rightView( children, result );
        return result;
    }

    private void rightView( List<TreeNode> allChildren, List<Integer> result ) {
        if( allChildren.size() == 0 ) {
            return;
        }
        List<TreeNode> newChild = new ArrayList<>();
        for( TreeNode tn : allChildren ) {
            if( tn.left != null )
                newChild.add( tn.left );

            if( tn.right != null ) {
                newChild.add( tn.right );
            }
        }

        result.add( allChildren.get( allChildren.size() - 1 ).val );

        rightView( newChild, result );

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
