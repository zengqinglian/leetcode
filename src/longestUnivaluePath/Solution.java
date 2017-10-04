package longestUnivaluePath;

public class Solution {
  // solution meet avg speed.
  private int max = 0;

  public int longestUnivaluePath(TreeNode root) {
    if (root == null) {
      return 0;
    }
    traversal(root);
    return max;
  }

  private int[] traversal(TreeNode node) {
    int left = 0;
    int right = 0;
    if (node.left != null) {
      int[] leftTree = traversal(node.left);
      if (node.left.val == node.val) {
        left = Math.max(leftTree[0], leftTree[1]) + 1;
      } else {
        left = 0;
      }
    }

    if (node.right != null) {
      int[] rightTree = traversal(node.right);
      if (node.right.val == node.val) {
        right = Math.max(rightTree[0], rightTree[1]) + 1;
      } else {
        right = 0;
      }
    }

    int[] ret = {left, right};
    max = Math.max(left + right, max);
    return ret;
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
    // [1,1,5,1,1,5,null,1,null,1]
    TreeNode t1 = new TreeNode(1);
    TreeNode t2 = new TreeNode(1);
    TreeNode t3 = new TreeNode(5);
    TreeNode t4 = new TreeNode(1);
    TreeNode t5 = new TreeNode(1);
    TreeNode t6 = new TreeNode(5);
    // TreeNode t7 = new TreeNode(1);
    // TreeNode t8 = new TreeNode(1);

    t1.left = t2;
    t1.right = t3;

    t2.left = t4;
    t2.right = t5;

    t3.left = t6;

    // t4.left = t7;
    // t5.left = t8;

    Solution s = new Solution();
    System.out.print(s.longestUnivaluePath(t1));
  }
}
