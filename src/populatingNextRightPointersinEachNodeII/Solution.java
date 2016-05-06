package populatingNextRightPointersinEachNodeII;

public class Solution
{
    public void connect( TreeLinkNode root ) {
        if( root == null ) {
            return;
        }
        TreeLinkNode loopNode = root;
        while( loopNode != null ) {
            loopNode = linkNextLevel( loopNode );
        }

    }

    private TreeLinkNode linkNextLevel( TreeLinkNode parent ) {
        TreeLinkNode loopNode = parent;
        TreeLinkNode firstLeft = null;
        TreeLinkNode current = null;
        while( loopNode != null ) {
            if( firstLeft == null ) {
                if( loopNode.left != null ) {
                    firstLeft = loopNode.left;
                    current = firstLeft;
                } else if( loopNode.right != null ) {
                    firstLeft = loopNode.right;
                    current = firstLeft;
                }
            }

            if( current != null ) {
                if( loopNode.left != null && current != loopNode.left ) {
                    current.next = loopNode.left;
                    current = current.next;
                }
                if( loopNode.right != null && current != loopNode.right ) {
                    current.next = loopNode.right;
                    current = current.next;
                }

            }

            loopNode = loopNode.next;

        }

        return firstLeft;
    }

    public static void main( String[] args ) {
        TreeLinkNode root = new TreeLinkNode( 0 );

        Solution s = new Solution();
        s.connect( root );
    }

    private static class TreeLinkNode
    {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode( int x ) {
            val = x;
        }
    }
}
