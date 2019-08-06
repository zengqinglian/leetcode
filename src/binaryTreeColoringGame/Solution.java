package binaryTreeColoringGame;

//1ms solution  , beat 100%
public class Solution {
    int cnt = 0;
    public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
	TreeNode node = findNode(root, x);
	int cnt = countNode(node);
	if(n-cnt>cnt) {
	    return true;
	}

	int cntleft = countNode(node.left);
	int cntRight = countNode(node.right);
	if (cntleft > n - cntleft || cntRight > n - cntRight) {
		return true;

	}
	return false;
    }

    private int countNode(TreeNode node) {
	if (node == null) {
	    return 0;
	}

	return 1 + countNode(node.left) + countNode(node.right);
    }

    private TreeNode findNode(TreeNode root, int x) {
	if (root.val == x) {
	    return root;
	} else {
	    if (root.left != null) {
		TreeNode res = findNode(root.left, x);
		if (res != null) {
		    return res;
		}

	    }

	    if (root.right != null) {
		TreeNode res = findNode(root.right, x);
		if (res != null) {
		    return res;
		}
	    }

	}
	return null;
    }

    private static class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	TreeNode n6 = new TreeNode(6);
	TreeNode n3 = new TreeNode(3);
	TreeNode n7 = new TreeNode(7);
	TreeNode n4 = new TreeNode(4);
	TreeNode n2 = new TreeNode(2);
	TreeNode n1 = new TreeNode(1);
	TreeNode n5 = new TreeNode(5);

	n6.left = n3;
	n3.left = n7;
	n3.right = n4;
	n4.right = n2;
	n2.right = n1;
	n1.right = n5;

	s.btreeGameWinningMove(n6, 7, 3);
    }
}
