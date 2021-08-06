package countGoodNodesinBinaryTree;
/*
Runtime: 2 ms, faster than 97.35% of Java online submissions for Count Good Nodes in Binary Tree.
Memory Usage: 47.9 MB, less than 48.24% of Java online submissions for Count Good Nodes in Binary Tree.
 */
public class Solution {
  private int cnt = 0;
  public int goodNodes(TreeNode root) {
    goodNodes(root, Integer.MIN_VALUE);
    return cnt;
  }

  private void goodNodes(TreeNode root, int max){
    if(root.val >= max){
      cnt++;
    }
    if(root.left!=null){
      goodNodes(root.left, Math.max(root.val, max));
    }
    if(root.right!=null){
      goodNodes(root.right, Math.max(root.val, max));
    }
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
