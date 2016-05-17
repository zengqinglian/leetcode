package binarySearchTreeIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BSTIterator
{

    private Iterator<TreeNode> iterator;;

    public BSTIterator( TreeNode root ) {
        List<TreeNode> list = new ArrayList<>();
        traversal( root, list );
        iterator = list.iterator();
    }

    private List<TreeNode> traversal( TreeNode node, List<TreeNode> list ) {

        if( node == null ) {
            return list;
        }

        if( node.left != null ) {
            traversal( node.left, list );
            list.add( node );
            traversal( node.right, list );
        }

        return list;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return iterator.hasNext();
    }

    /** @return the next smallest number */
    public int next() {
        return iterator.next().val;
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
