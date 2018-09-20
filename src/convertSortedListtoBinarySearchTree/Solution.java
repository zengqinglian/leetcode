package convertSortedListtoBinarySearchTree;

public class Solution {
    // 3ms solution - beat 10%
    public TreeNode sortedListToBST(ListNode head) {
	ListNode cur = head;
	if(cur==null) {
	    return null;
	}
	TreeNode root = new TreeNode(cur.val);
	TreeNode curTree = root;
	int count = 1;
	int left = 0;
	int right = 0;
	while (cur.next != null) {
	    cur = cur.next;
	    TreeNode R = new TreeNode(cur.val);
	    curTree.right = R;
	    count++;
	    right++;
	    curTree = R;
	    if (count % 2 == 1 && right - left >= 2) {
		root = rotateRight(root);
		left++;
		right--;
	    }
	}
	
	root.left = convertLeft(root.left);
	root.right = convertRight(root.right);

	return root;
    }

    private TreeNode convertRight(TreeNode root) {
	if (root == null) {
	    return null;
	}
	TreeNode newRoot = root;
	TreeNode cur = root;
	int count = 1;
	int left = 0;
	int right = 0;
	while (cur.right != null) {
	    cur = cur.right;
	    count++;
	    right++;
	    if (count % 2 == 1 && right - left >= 2) {
		newRoot = rotateRight(newRoot);
		left++;
		right--;
	    }
	}
	newRoot.left = convertLeft(newRoot.left);
	newRoot.right = convertRight(newRoot.right);
	return newRoot;
    }

    private TreeNode convertLeft(TreeNode root) {
	if (root == null) {
	    return null;
	}
	TreeNode newRoot = root;
	TreeNode cur = root;
	int count =1;
	int left = 0, right = 0;
	while (cur.left != null) {
	    cur = cur.left;
	    count++;
	    left++;
	    if (count % 2 == 1 && left - right >= 2) {
		newRoot = rotateLeft(newRoot);
		right++;
		left--;
	    }
	}
	newRoot.left = convertLeft(newRoot.left);
	newRoot.right = convertRight(newRoot.right);
	return newRoot;
	
    }

    private TreeNode rotateLeft(TreeNode root) {
	TreeNode newRoot = root.left;
	newRoot.right = root;
	root.left = null;
	return newRoot;
    }

    private TreeNode rotateRight(TreeNode root) {
	TreeNode newRoot = root.right;
	newRoot.left = root;
	root.right = null;
	return newRoot;
    }

    private static class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
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
	ListNode node1 = new ListNode(-10);
	ListNode node2 = new ListNode(-3);
	ListNode node3 = new ListNode(0);
	ListNode node4 = new ListNode(5);
	ListNode node5 = new ListNode(9);
	ListNode node6 = new ListNode(11);
	ListNode node7 = new ListNode(12);
	ListNode node8 = new ListNode(13);
	ListNode node9 = new ListNode(14);
	ListNode node10 = new ListNode(15);

	node1.next = node2;
	node2.next = node3;
	node3.next = node4;
	node4.next = node5;
	node5.next = node6;
	node6.next = node7;
	node7.next = node8;
	node8.next = node9;
	node9.next = node10;

	Solution s = new Solution();
	s.sortedListToBST(node1);

    }
}
