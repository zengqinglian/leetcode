package insertIntoaBinarySearchTree;

public class Solution {
    // 0ms solution meet avg
    public TreeNode insertIntoBST(TreeNode root, int val) {
	if (root.val > val) {
	    if (root.left == null) {
		TreeNode node = new TreeNode(val);
		root.left = node;
	    } else {
		insertIntoBST(root.left, val);
	    }
	} else {
	    if (root.right == null) {
		TreeNode node = new TreeNode(val);
		root.right = node;
	    } else {
		insertIntoBST(root.right, val);
	    }

	}

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
