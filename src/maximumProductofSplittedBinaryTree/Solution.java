package maximumProductofSplittedBinaryTree;

//8ms solution, meet avg 50%
public class Solution {
  long max = 0;
  long mod = 1_000_000_000+7;
  public int maxProduct(TreeNode root) {
    long total = sum(root);
    traversal(root,total);
    return (int)(max % mod);
  }

  private void traversal(TreeNode node, long total){
    if(node.left !=null){
      traversal(node.left, total);
    }
    long prod = (total - node.val) * node.val;
    System.out.println(prod);
    max = Math.max(max, prod);
    if(node.right!=null){
      traversal(node.right, total);
    }
  }

  private int sum(TreeNode node){
    if(node.left == null && node.right == null){
      return node.val;
    }
    if(node.left!=null){
      node.val = node.val + sum(node.left);
    }
    if(node.right!=null){
      node.val = node.val + sum(node.right);
    }
    return node.val;
  }



  public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
      this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}
