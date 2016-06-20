package serializeandDeserializeBinaryTree;

import java.util.LinkedList;

public class Codec1
{
    // memory over limt
    public String serialize( TreeNode root ) {
        if( root == null ) {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> indexQueue = new LinkedList<>();
        queue.add( root );
        indexQueue.add( 0 );
        int counter = 0;

        while( !queue.isEmpty() ) {
            TreeNode node = queue.poll();
            int index = indexQueue.poll();
            while( counter != 0 && counter < index ) {
                sb.append( "," );
                counter++;
            }

            if( node.left != null ) {
                queue.add( node.left );
                indexQueue.add( index * 2 + 1 );
            }
            if( node.right != null ) {
                queue.add( node.right );
                indexQueue.add( index * 2 + 2 );
            }
            if( sb.length() == 0 ) {
                sb.append( node.val );
            } else {
                sb.append( "," + node.val );
            }
            counter++;
        }
        return sb.toString();

    }

    public TreeNode deserialize( String data ) {
        if( data == null ) {
            return null;
        }
        String[] vals = data.split( "," );

        TreeNode root = createTreeNode( vals, 0 );

        return root;

    }

    private TreeNode createTreeNode( String[] vals, int index ) {
        TreeNode node = null;
        if( index < vals.length ) {
            if( vals[index] == null || vals[index].equals( "" ) ) {
                return null;
            } else {
                node = new TreeNode( Integer.valueOf( vals[index] ) );
                node.left = createTreeNode( vals, 2 * index + 1 );
                node.right = createTreeNode( vals, 2 * index + 2 );
            }
        }

        return node;
    }

    public static void main( String[] args ) {
        Codec1 s = new Codec1();
        TreeNode root = new TreeNode( -1 );
        TreeNode node1 = new TreeNode( 0 );
        TreeNode node2 = new TreeNode( 1 );
        TreeNode node3 = new TreeNode( 3 );
        TreeNode node4 = new TreeNode( 4 );
        TreeNode node5 = new TreeNode( 5 );
        TreeNode node6 = new TreeNode( 6 );
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.right = node4;
        node3.right = node5;
        node5.right = node6;
        s.deserialize( s.serialize( root ) );
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
