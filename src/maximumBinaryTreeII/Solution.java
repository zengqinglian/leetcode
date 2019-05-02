package maximumBinaryTreeII;

public class Solution {
    // Solution meet avg speed.
    public TreeNode insertIntoMaxTree(TreeNode root, int val) {
	if (root == null) {
	    return new TreeNode(val);
	}

	if (val > root.val) {
	    TreeNode newRoot = new TreeNode(val);
	    newRoot.left = root;
	    return newRoot;
	}

	if (root.right == null) {
	    TreeNode right = new TreeNode(val);
	    root.right = right;
	    return root;
	}

	TreeNode newRight = insertIntoMaxTree(root.right, val);
	root.right = newRight;
	return root;

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
