package binaryTreePruning;

public class Solution {
    // 2ms meet avg speed solution - recursive
    public TreeNode pruneTree(TreeNode root) {
	if (checkTree(root)) {
	    return null;
	}

	return root;
    }

    private boolean checkTree(TreeNode root) {
	if(root.val ==0) {
	    boolean leftTreeMatch = true;
	    boolean rightTreeMatch = true;
	    if (root.left != null) {
		if (checkTree(root.left)) {
		    root.left = null;
		} else {
		    leftTreeMatch = false;
		}
	    }
	    if (root.right != null) {
		if (checkTree(root.right)) {
		    root.right = null;
		} else {
		    rightTreeMatch = false;
		}
	    }

	    return leftTreeMatch && rightTreeMatch;
	}else {
	    if (root.left != null) {
		if (checkTree(root.left)) {
		    root.left = null;
		}
	    }
	    if (root.right != null) {
		if (checkTree(root.right)) {
		    root.right = null;
		}
	    }
	    return false;
	}
    }

    public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }
}
