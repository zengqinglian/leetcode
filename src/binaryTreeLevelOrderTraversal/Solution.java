package binaryTreeLevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
  // 2ms solution - meet avg speed .
  public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) {
      return result;
    }

    int count = 1;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);

    while (!queue.isEmpty()) {
      int newCount = 0;
      List<Integer> li = new ArrayList<>();
      for (int i = 1; i <= count; i++) {
        TreeNode node = queue.poll();
        li.add(node.val);
        if (node.left != null) {
          queue.add(node.left);
          newCount++;
        }
        if (node.right != null) {
          queue.add(node.right);
          newCount++;
        }
      }
      result.add(li);
      count = newCount;
    }

    return result;

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
