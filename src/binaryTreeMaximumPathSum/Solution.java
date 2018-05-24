package binaryTreeMaximumPathSum;

public class Solution {
// 2-3ms solution - beat 50% . meet avg
public int maxPathSum(TreeNode root) {
int[] result = { Integer.MIN_VALUE };
maxSum(root, result);
return result[0];
}

private int[] maxSum(TreeNode node, int[] result) {
int[] res = new int[2];
if (node.left == null && node.right == null) {
res[0] = node.val;
res[1] = node.val;
if (node.val > result[0]) {
result[0] = Math.max(result[0], node.val);
}
} else if (node.left != null && node.right != null) {

int[] resLeft = maxSum(node.left, result);
int[] resRight = maxSum(node.right, result);
res[0] = Math.max(node.val, Math.max(resLeft[0], resRight[0]) + node.val);
res[1] = Math.max(node.val, resLeft[0] + resRight[0] + node.val);
result[0] = Math.max(result[0], Math.max(res[0], res[1]));
} else {

if (node.left != null) {
int[] resLeft = maxSum(node.left, result);
res[0] = Math.max(node.val, resLeft[0] + node.val);
res[1] = Math.max(node.val, resLeft[0] + node.val);
result[0] = Math.max(result[0], Math.max(res[0], res[1]));
}
if (node.right != null) {
int[] resultRight = maxSum(node.right, result);
res[0] = Math.max(node.val, resultRight[0] + node.val);
res[1] = Math.max(node.val, resultRight[0] + node.val);
result[0] = Math.max(result[0], Math.max(res[0], res[1]));
}

}
return res;

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
TreeNode root = new TreeNode(2);
TreeNode left = new TreeNode(-1);
root.left = left;

s.maxPathSum(root);
}
}
