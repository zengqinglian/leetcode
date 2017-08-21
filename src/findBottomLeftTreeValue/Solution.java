package findBottomLeftTreeValue;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
  // first solution BFS beat 50%
  public int findBottomLeftValue(TreeNode root) {
    if (root == null) {
      return 0;
    }
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int last = root.val;
    while (!q.isEmpty()) {
      TreeNode node = q.poll();
      last = node.val;
      if (node.right != null) {
        q.add(node.right);
      }
      if (node.left != null) {
        q.add(node.left);
      }
    }
    return last;

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
