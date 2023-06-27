package trimaBinarySearchTree;
/*
Runtime
133 ms
Beats
100%
Memory
44.3 MB
Beats
32.67%
 */
public class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root.val >= low && root.val <= high) {
            if (root.left!=null) {
                root.left = trimBST(root.left, low, high);
            }
            if (root.right != null) {
                root.right = trimBST(root.right, low, high);
            }
            return root;
        }else if (root.val < low) {
            if (root.right != null) {
                return trimBST(root.right, low, high);
            }else {
                return null;
            }
        } else  {
            if (root.left!=null) {
                return trimBST(root.left, low, high);
            }else{
                return null;
            }
        }
    }



    private static  class TreeNode {
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
