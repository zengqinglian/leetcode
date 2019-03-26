package checkCompletenessOfABinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    // 1ms meet avg speed.
    public boolean isCompleteTree(TreeNode root) {
	if(root == null) {
	    return true;
	}
	Queue<TreeNode> queue = new LinkedList<>();
	
	queue.add(root);
	boolean ending = false;
	while(!queue.isEmpty()) {
	    int size = queue.size();
	    for(int i=0; i<size; i++) {
		TreeNode n = queue.poll();
		if (n.left == null && n.right != null) {
		    return false;
		}
		if (n.left != null) {
		    if (ending) {
			return false;
		    }
		    queue.add(n.left);
		}

		if (n.right != null) {
		    queue.add(n.right);
		} else {
		    if (!ending) {
			ending = true;
		    }
		}
	    }
	}
	return true;
    }

 private static class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }
}
