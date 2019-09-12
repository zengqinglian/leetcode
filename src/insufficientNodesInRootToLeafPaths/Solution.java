package insufficientNodesInRootToLeafPaths;

public class Solution {
    // 1ms solution , beat 100%
    public TreeNode sufficientSubset(TreeNode root, int limit) {
	calculateAndRestructure(root, limit);
	if (root.left == null && root.right == null && root.val < limit) {
	    return null;
	}
	return root;
    }

    private TreeNode calculateAndRestructure(TreeNode root, int limit) {
	if (root.left == null && root.right == null) {
	    if (root.val < limit) {
		return null;
	    }
	    return root;
	}
	if (root.left != null) {
	    root.left = calculateAndRestructure(root.left, limit - root.val);
	}
	if (root.right != null) {
	    root.right = calculateAndRestructure(root.right, limit - root.val);
	}

	if (root.left == null && root.right == null) {
	    return null;
	} else {
	    return root;
	}
    }

    private static class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}

    }

    public static void main(String[] args) {
	Solution s = new Solution();
	TreeNode n1 = new TreeNode(1);
	TreeNode n2 = new TreeNode(2);
	TreeNode n3 = new TreeNode(3);
	TreeNode n4 = new TreeNode(4);
	TreeNode n5 = new TreeNode(-99);
	TreeNode n6 = new TreeNode(-99);
	TreeNode n7 = new TreeNode(7);
	TreeNode n8 = new TreeNode(8);
	TreeNode n9 = new TreeNode(9);
	TreeNode n10 = new TreeNode(98);
	TreeNode n11 = new TreeNode(-99);
	TreeNode n12 = new TreeNode(12);
	TreeNode n13 = new TreeNode(13);
	TreeNode n14 = new TreeNode(-99);
	TreeNode n15 = new TreeNode(14);
	n1.left = n2;
	n1.right = n3;
	n2.left = n4;
	n2.right = n5;
	n3.left = n6;
	n3.right = n7;
	n4.left = n8;
	n4.right = n9;
	n5.left = n10;
	n5.right = n11;
	n6.left = n12;
	n6.right = n13;
	n7.left=n14;
	n7.right = n15;
	s.sufficientSubset(n1, 1);
	   
    }
}
