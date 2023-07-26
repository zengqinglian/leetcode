package binaryTreeLevelOrderTraversalII;

import java.util.*;

public class Solution {
/*
Runtime
1 ms
Beats
94.52%
Memory
42.1 MB
Beats
68.59%
 */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        List<List<Integer>> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> li = new ArrayList<>();
            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();
                li.add(node.val);
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right!=null) {
                    q.add(node.right);
                }
            }
            res.add(li);
        }
        Collections.reverse(res);
        return res;
    }

    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
    }
}
