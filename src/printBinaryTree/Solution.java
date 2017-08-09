package printBinaryTree;

import java.util.ArrayList;

public class Solution {
  // count the height of the tree. then create return. beat 50%
  public List<List<String>> printTree(TreeNode root) {
    List<List<String>> result = new ArrayList<>();

    if (root == null) {
      return result;
    }
    int max = getTreeHeight(root);
    int length = (int) Math.pow(2, max) - 1;

    for (int i = 1; i <= max; i++) {
      List<String> li = new ArrayList<>(length);
      for (int j = 0; j < length; j++) {
        li.add("");
      }
      result.add(li);
    }

    updateResult(result, root, 0, length - 1, 1, max);

    return result;
  }

  private void updateResult(List<List<String>> result, TreeNode root, int s, int e, int level,
      int max) {
    int len = (e - s) / 2;
    List<String> li = result.get(level - 1);
    li.set(s + len, String.valueOf(root.val));
    if (level == max) {
      return;
    } else {
      if (root.left != null) {
        updateResult(result, root.left, s, s + len, level + 1, max);
      }
      if (root.right != null) {
        updateResult(result, root.right, s + len + 1, e, level + 1, max);
      }
    }

  }

  private int getTreeHeight(TreeNode root) {
    if (root == null) {
      return 0;
    }

    if (root.left == null && root.right == null) {
      return 1;
    }

    if (root.left != null && root.right == null) {
      return 1 + getTreeHeight(root.left);
    }

    if (root.left == null && root.right != null) {
      return 1 + getTreeHeight(root.right);
    }

    if (root.left != null && root.right != null) {
      return 1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right));
    }

    return -1;

  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }

    public String toString() {
      return String.valueOf(val);
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    // [1,2,5,3,null,null,null,4]
    TreeNode node1 = new TreeNode(1);
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(5);
    TreeNode node4 = new TreeNode(3);
    TreeNode node5 = new TreeNode(4);

    node1.left = null;
    node1.right = node2;
    // node2.left = node4;
    // node4.left = node5;

    s.printTree(node1);

  }
}
