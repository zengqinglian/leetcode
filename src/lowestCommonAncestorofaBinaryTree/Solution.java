package lowestCommonAncestorofaBinaryTree;

import java.util.ArrayList;
import java.util.List;

//over time memory limit solution
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode common = root;
        List<TreeNode> routeP = new ArrayList<>();
        getRoute(root, p, new ArrayList<TreeNode>(), routeP);

        List<TreeNode> routeQ = new ArrayList<>();
        getRoute(root, p, new ArrayList<TreeNode>(), routeQ);

        for (TreeNode node : routeP) {
            if (routeQ.contains(node)) {
                common = node;
            }
        }
        return common;

    }

    private void getRoute(TreeNode node, TreeNode target, List<TreeNode> temp, List<TreeNode> route) {
        temp.add(node);
        if (node == target) {
            route.addAll(temp);
        } else {
            if (node.left != null) {
                List<TreeNode> newTemp = new ArrayList<>(temp);
                getRoute(node.left, target, newTemp, route);
            }
            if (node.right != null) {
                List<TreeNode> newTemp = new ArrayList<>(temp);
                getRoute(node.right, target, newTemp, route);
            }
        }

    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode t0 = new TreeNode(0);
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        t3.left = t5;
        t3.right = t1;
        t5.left = t6;
        t5.right = t2;
        t2.left = t7;
        t2.right = t4;
        t3.right = t1;
        t1.left = t0;
        t1.right = t8;
        s.lowestCommonAncestor(t3, t7, t6);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }
}
