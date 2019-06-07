package mergeTwoBinaryTrees;

public class Solution1 {
    // 1ms solution , meet avg speed.
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
	if (t1 == null && t2 == null) {
	    return null;
	}

	int val = (t1 == null ? 0 : t1.val) + (t2 == null ? 0 : t2.val);
	TreeNode newRoot = new TreeNode(val);

	TreeNode left1 = t1 == null ? null : t1.left;
	TreeNode left2 = t2 == null ? null : t2.left;

	TreeNode right1 = t1 == null ? null : t1.right;
	TreeNode right2 = t2 == null ? null : t2.right;

	if (left1 != null || left2 != null) {
	    newRoot.left = mergeTrees(left1, left2);
	}

	if (right1 != null || right2 != null) {
	    newRoot.right = mergeTrees(right1, right2);
	}


	return newRoot;
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
