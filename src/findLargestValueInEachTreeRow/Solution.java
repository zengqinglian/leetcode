package findLargestValueInEachTreeRow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    // beat 20% solution
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> layerQueue = new LinkedList<>();

        if (root == null) {
            return result;
        }

        nodeQueue.add(root);
        layerQueue.add(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int layer = layerQueue.poll();
            if (node.left != null) {
                nodeQueue.add(node.left);
                layerQueue.add(layer + 1);
            }

            if (node.right != null) {
                nodeQueue.add(node.right);
                layerQueue.add(layer + 1);
            }

            if (result.size() < layer + 1) {
                result.add(node.val);
            } else {
                result.set(layer, Math.max(result.get(layer), node.val));
            }
        }

        return result;
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
