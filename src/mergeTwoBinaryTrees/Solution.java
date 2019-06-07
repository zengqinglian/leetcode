package mergeTwoBinaryTrees;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // 4ms solution , beat 30%
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
	if (t1 == null && t2 == null) {
	    return null;
	}
	Queue<TreeNode> q = new LinkedList<>();
	q.add(t1);
	q.add(t2);
	Queue<TreeNode> newTree = new LinkedList<>();
	int val = (t1 == null ? 0:t1.val) + (t2==null? 0:t2.val);
	TreeNode newRoot = new TreeNode(val);
	newTree.add(newRoot);
	while (!q.isEmpty()) {
	    TreeNode n1 = q.poll();
	    TreeNode n2 = q.poll();

	    TreeNode left1 = n1 == null ? null : n1.left;
	    TreeNode left2 = n2 == null ? null : n2.left;

	    TreeNode right1 = n1 == null ? null : n1.right;
	    TreeNode right2 = n2 == null ? null : n2.right;

	    TreeNode node = newTree.poll();
	    if (left1 != null || left2 != null) {
		int newVal = (left1 == null ? 0 : left1.val) + (left2 == null ? 0 : left2.val);
		TreeNode newLeft = new TreeNode(newVal);
		node.left = newLeft;
		newTree.add(newLeft);
		q.add(left1);
		q.add(left2);
	    }
	    if (right1 != null || right2 != null) {
		int newVal = (right1 == null ? 0 : right1.val) + (right2 == null ? 0 : right2.val);
		TreeNode newRight = new TreeNode(newVal);
		node.right = newRight;
		newTree.add(newRight);
		q.add(right1);
		q.add(right2);
	    }
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
