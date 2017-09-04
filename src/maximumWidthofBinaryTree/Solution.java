package maximumWidthofBinaryTree;

import java.util.LinkedList;

public class Solution {
  // first slow solution - beat 10%
  public int widthOfBinaryTree(TreeNode root) {
    if (root == null) {
      return 0;
    }
    LinkedList<TreeNode> l1 = new LinkedList<>();
    LinkedList<TreeNode> l2 = new LinkedList<>();

    l1.add(root);

    int max = 1;

    while (!l1.isEmpty() || !l2.isEmpty()) {
      if (l2.isEmpty()) {
        while (!l1.isEmpty()) {
          TreeNode node = l1.poll();
          if (l2.isEmpty()) {
            if (node == null) {
              continue;
            } else if (node.left != null) {
              l2.add(node.left);
              l2.add(node.right);
            } else if (node.right != null) {
              l2.add(node.right);
            }
          } else {
            if (node == null) {
              l2.add(null);
              l2.add(null);
            } else {
              l2.add(node.left);
              l2.add(node.right);
            }
          }
        }
        while (!l2.isEmpty() && l2.peekLast() == null) {
          l2.removeLast();
        }
        max = Math.max(max, l2.size());
      } else if (l1.isEmpty()) {
        while (!l2.isEmpty()) {
          TreeNode node = l2.poll();
          if (l1.isEmpty()) {
            if (node == null) {
              continue;
            } else if (node.left != null && node.right != null) {
              l1.add(node.left);
              l1.add(node.right);
            } else if (node.right != null) {
              l1.add(node.right);
            }
          } else {
            if (node == null) {
              l1.add(null);
              l1.add(null);
            } else {
              l1.add(node.left);
              l1.add(node.right);
            }
          }
        }
        while (!l1.isEmpty() && l1.peekLast() == null) {
          l1.removeLast();
        }
        max = Math.max(max, l1.size());
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

  public static void main(String[] args) {
    // [1,1,1,1,null,null,1,1,null,null,1]
    Solution s = new Solution();
    TreeNode t1 = new TreeNode(1);
    TreeNode t2 = new TreeNode(1);
    TreeNode t3 = new TreeNode(1);
    TreeNode t4 = new TreeNode(1);
    TreeNode t5 = new TreeNode(1);
    TreeNode t6 = new TreeNode(1);
    TreeNode t7 = new TreeNode(1);

    t1.left = t2;
    t1.right = t3;
    t2.left = t4;
    t3.right = t5;
    t4.left = t6;
    t5.right = t7;
    s.widthOfBinaryTree(t1);
  }

}
