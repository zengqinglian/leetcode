package convertSortedArraytoBinarySearchTree;

public class Solution
{
    public TreeNode sortedArrayToBST( int[] nums ) {
        int length = nums.length;
        if( length == 0 ) {
            return null;
        }
        if( length == 1 ) {
            return new TreeNode( nums[0] );
        }

        return buildTree( nums, 0, length - 1 );

    }

    private TreeNode buildTree( int[] nums, int startIndex, int endIndex ) {
        if( startIndex > endIndex ) {
            return null;
        }
        if( startIndex == endIndex ) {
            return new TreeNode( nums[startIndex] );
        } else {
            int mid = (endIndex - startIndex) / 2;
            int midIndex = startIndex + mid;
            TreeNode subTreeRoot = new TreeNode( nums[midIndex] );

            subTreeRoot.left = buildTree( nums, startIndex, midIndex - 1 );
            subTreeRoot.right = buildTree( nums, midIndex + 1, endIndex );

            return subTreeRoot;
        }
    }

    public static void main( String[] args ) {
        int[] nums = { 3, 5, 8 };
        Solution s = new Solution();
        s.sortedArrayToBST( nums );
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
