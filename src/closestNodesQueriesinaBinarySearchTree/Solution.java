package closestNodesQueriesinaBinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*

Time limit over solution
search directly from tree.
 */
public class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>();
        for(int query : queries) {
            List<Integer> res = new ArrayList<>(2);
            res.add(0);
            res.add(0);
            searchTree(root, query, res, -1, -1);
            result.add(res);
        }
        return result;
    }

    private void searchTree (TreeNode node, int value, List<Integer> result, int larger, int smaller) {
        if (node.val == value) {
            result.set(0, value);
            result.set(1, value);
        }else if (node.val > value) {
            if (node.left != null ) {
                searchTree(node.left, value, result, node.val, smaller);
            }else {
                result.set(0, smaller);
                result.set(1, node.val);
            }
        } else {
            if (node.right != null) {
                searchTree(node.right, value, result, larger, node.val);
            } else {
                result.set(1, larger);
                result.set(0, node.val);
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //[6,2,13,1,4,9,15,null,null,null,null,null,null,14]
        TreeNode node1  =  new TreeNode(6);
        TreeNode node2  =  new TreeNode(2);
        TreeNode node3  =  new TreeNode(13);
        TreeNode node4  =  new TreeNode(1);
        TreeNode node5  =  new TreeNode(4);
        TreeNode node6  =  new TreeNode(9);
        TreeNode node7  =  new TreeNode(15);
        TreeNode node8  =  new TreeNode(14);

        node1.left = node2;
        node1.right= node3;

        node2.left = node4;
        node2.right=node5;

        node3.left=node6;
        node3.right=node7;

        node7.left = node8;
        Integer[] array = {2,5,16};

        s.closestNodes(node1, new ArrayList<>(Arrays.asList(array)));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


