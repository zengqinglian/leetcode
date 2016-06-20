package serializeandDeserializeBinaryTree;

import java.util.LinkedList;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Codec
{

    // overtime limit solution

    // Encodes a tree to a single string.
    public String serialize( TreeNode root ) {
        if( root == null ) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int notNullNode = 1;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add( root );

        while( true ) {
            TreeNode node = queue.poll();
            if( node != null ) {
                notNullNode--;
                if( sb.length() == 0 ) {
                    sb.append( node.val );
                } else {
                    sb.append( "," + node.val );
                }
            } else {
                if( sb.length() == 0 ) {
                    sb.append( "" );
                } else {
                    sb.append( "," + "" );
                }
            }

            if( node == null ) {
                queue.add( null );
                queue.add( null );
            } else {
                if( node.left != null ) {
                    notNullNode++;
                }
                if( node.right != null ) {
                    notNullNode++;
                }
                queue.add( node.left );
                queue.add( node.right );
            }
            if( notNullNode == 0 ) {
                break;
            }
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize( String data ) {
        if( data.equals( "" ) ) {
            return null;
        }
        String[] vals = data.split( "," );

        TreeNode root = createTreeNode( vals, 0 );

        return root;
    }

    private TreeNode createTreeNode( String[] vals, int index ) {
        TreeNode node = null;
        if( index < vals.length ) {
            if( vals[index].equals( "" ) ) {
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
        Codec s = new Codec();
        TreeNode root = new TreeNode( -1 );
        TreeNode node1 = new TreeNode( 0 );
        TreeNode node2 = new TreeNode( 1 );
        // TreeNode node3 = new TreeNode( 3 );
        // TreeNode node4 = new TreeNode( 4 );
        // TreeNode node5 = new TreeNode( 5 );
        // TreeNode node6 = new TreeNode( 6 );
        root.left = node1;
        root.right = node2;
        // node1.left = node3;
        // node2.right = node4;
        // node3.right = node5;
        // node5.right = node6;
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

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
