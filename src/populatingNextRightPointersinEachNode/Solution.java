package populatingNextRightPointersinEachNode;

import java.util.LinkedList;

public class Solution
{
    public void connect( TreeLinkNode root ) {
        if( root == null ) {
            return;
        }
        LinkedList<TreeLinkNode> queue = new LinkedList<>();
        int factor = 0;
        queue.add( root );
        int counter = 1;
        TreeLinkNode lastNode = null;
        while( !queue.isEmpty() ) {
            TreeLinkNode current = queue.pop();
            if( current.left != null && current.right != null ) {
                queue.add( current.left );
                queue.add( current.right );
            }
            if( counter <= Math.pow( 2.0, factor ) ) {
                if( lastNode != null ) {
                    lastNode.next = current;
                }
                if( counter == Math.pow( 2.0, factor ) ) {
                    lastNode = null;
                    counter = 1;
                    factor++;
                } else {
                    lastNode = current;
                    counter++;
                }
            }

        }

    }

    private static class TreeLinkNode
    {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode( int x ) {
            val = x;
        }
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        TreeLinkNode root = new TreeLinkNode( 1 );
        TreeLinkNode left = new TreeLinkNode( 2 );
        TreeLinkNode right = new TreeLinkNode( 3 );

        root.left = left;
        root.right = right;

        s.connect( root );
    }
}
