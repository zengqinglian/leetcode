package sumofNodeswithEvenValuedGrandparent;



public class Solution1 {
    //1ms solution, meet avg
    int sum = 0;
    public int sumEvenGrandparent(TreeNode root) {
        sumHelper(null, root);
        return sum;
    }

    private void sumHelper(TreeNode parent, TreeNode node){
        if(parent!=null && parent.val %2 ==0){
            if(node.left!=null){
                sum+=node.left.val;
                sumHelper(node,node.left);
            }
            if(node.right!=null){
                sum+=node.right.val;
                sumHelper(node,node.right);
            }
        }else{
            if(node.left!=null){
                sumHelper(node, node.left);
            }
            if(node.right!=null){
                sumHelper(node, node.right);
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
