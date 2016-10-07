package flattenBinaryTreetoLinkedList;

public class Solution {
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            return;
        }

        if (root.left == null && root.right != null) {
            flatten(root.right);
            return;
        }

        if (root.left != null && root.right == null) {
            flatten(root.left);
            root.right = root.left;
            root.left = null;
            return;
        }

        if (root.left != null && root.right != null) {
            flatten(root.left);
            flatten(root.right);
            getLast(root.left).right = root.right;
            root.right = root.left;
            root.left = null;
            return;
        }

    }

    private TreeNode getLast(TreeNode node) {

        TreeNode returnNode = node;
        while (returnNode.right != null) {
            returnNode = returnNode.right;
        }

        return returnNode;
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n6;

        Solution s = new Solution();
        s.flatten(n1);
        System.out.println(n1);
    }
}
