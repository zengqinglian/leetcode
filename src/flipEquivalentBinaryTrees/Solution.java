package flipEquivalentBinaryTrees;

public class Solution {
    // 2ms solution , meet avg speed.
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
	if (root1 == null && root2 == null) {
	    return true;
	}

	if (root1 != null && root2 != null && root1.val == root2.val) {
	    if ((flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right))
		    || (flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left))) {
		return true;
	    }

	}

	return false;

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
