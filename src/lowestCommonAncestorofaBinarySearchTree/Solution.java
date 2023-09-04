package lowestCommonAncestorofaBinarySearchTree;

import java.util.*;
/*
Runtime
5 ms
Beats
98.83%
Memory
43.6 MB
Beats
89.74%
 */
public class Solution {
    private Set<Integer> hasP = new HashSet<>();
    private Set<Integer> hasQ = new HashSet<>();
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        checkTarget(root, p, hasP);
        checkTarget(root, q, hasQ);

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode res = root;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0; i<size; i++) {
                TreeNode cur = queue.poll();
                res = cur;
                if (cur.left !=null && hasP.contains(cur.left.val) && hasQ.contains(cur.left.val)) {
                    queue.add(cur.left);
                }
                if (cur.right !=null && hasP.contains(cur.right.val) && hasQ.contains(cur.right.val)) {
                    queue.add(cur.right);
                }
            }
        }
        return res;
    }

    private boolean checkTarget(TreeNode node, TreeNode target, Set<Integer> set) {
        if (node.val == target.val) {
            set.add(node.val);
            return true;
        }
        boolean res = false;
        if (node.left !=null) {
            if (res = checkTarget(node.left, target, set)) {
                set.add(node.val);
            }
        }
        if (!res && node.right != null) {
            if (res = checkTarget(node.right, target, set)) {
                set.add(node.val);
            }
        }
        return res;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
