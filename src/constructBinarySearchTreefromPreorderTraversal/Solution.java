package constructBinarySearchTreefromPreorderTraversal;

import java.util.Stack;

public class Solution {
    // 1ms solution , beat 50%
    public TreeNode bstFromPreorder(int[] preorder) {
	Stack<TreeNode> stack = new Stack<>();
	TreeNode head = new TreeNode(preorder[0]);
	stack.add(head);
	for (int i = 1; i < preorder.length; i++) {
	    if (preorder[i] < stack.peek().val) {
		TreeNode left = new TreeNode(preorder[i]);
		stack.peek().left = left;
		stack.push(left);
	    } else {
		TreeNode right = new TreeNode(preorder[i]);
		TreeNode parent = null;
		while (!stack.isEmpty() && stack.peek().val < preorder[i]) {
		    parent = stack.pop();
		}
		parent.right = right;
		stack.push(right);
	    }
	}
	
	return head;
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
