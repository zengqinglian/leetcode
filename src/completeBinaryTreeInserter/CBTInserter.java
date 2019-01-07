package completeBinaryTreeInserter;

import java.util.LinkedList;
import java.util.Queue;

//120ms solution beat 20%
public class CBTInserter {
    private TreeNode root;
    private Queue<TreeNode> q = new LinkedList<>();

    public CBTInserter(TreeNode root) {
	this.root = root;
	q.add(root);

	while (!q.isEmpty()) {
	    TreeNode n = q.peek();
	    if (n.left != null && n.right != null) {
		q.poll();
		q.add(n.left);
		q.add(n.right);
	    } else {
		if (n.left != null) {
		    q.add(n.left);
		}
		break;
	    }
	}
    }

    public int insert(int v) {
	TreeNode n = q.peek();
	if (n.left == null) {
	    TreeNode newNode = new TreeNode(v);
	    n.left = newNode;
	    q.add(newNode);
	} else {
	    TreeNode newNode = new TreeNode(v);
	    n.right = newNode;
	    q.add(newNode);
	    q.poll();
	}
	return n.val;
    }

    public TreeNode get_root() {
	return root;
    }

    public static class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    /**
     * Your CBTInserter object will be instantiated and called as such: CBTInserter
     * obj = new CBTInserter(root); int param_1 = obj.insert(v); TreeNode param_2 =
     * obj.get_root();
     */
}
