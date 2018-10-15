package smallestSubtreewithalltheDeepestNodes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {
    // 6ms Solution beat 20%
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
	Map<Integer, TreeNode> childParentMap = new HashMap<>();
	// bfs
	Queue<TreeNode> q = new LinkedList<>();
	q.add(root);
	Set<TreeNode> lowestChildren = new HashSet<>();
	while (!q.isEmpty()) {
	    lowestChildren.clear();
	    int size = q.size();
	    for (int i = 0; i < size; i++) {
		TreeNode cur = q.poll();
		lowestChildren.add(cur);
		if(cur.left!=null) {
		    childParentMap.put(cur.left.val, cur);
		    q.add(cur.left);
		}
		if(cur.right!=null) {
		    childParentMap.put(cur.right.val, cur);
		    q.add(cur.right);
		}
	    }
	}
	
	while (true) {
	    Set<TreeNode> curSet = new HashSet<>();
	    for(TreeNode node: lowestChildren) {
		if (lowestChildren.size() == 1) {
		    return node;
		} else {
		    curSet.add(childParentMap.get(node.val));
		}
	    }
	    lowestChildren = curSet;
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
	Solution s = new Solution();
	TreeNode n0 = new TreeNode(0);
	TreeNode n1 = new TreeNode(1);
	TreeNode n2 = new TreeNode(2);
	TreeNode n3 = new TreeNode(3);
	TreeNode n4 = new TreeNode(4);
	TreeNode n5 = new TreeNode(5);
	TreeNode n6 = new TreeNode(6);
	TreeNode n7 = new TreeNode(7);
	TreeNode n8 = new TreeNode(8);
	n3.left = n5;
	n3.right = n1;
	n5.left = n6;
	n5.right = n2;
	n2.left = n7;
	n2.right = n4;
	n1.left = n0;
	n1.right = n8;

	s.subtreeWithAllDeepest(n3);
    }
}
