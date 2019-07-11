package deleteNodesAndReturnForest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    // 2ms solution , beat 95%
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
	Set<Integer> delSet = new HashSet<>();

	for (int d : to_delete) {
	    delSet.add(d);
	}
	List<TreeNode> li = new ArrayList<>();
	updateList(root, delSet, li, null);
	return li;
    }

    private void updateList(TreeNode node, Set<Integer> delSet, List<TreeNode> result, TreeNode parent) {
	if (delSet.contains(node.val)) {
	    if (parent != null && parent.left != null && parent.left.val == node.val) {
		parent.left = null;
	    }
	    if (parent != null && parent.right != null && parent.right.val == node.val) {
		parent.right = null;
	    }
	    if (node.left != null) {
		updateList(node.left, delSet, result, null);
	    }
	    if (node.right != null) {
		updateList(node.right, delSet, result, null);
	    }
	} else {
	    if (node.left != null) {
		updateList(node.left, delSet, result, node);
	    }
	    if (node.right != null) {
		updateList(node.right, delSet, result, node);
	    }
	    if (parent == null) {
		result.add(node);
	    }
	}
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
