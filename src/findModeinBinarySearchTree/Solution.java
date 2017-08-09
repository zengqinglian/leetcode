package findModeinBinarySearchTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  // solution beat 28%
  public int[] findMode(TreeNode root) {
    Map<Integer, Integer> map = new HashMap<>();
    int max = updateMap(root, map, 0);
    List<Integer> list = new ArrayList<>();
    for (int i : map.keySet()) {
      if (map.get(i) == max) {
        list.add(i);
      }
    }
    int[] result = new int[list.size()];

    for (int i = 0; i < list.size(); i++) {
      result[i] = list.get(i);
    }
    return result;
  }

  private int updateMap(TreeNode root, Map<Integer, Integer> map, int max) {
    if (root != null) {
      if (map.containsKey(root.val)) {
        map.put(root.val, map.get(root.val) + 1);
        if (map.get(root.val) > max) {
          max = map.get(root.val);
        }
      } else {
        map.put(root.val, 1);
        if (1 > max) {
          max = 1;
        }
      }
      int maxLeft = updateMap(root.left, map, max);
      int maxRight = updateMap(root.right, map, max);

      max = Math.max(max, maxLeft);
      max = Math.max(max, maxRight);
      return max;
    }
    return 0;

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
    Solution s = new Solution();

    TreeNode root = new TreeNode(1);
    TreeNode n1 = new TreeNode(2);
    TreeNode n2 = new TreeNode(2);
    TreeNode n3 = new TreeNode(3);

    root.right = n1;
    n1.left = n2;
    n1.right = n3;

    s.findMode(root);
  }
}
