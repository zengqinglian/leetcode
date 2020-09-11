package sumofNodeswithEvenValuedGrandparent;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //7ms solution, beat 10%
    public int sumEvenGrandparent(TreeNode root) {
        int sum = 0;
        Queue<HelpNode> q = new LinkedList<>();
        HelpNode rootHelp = new HelpNode(root);
        rootHelp.isParentEven = false;

        q.add(rootHelp);
        while(!q.isEmpty()){
            HelpNode node = q.poll();
            if(node.treeNode.val % 2 == 0){
                if(node.treeNode.left !=null){
                    HelpNode leftNode = new HelpNode(node.treeNode.left);
                    leftNode.isParentEven = true;
                    q.add(leftNode);
                    if(node.isParentEven){
                        sum+=node.treeNode.left.val;
                    }
                }
                if(node.treeNode.right !=null){
                    HelpNode rightNode = new HelpNode(node.treeNode.right);
                    rightNode.isParentEven = true;
                    q.add(rightNode);
                    if(node.isParentEven){
                        sum+=node.treeNode.right.val;
                    }
                }
            }else{
                if(node.treeNode.left !=null){
                    HelpNode leftNode = new HelpNode(node.treeNode.left);
                    leftNode.isParentEven = false;
                    q.add(leftNode);
                    if(node.isParentEven){
                        sum+=node.treeNode.left.val;
                    }
                }
                if(node.treeNode.right !=null){
                    HelpNode rightNode = new HelpNode(node.treeNode.right);
                    rightNode.isParentEven = false;
                    q.add(rightNode);
                    if(node.isParentEven){
                        sum+=node.treeNode.right.val;
                    }
                }
            }
        }
        return sum;
    }

    private static class HelpNode{
        private TreeNode treeNode;
        private boolean isParentEven;

        HelpNode(TreeNode node){
            this.treeNode = node;
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
