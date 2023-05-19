package closestNodesQueriesinaBinarySearchTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Runtime 59 ms
Beats 90.6%
Memory 101.5 MB
Beats 20.99%
 */
public class Solution1 {

    private int idx = 0;
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        int[] array = new int[100000];
        sortArray(root, array);
        List<List<Integer>> result = new ArrayList<>();
        for (int query : queries) {
            int target = Arrays.binarySearch(array,0, idx, query);
            if (target>=0) {
                result.add(Arrays.asList(query, query));
            }else {
                int insert = -target -1;
                int x = 0;
                if (insert-1 < 0) {
                    x = -1;
                }else{
                    x = array[insert-1];
                }
                int y = 0;
                if (insert == idx){
                    y=-1;
                }else{
                    y = array[insert];
                }
                result.add(Arrays.asList(x, y));
            }
        }
        return result;
    }

    private void sortArray(TreeNode root, int[] array) {
        if (root.left != null) {
            sortArray(root.left, array);
            array[idx++] = root.val;
        }
        if (root.left == null && root.right == null) {
            array[idx++] = root.val;
        }
        if (root.right != null) {
            if (root.left == null) {
                array[idx++] = root.val;
            }
            sortArray(root.right, array);
        }
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
//        //[6,2,13,1,4,9,15,null,null,null,null,null,null,14]
//        TreeNode node1  =  new TreeNode(6);
//        TreeNode node2  =  new TreeNode(2);
//        TreeNode node3  =  new TreeNode(13);
//        TreeNode node4  =  new TreeNode(1);
//        TreeNode node5  =  new TreeNode(4);
//        TreeNode node6  =  new TreeNode(9);
//        TreeNode node7  =  new TreeNode(15);
//        TreeNode node8  =  new TreeNode(14);
//
//        node1.left = node2;
//        node1.right= node3;
//
//        node2.left = node4;
//        node2.right=node5;
//
//        node3.left=node6;
//        node3.right=node7;
//
//        node7.left = node8;
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(9);
        node1.right=node2;
        Integer[] array = {3};

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
