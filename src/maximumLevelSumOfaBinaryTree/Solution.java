package maximumLevelSumOfaBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    //9ms solution , beat 50%
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int max = Integer.MIN_VALUE;
        int level = 1;
        int res = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int sum = 0;
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                sum += node.val;
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            if(sum > max){
                res = level;
                max = sum;
            }
            level++;
        }
        return res;
    }

    private static class TreeNode{
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }
}
