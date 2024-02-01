package symmetricTree;

public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left!=null && right!=null) {
            if (left.val == right.val) {
                return helper(left.left, right.right) && helper(left.right, right.left);
            }else{
                return false;
            }
        }
        return false;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
