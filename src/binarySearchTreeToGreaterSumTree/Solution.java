package binarySearchTreeToGreaterSumTree;

public class Solution {
    // 1ms solution, meet avg speed.
    private int total = 0;
    public TreeNode bstToGst(TreeNode root) {
	if (root != null) {
	    bstToGst(root.right);
	    total += root.val;
	    root.val = total;
	    bstToGst(root.left);
	}
	return root;
    }

    public static class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	TreeNode n1 = new TreeNode(4);
	TreeNode n2 = new TreeNode(1);
	TreeNode n3 = new TreeNode(6);
	TreeNode n4 = new TreeNode(0);
	TreeNode n5 = new TreeNode(2);
	TreeNode n6 = new TreeNode(5);
	TreeNode n7 = new TreeNode(7);
	TreeNode n8 = new TreeNode(3);
	TreeNode n9 = new TreeNode(8);
	n1.left = n2;
	n1.right = n3;
	n2.left = n4;
	n2.right = n5;
	n3.left = n6;
	n3.right = n7;
	n5.right = n8;
	n7.right = n9;
	s.bstToGst(n1);

    }
}
