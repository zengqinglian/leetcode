package maximumBinaryTree;

public class Solution {
  public TreeNode constructMaximumBinaryTree(int[] nums) {

    return getMaxTree(nums, 0, nums.length - 1);
  }

  private TreeNode getMaxTree(int[] nums, int s, int e) {
    int max = Integer.MIN_VALUE;
    int index = -1;
    for (int i = s; i <= e; i++) {
      if (max < nums[i]) {
        max = nums[i];
        index = i;
      }
    }
    TreeNode root = new TreeNode(max);

    if (index - 1 >= s) {
      root.left = getMaxTree(nums, s, index - 1);
    }

    if (index + 1 <= e) {
      root.right = getMaxTree(nums, index + 1, e);
    }

    return root;

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
