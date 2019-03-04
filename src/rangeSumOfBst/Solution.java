package rangeSumOfBst;

public class Solution {
    // 2ms solution, beat 100%
    public int rangeSumBST(TreeNode root, int L, int R) {
	if (root == null) {
	    return 0;
	}
	int sum = 0;
	if (root.val >= L && root.val <= R) {
	    sum += root.val;
	}

	if (root.left != null && root.val >= L) {
	    sum += rangeSumBST(root.left, L, R);
	}
	if (root.right != null && root.val <= R) {
	    sum += rangeSumBST(root.right, L, R);
	}

	return sum;
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
