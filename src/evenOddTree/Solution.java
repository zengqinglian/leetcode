package evenOddTree;

import java.util.LinkedList;
import java.util.Queue;
/*
Runtime: 16 ms, faster than 63.57% of Java online submissions for Even Odd Tree.
Memory Usage: 86.6 MB, less than 36.99% of Java online submissions for Even Odd Tree.
 */
public class Solution {
  public boolean isEvenOddTree(TreeNode root) {
    int level = 0;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    while(!q.isEmpty()) {
      int size = q.size();
      int pre = 0;
      if(level % 2 == 1) {
        pre = Integer.MAX_VALUE;
      }

      for(int i=0; i<size; i++) {
        TreeNode node = q.poll();
        if(level % 2 ==0) {
          if(node.val % 2 ==0 || node.val <= pre){
            return false;
          }
        }else {
          if(node.val % 2 ==1 || node.val >= pre){
            return false;
          }
        }
        pre = node.val;
        if(node.left!=null) {
          q.add(node.left);
        }
        if(node.right!=null) {
          q.add(node.right);
        }
      }
      level++;
    }
    return true;
  }

  public static class TreeNode {
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
