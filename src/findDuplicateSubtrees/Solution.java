package findDuplicateSubtrees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
  // flat tree and recursive solution beat 80%
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> results = new ArrayList<>();
    if (root == null) {
      return new ArrayList<TreeNode>();
    }

    Map<String, List<TreeNode>> map = new HashMap<>();

    flatTreeHelper(root, map);

    for (List<TreeNode> li : map.values()) {
      if (li.size() > 1) {
        results.add(li.get(0));
      }
    }

    return results;
  }



  private String flatTreeHelper(TreeNode root, Map<String, List<TreeNode>> map) {
    if (root == null) {
      return "#";
    } else {
      String temp = root.val + flatTreeHelper(root.left, map) + flatTreeHelper(root.right, map);
      if (map.containsKey(temp)) {
        map.get(temp).add(root);
      } else {
        List<TreeNode> li = new ArrayList<>();
        li.add(root);
        map.put(temp, li);
      }
      return temp;
    }

  }

  private static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
      val = x;
    }

    public String toString() {
      return "Node val = " + val;
    }
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    TreeNode root = new TreeNode(100);
    TreeNode n1 = new TreeNode(200);
    TreeNode n2 = new TreeNode(200);
    TreeNode n3 = new TreeNode(300);
    TreeNode n4 = new TreeNode(300);

    root.left = n1;
    root.right = n2;
    n1.left = n3;
    n2.left = n4;

    s.findDuplicateSubtrees(root);

  }
}
