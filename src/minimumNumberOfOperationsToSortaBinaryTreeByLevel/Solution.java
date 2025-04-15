package minimumNumberOfOperationsToSortaBinaryTreeByLevel;

import java.util.*;
import java.util.stream.Collectors;
/*
Runtime
102ms
Beats 11.01%
Analyze Complexity
Memory
69.46 MB
Beats 14.29%
 */
public class Solution {
    public int minimumOperations(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            Map<Integer, Integer> map = new HashMap<>(); //value , index pair
            Map<Integer, Integer> mapIndex = new HashMap<>(); //index , value
            int currentIndex = 0;
            for (int i=0; i<size; i++) {
                TreeNode cur = q.poll();
                if (cur.left != null) {
                    q.add(cur.left);
                    mapIndex.put(currentIndex, cur.left.val);
                    map.put(cur.left.val, currentIndex++);
                }
                if (cur.right!=null) {
                    q.add(cur.right);
                    mapIndex.put(currentIndex, cur.right.val);
                    map.put(cur.right.val, currentIndex++);
                }
            }
            res += getSwap(map,mapIndex);
        }
        return res;
    }

    private int getSwap(Map<Integer, Integer> map, Map<Integer, Integer> mapIndex) {
        if (map.size() <=1) {
            return 0;
        }
        int res = 0;
        List<Integer> sortedList = map.keySet().stream().sorted().collect(Collectors.toList());
        for (int i=0; i<sortedList.size(); i++) {
            int targetIndex = map.get(sortedList.get(i));
            if (targetIndex != i) {
                int value = mapIndex.get(i);
                map.put(value, targetIndex);
                mapIndex.put(targetIndex, value);
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //[49,45,1,20,46,15,39,27,null,null,null,25]
        TreeNode node1 = new TreeNode(49);
        TreeNode node3 = new TreeNode(45);
        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(20);
        TreeNode node6 = new TreeNode(46);
        TreeNode node7 = new TreeNode(15);
        TreeNode node8 = new TreeNode(39);
        TreeNode node9 = new TreeNode(27);
        TreeNode node10 = new TreeNode(25);
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;
        node3.right = node6;
        node4.left= node7;
        node4.right = node8;
        node5.left = node9;
        node7.left = node10;
        s.minimumOperations(node1);
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
