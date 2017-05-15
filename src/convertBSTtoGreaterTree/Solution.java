package convertBSTtoGreaterTree;

public class Solution {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }

    public void convert(TreeNode cur) {
        if (cur == null)
            return;
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
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
        // 4,0,8,-4,1,7,9
        Solution s = new Solution();
        TreeNode root = new TreeNode(4);
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(-4);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(9);
        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        s.convertBST(root);
    }
}
