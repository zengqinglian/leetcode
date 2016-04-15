package populatingNextRightPointersinEachNode;

public class Solution1
{
    public void connect( TreeLinkNode root ) {
        if( root == null ) {
            return;
        }
        TreeLinkNode loopNode = root;
        while( loopNode.left != null ) {
            loopNode.left.next = loopNode.right;
            TreeLinkNode sameLevelLoop = loopNode;
            while( sameLevelLoop.next != null ) {
                sameLevelLoop.right.next = sameLevelLoop.next.left;
                sameLevelLoop.next.left.next = sameLevelLoop.next.right;
                sameLevelLoop = sameLevelLoop.next;
            }
            loopNode = loopNode.left;
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
        Solution1 s = new Solution1();
        TreeLinkNode root = new TreeLinkNode( 1 );
        TreeLinkNode left = new TreeLinkNode( 2 );
        TreeLinkNode right = new TreeLinkNode( 3 );

        root.left = left;
        root.right = right;

        s.connect( root );
    }
}
