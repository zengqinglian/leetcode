package secondMinimumNodeInaBinaryTree;

public class Solution1 {
  // quicker solution.
  int min1;
  long ans = Long.MAX_VALUE;

  public void dfs(TreeNode root) {
    if (root != null) {
      if (min1 < root.val && root.val < ans) {
        ans = root.val;
      } else if (min1 == root.val) {
        dfs(root.left);
        dfs(root.right);
      }
    }
  }

  public int findSecondMinimumValue(TreeNode root) {
    min1 = root.val;
    dfs(root);
    return ans < Long.MAX_VALUE ? (int) ans : -1;
  }

  public static void main(String[] args) {
    TreeNode node1 = new TreeNode(2);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(5);
    TreeNode node4 = new TreeNode(5);
    TreeNode node5 = new TreeNode(7);

    node1.left = node2;
    node1.right = node3;
    node3.left = node4;
    node3.right = node5;

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
