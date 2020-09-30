package deleteLeavesWithaGivenValue;

public class Solution {
    //0ms solution, meet 50%
    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root== null){
            return null;
        }
        if(root.left == null && root.right==null){
            if(root.val == target)
                return null;
            else
                return root;
        }else {
            root.left = removeLeafNodes(root.left, target);
            root.right = removeLeafNodes(root.right,target);
            if(root.val!=target){
                return root;
            }else{
                if(root.left==null && root.right==null){
                    return null;
                }else{
                    return root;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();

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
