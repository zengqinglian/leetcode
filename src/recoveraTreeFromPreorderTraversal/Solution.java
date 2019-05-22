package recoveraTreeFromPreorderTraversal;

import java.util.Stack;

public class Solution {
    // 8ms solution , meet avg speed.
    public TreeNode recoverFromPreorder(String S) {
	int[] rootPos = readNextValue(0, S);
	int rootVal = rootPos[0];
	TreeNode root = new TreeNode(rootVal);
	Stack<TreeNode> sNode = new Stack<>();
	Stack<Integer> depths = new Stack<>();
	sNode.add(root);
	depths.add(0);
	int depth = 0;
	int i = rootPos[1];
	while (i < S.length()) {
	    char c = S.charAt(i);
	    if (c == '-') {
		depth++;
		i++;
	    } else {
		int[] curPos = readNextValue(i, S);
		int v = curPos[0];
		TreeNode curNode = new TreeNode(v);
		int curDepth = depths.peek();
		while (curDepth >= depth) {
		    sNode.pop();
		    depths.pop();
		    curDepth = depths.peek();
		}
		TreeNode parent = sNode.peek();
		if (parent.left == null) {
		    parent.left = curNode;
		} else {
		    parent.right = curNode;

		}
		sNode.push(curNode);
		depths.push(depth);
		depth = 0;
		i = curPos[1];
	    }
	}

	return root;
    }

    private int[] readNextValue(int i, String S) {
	int[] res = new int[2];
	int v = 0;
	int index = 0;
	for (int idx = i; idx < S.length(); idx++) {
	    char c = S.charAt(idx);
	    index=idx;
	    if (c == '-') {
		break;
	    } else {
		v = 10 * v + (c - '0');
	    }
	    index++;
	}
	res[0] = v;
	res[1] = index;
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
	s.recoverFromPreorder("1-401--349---90--88");
    }
}
