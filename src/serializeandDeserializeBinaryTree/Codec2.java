package serializeandDeserializeBinaryTree;

public class Codec2
{
    private static final String ROOTNULL = " ";
    private static final String PARTITION = ",";

    // Encodes a tree to a single string.
    public String serialize( TreeNode root ) {
        if( root == null ) {
            return ROOTNULL;
        } else {
            return root.val + PARTITION + serialize( root.left ) + PARTITION + serialize( root.right );
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize( String data ) {
        int cnt;
        String value = "";
        String[] strArray = data.split( PARTITION );

        MyStringArray queue = new MyStringArray();
        queue.strArray = strArray;
        queue.curIndex = 0;

        return deserializeData( queue );
    }

    private TreeNode deserializeData( MyStringArray queue ) {
        if( queue.strArray[queue.curIndex].equals( ROOTNULL ) ) {
            queue.curIndex++;
            return null;
        } else {
            TreeNode root = new TreeNode( Integer.parseInt( queue.strArray[queue.curIndex] ) );
            queue.curIndex++;
            root.left = deserializeData( queue );
            root.right = deserializeData( queue );

            return root;
        }
    }

    private static class MyStringArray
    {
        public String[] strArray;
        public int curIndex;
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
