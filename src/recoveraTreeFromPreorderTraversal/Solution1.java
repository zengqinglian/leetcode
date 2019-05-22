package recoveraTreeFromPreorderTraversal;

public class Solution1 {
    // Someone's recursive solution, beat 100%
    public TreeNode recoverFromPreorder(String S) {
	return recover(S, new int[] { 0 }, 0);
    }

    public TreeNode recover(String s, int[] i, int d) {

	if (i[0] >= s.length())
	    return null;
	int cur = i[0], d1 = 0;
	while (cur < s.length() && s.charAt(cur) == '-') {
	    d1++;
	    cur++;
	}
	if (d1 != d) {
	    return null;
	}
	int x = 0;
	while (cur < s.length() && Character.isDigit(s.charAt(cur))) {
	    x = x * 10 + (s.charAt(cur++) - '0');
	}
	i[0] = cur;
	TreeNode node = new TreeNode(x);
	node.left = recover(s, i, d + 1);
	node.right = recover(s, i, d + 1);
	return node;
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
