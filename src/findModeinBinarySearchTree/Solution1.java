package findModeinBinarySearchTree;

import java.util.ArrayList;
import java.util.List;


public class Solution1 {
  Integer prev = null;
  int count = 1;
  int max = 0;

  public int[] findMode(TreeNode root) {
    if (root == null)
      return new int[0];

    List<Integer> list = new ArrayList<>();
    traverse(root, list);

    int[] res = new int[list.size()];
    for (int i = 0; i < list.size(); ++i)
      res[i] = list.get(i);
    return res;
  }

  private void traverse(TreeNode root, List<Integer> list) {
    if (root == null)
      return;
    traverse(root.left, list);
    if (prev != null) {
      if (root.val == prev)
        count++;
      else
        count = 1;
    }
    if (count > max) {
      max = count;
      list.clear();
      list.add(root.val);
    } else if (count == max) {
      list.add(root.val);
    }
    prev = root.val;
    traverse(root.right, list);
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
