package secondMinimumNodeInaBinaryTree;

import java.util.TreeSet;

public class Solution {
  public int findSecondMinimumValue(TreeNode root) {
    if (root == null) {
      return -1;
    }

    TreeSet<Integer> set = new TreeSet<>();

    inOrderTraversal(root, set);

    if (set.size() == 1) {
      return -1;
    }

    set.pollFirst();
    return set.pollFirst();
  }

  private void inOrderTraversal(TreeNode node, TreeSet<Integer> result) {

    if (node.left != null) {
      inOrderTraversal(node.left, result);
    }

    result.add(node.val);

    if (node.right != null) {
      inOrderTraversal(node.right, result);
    }

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

    Solution s = new Solution();
    s.findSecondMinimumValue(node1);
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
