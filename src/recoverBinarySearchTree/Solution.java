package recoverBinarySearchTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
space O(N) solution
Runtime
3 ms
Beats
21.95%
Memory
43.9 MB
Beats
7.93%
 */
public class Solution {
    int counter = 0;
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        Collections.sort(list);
        recoverHelper(root, list);
    }

    private void recoverHelper(TreeNode node, List<Integer> list) {

        if (node.left != null) {
            recoverHelper(node.left, list);
        }

        node.val = list.get(counter);
        counter++;

        if (node.right != null) {
            recoverHelper(node.right, list );
        }
    }

    private void inOrderTraversal(TreeNode node, List<Integer> list) {
        if (node.left != null) {
            inOrderTraversal(node.left, list);
        }
        list.add(node.val);
        if(node.right != null) {
            inOrderTraversal(node.right, list);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode n1 = new TreeNode(1);
        TreeNode n3 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        n1.left = n3;
        n3.right = n2;
        s.recoverTree(n1);
    }

    private static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
}
