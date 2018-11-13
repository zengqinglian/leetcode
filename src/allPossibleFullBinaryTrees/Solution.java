package allPossibleFullBinaryTrees;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 9ms solution , meet avg speed.
    public List<TreeNode> allPossibleFBT(int N) {
	List<TreeNode> result = new ArrayList<>();
	if (N == 1) {
	    TreeNode root = new TreeNode(0);
	    result.add(root);
	    return result;
	}
	if (N % 2 == 0) {
	    return result;
	}

	for (int i = 2; i < N; i = i + 2) {
	    List<TreeNode> lefts = allPossibleFBT(i - 1);
	    List<TreeNode> rights = allPossibleFBT(N - i);
	    for (TreeNode left : lefts) {
		for (TreeNode right : rights) {
		    TreeNode root = new TreeNode(0);
		    root.left = left;
		    root.right = right;
		    result.add(root);
		}
	    }
	}

	return result;
    }



    public static class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
	    val = x;
	}
    }

    public static void main(String[] args) {
	Solution s = new Solution();
	s.allPossibleFBT(7);
    }

}
