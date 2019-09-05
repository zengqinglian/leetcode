package maximumDifferenceBetweenNodeAndAncestor;

//someone's 0ms solution
public class Solution1 {
    int diff = 0;

    public int maxAncestorDiff(TreeNode root) {
	if (root == null)
	    return 0;
	int min = root.val, max = root.val;
	diff(root, min, max);
	return diff;
    }

    public void diff(TreeNode root, int min, int max) {
	if (root == null)
	    return;
	diff = Math.max(diff, Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));
	min = Math.min(min, root.val);
	max = Math.max(max, root.val);
	diff(root.left, min, max);
	diff(root.right, min, max);
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
