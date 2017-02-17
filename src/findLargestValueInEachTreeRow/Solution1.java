package findLargestValueInEachTreeRow;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
    // beat 50% solution
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        List<TreeNode> initList = new ArrayList<>();
        initList.add(root);
        checkMax(initList, result);

        return result;
    }

    private void checkMax(List<TreeNode> list, List<Integer> result) {
        if (list.isEmpty()) {
            return;
        }
        List<TreeNode> newList = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (TreeNode node : list) {
            max = Math.max(max, node.val);
            if (node.left != null) {
                newList.add(node.left);
            }
            if (node.right != null) {
                newList.add(node.right);
            }
        }
        result.add(max);
        checkMax(newList, result);

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
