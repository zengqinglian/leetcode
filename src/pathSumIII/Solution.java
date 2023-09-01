package pathSumIII;

import java.util.ArrayList;
import java.util.List;
/*
Runtime
29 ms
Beats
25.39%
Memory
52.6 MB
Beats
5.34%
 */
public class Solution {
    private int count= 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        traversal(root, targetSum, new ArrayList<>());
        return count;
    }

    private void traversal(TreeNode node, int targetSum, List<Long> sums) {
        for(int i=0; i<sums.size(); i++) {
            long newval = sums.get(i)+node.val;
            if (newval == targetSum) {
                count++;
            }
            sums.set(i, newval);
        }
        if (node.val == targetSum) {
            count++;
        }
        sums.add((long)node.val);
        if (node.left != null) {
            traversal(node.left, targetSum, new ArrayList<>(sums));
        }
        if (node.right != null) {
            traversal(node.right, targetSum, new ArrayList<>(sums));
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
