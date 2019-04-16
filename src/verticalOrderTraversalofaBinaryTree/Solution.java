package verticalOrderTraversalofaBinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    // 4ms solution beat 80%
    public List<List<Integer>> verticalTraversal(TreeNode root) {
	TreeMap<Integer, List<Integer>> map = new TreeMap<>();
	Queue<Integer> q = new LinkedList<>();
	Queue<TreeNode> Q = new LinkedList<>();
	q.add(0);
	Q.add(root);
	
	while(!q.isEmpty()) {
	    int size = q.size();
	    TreeMap<Integer, TreeSet<Integer>> temp = new TreeMap<>();
	    for (int i = 0; i < size; i++) {
		int val = q.poll();
		TreeNode node = Q.poll();
		TreeSet<Integer> set = temp.get(val);
		if (set == null) {
		    set = new TreeSet<>();
		    temp.put(val, set);
		}
		set.add(node.val);
		if (node.left != null) {
		    q.add(val - 1);
		    Q.add(node.left);
		}
		if (node.right != null) {
		    q.add(val + 1);
		    Q.add(node.right);
		}
	    }
	    for (int key : temp.keySet()) {
		List<Integer> li = map.get(key);
		if (li == null) {
		    li = new LinkedList<>();
		    map.put(key, li);
		}
		li.addAll(temp.get(key));
	    }
	}
	
	List<List<Integer>> res = new LinkedList<>();
	for (int key : map.keySet()) {
	    res.add(map.get(key));
	}
	return res;

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
	TreeNode n9 = new TreeNode(9);

	n0.left = n5;
	n0.right = n1;

	n5.left = n9;

	n1.left = n2;
	n2.right = n3;

	n3.left = n4;
	n3.right = n8;
	n4.left = n6;
	n6.left = n7;

	s.verticalTraversal(n0);
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
