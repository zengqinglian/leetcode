package constructBinaryTreefromPreorderandPostorderTraversal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 23ms solution beat only 15%. Use array to map val and index can improve
    // performance
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
	Map<Integer, Integer> postMap = new HashMap<>();
	for (int i = 0; i < post.length; i++) {
	    postMap.put(post[i], i);
	}
	
	Map<Integer, Integer> pretMap = new HashMap<>();
	for(int i=0; i<pre.length; i++) {
	    pretMap.put(pre[i], i);
	}
	

	Map<Integer, TreeNode> nodeMap = new HashMap<>();
	for (int s = 0; s < pre.length; s++) {
	    TreeNode cur = nodeMap.get(pre[s]);
	    if (cur == null) {
		cur = new TreeNode(pre[s]);
		nodeMap.put(pre[s], cur);
	    } 
	    int val = cur.val;
	    int preIndex = pretMap.get(val);
	    int leftIndex = preIndex + 1;
	    int postIndex = postMap.get(val);
	    int rightIndex = postIndex - 1;
	    if (leftIndex <= pre.length - 1) {
		TreeNode left = nodeMap.get(pre[leftIndex]);
		if (left == null) {
		    left = new TreeNode(pre[leftIndex]);
		    nodeMap.put(pre[leftIndex], left);
		    cur.left = left;
		}
	    }

	    if (rightIndex >= 0) {
		TreeNode right = nodeMap.get(post[rightIndex]);
		if (right == null) {
		    right = new TreeNode(post[rightIndex]);
		    nodeMap.put(post[rightIndex], right);
		    cur.right = right;
		}
	    }
	}

	return nodeMap.get(pre[0]);
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
	int[] pre = { 1, 2, 4, 5, 3, 6, 7 };
	int[] post = { 4, 5, 2, 6, 7, 3, 1 };
	s.constructFromPrePost(pre, post);
    }
}
