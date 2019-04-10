package flipBinaryTreeToMatchPreorderTraversal;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 1ms solution , beat 90%
    private int index = 0;
    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
	List<Integer> list = new ArrayList<>();

	if (checkVoyage(root, voyage, list)) {
	    return list;
	}

	list.clear();
	list.add(-1);

	return list;


    }

    private boolean checkVoyage(TreeNode root, int[] voyage, List<Integer> result) {
	if(index >= voyage.length) {
	    return false;
	}
	if (root.val != voyage[index]) {
	    return false;
	}

	int curindex = index;
	boolean res = true;
	if(root.left != null) {
	    index++;
	    res = checkVoyage(root.left, voyage, result);
	}

	if (res && root.right != null) {
	    index++;
	    res = checkVoyage(root.right, voyage, result);
	}
	
	if (res) {
	    return true;
	}
	
	index = curindex;

	if (root.right != null) {
	    index++;
	    if (root.left != null)
		result.add(root.val);
	    res = checkVoyage(root.right, voyage, result);
	}

	if (res && root.left != null) {
	    index++;
	    res = checkVoyage(root.left, voyage, result);
	}



	return res;

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
	TreeNode n1 = new TreeNode(1);
	TreeNode n2 = new TreeNode(2);
	TreeNode n3 = new TreeNode(3);
	TreeNode n4 = new TreeNode(4);
	TreeNode n5 = new TreeNode(5);
	TreeNode n6 = new TreeNode(6);
	TreeNode n7 = new TreeNode(7);
	n2.left = n3;
	n2.right = n6;
	n3.left = n4;
	n4.left = n7;
	n4.right = n5;
	n7.right = n1;
	// n1.right = n3;
	// n3.left = n4;
	// n3.right = n5;
	int[] voyage = { 2, 6, 3, 4, 5, 7, 1 };
	s.flipMatchVoyage(n2, voyage);
    }
}
