package equalTreePartition;

import java.util.HashSet;
import java.util.Set;

public class Solution {
  // find a node sum x 2 = root sum
  public boolean checkEqualTree(TreeNode root) {
    Set<Integer> allSum = new HashSet<>();
    int total = traversal(root, allSum);
    if (total > 0 && total % 2 == 0 && allSum.contains(total / 2)) {
      return true;
    }

    return false;
  }

  private int traversal(TreeNode node, Set<Integer> allSum) {
    if (node == null) {
      return 0;
    } else {
      int sum = traversal(node.left, allSum) + node.val + traversal(node.right, allSum);
      allSum.add(sum);
      return sum;
    }
  }

  public static void main(String[] args) {
    TreeNode n1 = new TreeNode(5);
    TreeNode n2 = new TreeNode(10);
    TreeNode n3 = new TreeNode(10);
    TreeNode n4 = new TreeNode(2);
    TreeNode n5 = new TreeNode(3);

    n1.left = n2;
    n1.right = n3;
    n3.left = n4;
    n3.right = n5;

    Solution s = new Solution();
    s.checkEqualTree(n1);

  }

  private static class TreeNode {
    private int val;
    private TreeNode left;
    private TreeNode right;

    private TreeNode(int val) {
      this.val = val;
    }
  }
}
