package constructBinaryTreefromInorderandPostorderTraversal;

import java.util.HashMap;
import java.util.Map;

public class Solution {
  // 7ms solution - meet avg speed. beat 66%
  public TreeNode buildTree(int[] inorder, int[] postorder) {
    if (inorder.length == 0) {
      return null;
    }
    if (inorder.length == 1) {
      return new TreeNode(inorder[0]);
    }

    Map<Integer, Integer> inMap = new HashMap<>();
    for (int i = 0; i < inorder.length; i++) {
      inMap.put(inorder[i], i);
    }

    return helpBuild(inorder, postorder, inMap, 0, inorder.length - 1, 0, postorder.length - 1);

  }

  private TreeNode helpBuild(int[] inorder, int[] postorder, Map<Integer, Integer> inMap,
      int istart, int iend, int pstart, int pend) {
    if (istart > iend || pstart > pend) {
      return null;
    }
    if (istart == iend) {
      return new TreeNode(inorder[istart]);
    }

    TreeNode root = new TreeNode(postorder[pend]);
    int inIndex = inMap.get(postorder[pend]);
    int leftLen = inIndex - istart;
    int rightLen = iend - inIndex;
    root.left =
        helpBuild(inorder, postorder, inMap, istart, inIndex - 1, pstart, pstart + leftLen - 1);
    root.right = helpBuild(inorder, postorder, inMap, inIndex + 1, iend, pend - rightLen, pend - 1);

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

  public static void main(String[] args) {
    Solution s = new Solution();
    int[] inorder = {1, 2, 3, 4};
    int[] postorder = {3, 2, 4, 1};
    s.buildTree(inorder, postorder);
  }
}
