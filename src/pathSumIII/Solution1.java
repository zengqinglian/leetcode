package pathSumIII;

import removeDuplicateLetters.Solution;

import java.util.ArrayList;
import java.util.List;
/*
Runtime
27 ms
Beats
25.76%
Memory
45.3 MB
Beats
5.34%
 */
public class Solution1 {
    private int count= 0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        traversal(root, targetSum);
        return count;
    }

    private List<Long> traversal(TreeNode node, int targetSum) {
        if (node.left == null && node.right == null) {
            List<Long> res= new ArrayList<>();
            res.add((long)node.val);
            if (node.val == targetSum) {
                count++;
            }
            return res;
        }
        List<Long> newList = new ArrayList<>();
        if (node.left != null) {
            List<Long> list = traversal(node.left, targetSum);
            for (int i=0; i<list.size(); i++) {
                long newVal = list.get(i) + node.val;
                if (newVal == targetSum) {
                    count++;
                }
                newList.add( newVal);
            }
        }

        if (node.right != null) {
            List<Long> list = traversal(node.right, targetSum);
            for (int i=0; i<list.size(); i++) {
                long newVal = list.get(i) + node.val;
                if (newVal == targetSum) {
                    count++;
                }
                newList.add(newVal);
            }
        }
        newList.add((long)node.val);
        if (node.val == targetSum) {
            count++;
        }
        return newList;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(10);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(-3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(2);
        TreeNode node6 = new TreeNode(11);
        TreeNode node7 = new TreeNode(3);
        TreeNode node8 = new TreeNode(-2);
        TreeNode node9 = new TreeNode(1);

        node1.left = node2;
        node1.right=node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node7;
        node4.right = node8;
        node3.right = node6;

        Solution1 s = new Solution1();
        s.pathSum(node1,8);


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
