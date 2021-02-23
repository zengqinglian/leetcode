package balanceaBinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/*
Runtime: 2 ms, faster than 99.87% of Java online submissions for Balance a Binary Search Tree.
Memory Usage: 41.4 MB, less than 79.97% of Java online submissions for Balance a Binary Search Tree.
 */
public class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        treeToList(root, list);
        return createTree(list, 0, list.size()-1);
    }

    private TreeNode createTree(List<TreeNode> list, int start, int end) {
        if(start == end){
            TreeNode node = list.get(start);
            node.left = null;
            node.right = null;
            return node;
        }
        int mid = (start+ end) / 2;
        TreeNode node = list.get(mid);
        node.left = null;
        node.right = null;
        if(mid!=start){
            node.left = createTree(list, start, mid-1);
        }
        node.right = createTree(list, mid+1, end);
        return node;
    }

    private void treeToList(TreeNode root, List<TreeNode> list) {
        if(root.left!=null){
            treeToList(root.left, list);
        }
        list.add(root);
        if(root.right!=null){
            treeToList(root.right, list);
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
