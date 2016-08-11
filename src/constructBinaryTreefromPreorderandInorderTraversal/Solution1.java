package constructBinaryTreefromPreorderandInorderTraversal;

public class Solution1 {
    // improve solution
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

        // not sure why, change this to loop from end improve speed from 20ms -
        // 2ms. may be test case related
        int inorderRootIndex = inorderEnd;
        for (int i = inorderEnd; i >= inorderStart; i--) {
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

}
