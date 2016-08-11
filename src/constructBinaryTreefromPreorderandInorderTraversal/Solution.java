package constructBinaryTreefromPreorderandInorderTraversal;

public class Solution {
    // recursion solution - beat 40%
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root = getTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);

        return root;
    }

    private TreeNode getTree(int[] preorder, int[] inorder, int preorderStart, int preorderEnd, int inorderStart,
            int inorderEnd) {
        if (preorderStart > preorderEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderStart]);

        if (preorderStart >= preorderEnd) {
            return root;
        }

        int inorderRootIndex = inorderStart;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == preorder[preorderStart]) {
                inorderRootIndex = i;
                break;
            }
        }

        int leftTreeLength = inorderRootIndex - inorderStart;

        root.left = getTree(preorder, inorder, preorderStart + 1, preorderStart + leftTreeLength, inorderStart,
                inorderRootIndex - 1);
        root.right = getTree(preorder, inorder, preorderStart + leftTreeLength + 1, preorderEnd, inorderRootIndex + 1,
                inorderEnd);

        return root;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] preorder = { 6, 2, 1, 4, 3, 5, 7, 9, 8 };
        int[] inorder = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

        s.buildTree(preorder, inorder);
    }
}

