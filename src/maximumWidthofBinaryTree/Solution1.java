package maximumWidthofBinaryTree;

import java.util.LinkedList;

public class Solution1 {
  // improvement meet 50% avg time
  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    LinkedList<Integer> l1 = new LinkedList<>();
    LinkedList<Integer> l2 = new LinkedList<>();
    LinkedList<TreeNode> T = new LinkedList<>();

    T.add(root);
    l1.add(1);
    int max = 1;
    while (!T.isEmpty()) {
      if (!l1.isEmpty()) {
        max = Math.max(max, l1.peekLast() - l1.peekFirst() + 1);
        while (!l1.isEmpty()) {
          // find first not null child
          TreeNode node = T.poll();
          int index = l1.poll();
          if (node.left != null) {
            T.add(node.left);
            l2.add(2 * index);
          }

          if (node.right != null) {
            T.add(node.right);
            l2.add(2 * index + 1);
          }
        }
      }

      if (!l2.isEmpty()) {
        max = Math.max(max, l2.peekLast() - l2.peekFirst() + 1);
        while (!l2.isEmpty()) {
          // find first not null child
          TreeNode node = T.poll();
          int index = l2.poll();
          if (node.left != null) {
            T.add(node.left);
            l1.add(2 * index);
          }

          if (node.right != null) {
            T.add(node.right);
            l1.add(2 * index + 1);
          }
        }
      }
    }

    return max;
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
