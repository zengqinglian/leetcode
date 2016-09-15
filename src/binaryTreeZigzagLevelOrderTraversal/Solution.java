package binaryTreeZigzagLevelOrderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        List<TreeNode> nextLevel = new ArrayList<>();
        if (root.left != null) {
            nextLevel.add(root.left);
        }

        if (root.right != null) {
            nextLevel.add(root.right);
        }
        result.add(list);

        traversal(nextLevel, result, true);

        return result;

    }

    private void traversal(List<TreeNode> nodes, List<List<Integer>> result, boolean isR2L) {
        if (nodes.isEmpty()) {
            return;
        }
        List<TreeNode> nextLevel = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();

        for (int i = nodes.size() - 1; i >= 0; i--) {
            temp.add(nodes.get(i).val);
            if (isR2L) {
                if (nodes.get(i).right != null) {
                    nextLevel.add(nodes.get(i).right);
                }
                if (nodes.get(i).left != null) {
                    nextLevel.add(nodes.get(i).left);
                }
            } else {
                if (nodes.get(i).left != null) {
                    nextLevel.add(nodes.get(i).left);
                }

                if (nodes.get(i).right != null) {
                    nextLevel.add(nodes.get(i).right);
                }
            }
        }

        result.add(temp);
        traversal(nextLevel, result, !isR2L);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        root.left = node2;
        root.right = node3;
        node2.left = node4;
        node3.right = node5;

        s.zigzagLevelOrder(root);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
