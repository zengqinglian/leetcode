package deepestLeavesSum;

import javax.swing.tree.TreeNode;

//1ms solution, beat 90%
public class Solution {
    private int level;
    private int sum;
    public int deepestLeavesSum(TreeNode root) {
        getChild(root, 0);
        return sum;
    }

    private void getChild(TreeNode root, int level ){
        if(level == this.level){
            sum+=root.val;
        }else if(level>this.level){
            this.level = level;
            sum = root.val;
        }else{
            //nothing
        }
        if(root.left!=null){
            getChild(root.left, level+1);
        }
        if(root.right!=null){
            getChild(root.right, level+1);
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
