package smallestSubtreewithalltheDeepestNodes;

public class Solution1 {
    //recursion - fast solution 
    

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
	return dfs(root).node;
    }

    // Return the result of the subtree at this node.
    public Result dfs(TreeNode node) {
	if (node == null)
	    return new Result(null, 0);
	Result L = dfs(node.left), R = dfs(node.right);
	if (L.dist > R.dist)
	    return new Result(L.node, L.dist + 1);
	if (L.dist < R.dist)
	    return new Result(R.node, R.dist + 1);
	return new Result(node, L.dist + 1);
    }

    private static class Result {
	private TreeNode node;
	private int dist;

	public Result(TreeNode node, int dist) {
	    this.node = node;
	    this.dist = dist;
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

    public static void main(String[] args) {
	Solution1 s = new Solution1();
	TreeNode n0 = new TreeNode(0);
	TreeNode n1 = new TreeNode(1);
	TreeNode n2 = new TreeNode(2);
	TreeNode n3 = new TreeNode(3);
	// TreeNode n4 = new TreeNode(4);
	// TreeNode n5 = new TreeNode(5);
	// TreeNode n6 = new TreeNode(6);
	// TreeNode n7 = new TreeNode(7);
	// TreeNode n8 = new TreeNode(8);
	// n3.left = n5;
	// n3.right = n1;
	// n5.left = n6;
	// n5.right = n2;
	// n2.left = n7;
	// n2.right = n4;
	// n1.left = n0;
	// n1.right = n8;
	n0.left = n1;
	n1.left = n3;
	n1.right = n2;

	s.subtreeWithAllDeepest(n0);
    }

}
