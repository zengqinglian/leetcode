package longestZigzagPathInaBinaryTree;


//time over solution failed on 56/58
public class Solution {
    int res = 0;
    public int longestZigZag(TreeNode root) {
        if(root.left == null && root.right==null){
            res = Math.max(res, 0);
        }
        if(root.left!=null){
            res = Math.max(res, 1 + longestZigZag(root.left, -1));
            longestZigZag(root.left);
        }
        if(root.right!=null){
            res = Math.max(res, 1 + longestZigZag(root.right, 1));
            longestZigZag(root.right);
        }
        return res;
    }

    public int longestZigZag(TreeNode root, int index) {
        if(index < 0){
            if(root.right == null){
                return 0;
            }else{
                return 1 + longestZigZag(root.right, -index);

            }
        }else{
            if(root.left == null){
                return 0;
            }else{
                return 1 + longestZigZag(root.left, -index);
            }
        }
    }

    private static class TreeNode {
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
