package uniqueBinarySearchTreesII;

import java.util.ArrayList;
import java.util.List;

public class Solution {
  // 4ms solution beat 70%
  public List<TreeNode> generateTrees(int n) {
    List<TreeNode> result = generateTrees(1, n, n);
    return result;

  }

  private List<TreeNode> generateTrees(int s, int e, int n) {
    if (s <= 0 || e <= 0) {
      return new ArrayList<TreeNode>();
    }

    if (s > n || e > n) {
      return new ArrayList<TreeNode>();
    }

    if (s == e) {
      List<TreeNode> ret = new ArrayList<>();
      TreeNode root = new TreeNode(s);
      ret.add(root);
      return ret;
    }

    List<TreeNode> ret = new ArrayList<>();
    for (int i = s; i <= e; i++) {
      List<TreeNode> leftSubTree = generateTrees(s, i - 1, n);
      List<TreeNode> rightSubTree = generateTrees(i + 1, e, n);

      if (leftSubTree.isEmpty() && rightSubTree.isEmpty()) {
        TreeNode root = new TreeNode(i);
        ret.add(root);
      } else if (leftSubTree.isEmpty()) {
        for (TreeNode node : rightSubTree) {
          TreeNode root = new TreeNode(i);
          root.right = node;
          ret.add(root);
        }
      } else if (rightSubTree.isEmpty()) {
        for (TreeNode node : leftSubTree) {
          TreeNode root = new TreeNode(i);
          root.left = node;
          ret.add(root);
        }
      } else {
        for (TreeNode l : leftSubTree) {
          for (TreeNode r : rightSubTree) {
            TreeNode root = new TreeNode(i);
            root.right = r;
            root.left = l;
            ret.add(root);
          }
        }
      }
    }
    return ret;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    s.generateTrees(3);
  }

  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }
  }
}
