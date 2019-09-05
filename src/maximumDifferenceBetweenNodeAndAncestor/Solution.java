package maximumDifferenceBetweenNodeAndAncestor;

//1ms solution , beat 40%
public class Solution {
    int res = 0;
    public int maxAncestorDiff(TreeNode root) {
	postOrderTraversal(root);
	return res;
    }

    private int[] postOrderTraversal(TreeNode root) {
	int[] l = null;
	int[] r = null;
	if (root.left != null) {
	    l = postOrderTraversal(root.left);
	}
	if (root.right != null) {
	    r = postOrderTraversal(root.right);
	}

	int[] result = { 100000, 0 };
	if (l != null) {
	    result[0] = Math.min(result[0], l[0]);
	    result[1] = Math.max(result[1], l[1]);
	}
	if (r != null) {
	    result[0] = Math.min(result[0], r[0]);
	    result[1] = Math.max(result[1], r[1]);
	}

	if (root.left != null || root.right != null) {
	    res = Math.max(res, Math.abs(root.val - result[0]));
	    res = Math.max(res, Math.abs(root.val - result[1]));
	}

	result[0] = Math.min(result[0], root.val);
	result[1] = Math.max(result[1], root.val);

	return result;

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
