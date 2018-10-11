package allNodesDistanceKinBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    // 1ms solution beat 100%
    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
	List<Integer> result = new ArrayList<Integer>();
	LinkedList<TreeNode> nodes = new LinkedList<>();
	int[] distance = new int[1];
	distance[0] = -1;
	findTarget(root, nodes, target, result, K, distance);

	return result;
    }

    private void findAllChilds(TreeNode target, int distance, List<Integer> result, int K) {
	if (distance == K) {
	    result.add(target.val);
	} else {
	    if (target.left != null) {
		findAllChilds(target.left, distance + 1, result, K);
	    }

	    if (target.right != null) {
		findAllChilds(target.right, distance + 1, result, K);
	    }
	}
    }

    private boolean findTarget(TreeNode root, LinkedList<TreeNode> nodes, TreeNode target, List<Integer> result,
	    int K, int[] distance) {
	if (root.val == target.val) {
	    distance[0] = 0;
	    findAllChilds(target, 0, result, K);
	    return true;
	} else {
	    TreeNode left = root.left;
	    TreeNode right = root.right;
	    if (left != null) {
		if (findTarget(left, nodes, target, result, K, distance)) {
		    distance[0] = distance[0] + 1;
		    if (distance[0] >= 0 && distance[0] < K) {
			if (right != null) {
			    nodes.add(right);
			    findAllChilds(right, distance[0] + 1, result, K);
			}
		    }
		    if (distance[0] == K) {
			nodes.add(root);
			findAllChilds(root, distance[0], result, K);
		    }
		    return true;
		}
	    }
	    if (right != null) {
		if (findTarget(right, nodes, target, result, K, distance)) {

		    distance[0] = distance[0] + 1;
		    if (distance[0] >= 0 && distance[0] < K) {
			if (left != null) {
			    nodes.add(left);
			    findAllChilds(left, distance[0] + 1, result, K);
			}
		    }
		    if (distance[0] == K) {

			nodes.add(root);
			findAllChilds(root, distance[0], result, K);
		    }
		    return true;
		}
	    }
	    return false;
	}
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
	TreeNode n0 = new TreeNode(0);
	TreeNode n1 = new TreeNode(1);
	TreeNode n2 = new TreeNode(2);
	TreeNode n3 = new TreeNode(3);
	TreeNode n4 = new TreeNode(4);
	TreeNode n5 = new TreeNode(5);
	TreeNode n6 = new TreeNode(6);
	TreeNode n7 = new TreeNode(7);
	TreeNode n8 = new TreeNode(8);
	n3.left=n5;
	n3.right = n1;
	n5.left = n6;
	n5.right = n2;
	n2.left = n7;
	n2.right = n4;
	n1.left = n0;
	n1.right = n8;
	
	Solution s = new Solution();
	s.distanceK(n3, n5, 2);
	
    }
}
