package validateBinarySearchTree;


public class Solution {
  // 1ms solution - meet avg
  public boolean isValidBST(TreeNode root) {
    return isValidBST(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
  }

  public boolean isValidBST(TreeNode root, int up, int bottom) {
    if (root == null) {
      return true;
    }
    if (root.left == null && root.right == null) {
      return root.val <= up && root.val >= bottom;
    } else if (root.left != null && root.right == null) {
      return root.left.val < root.val && root.val <= up && root.val >= bottom
          && isValidBST(root.left, root.val - 1, bottom);
    } else if (root.right != null && root.left == null) {
      return root.val < root.right.val && root.val <= up && root.val >= bottom
          && isValidBST(root.right, up, root.val + 1);
    } else {
      return root.val < root.right.val && root.left.val < root.val && root.val <= up
          && root.val >= bottom && isValidBST(root.right, up, root.val + 1)
          && isValidBST(root.left, root.val - 1, bottom);
    }
  }


  public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }

}
