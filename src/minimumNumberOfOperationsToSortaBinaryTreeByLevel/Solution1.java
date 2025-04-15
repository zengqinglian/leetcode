package minimumNumberOfOperationsToSortaBinaryTreeByLevel;

import java.util.*;
/*
Runtime
54 ms
Beats
59.52%
Analyze Complexity
Memory
59.14 MB
Beats
95.83%
 */

public class Solution1 {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            Map<Integer, Integer> map = new HashMap<>(); //value , index pair
            int[] originalArray = new int[size];
            for (int i=0; i<size; i++) {
                TreeNode cur = q.poll();
                originalArray[i] = cur.val;
                map.put(cur.val, i);
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right!=null) {
                    q.add(cur.right);
                }
            }
            res += getSwap(map, originalArray);
        }
        return res;
    }

    private int getSwap(Map<Integer, Integer> map, int[] originalArray) {
        if (map.size() <=1) {
            return 0;
        }
        int res = 0;
        int[] sortedArray = originalArray.clone();
        Arrays.sort(sortedArray);
        for (int i=0; i<sortedArray.length; i++) {
            if (sortedArray[i] != originalArray[i]) {
                int targetIndex = map.get(sortedArray[i]);
                originalArray[targetIndex] = originalArray[i];
                map.put(originalArray[i], targetIndex);
                res++;
            }
        }
        return res;
    }

    public static class TreeNode {
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
