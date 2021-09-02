package pseudoPalindromicPathsinaBinaryTree;

/*
Runtime: 20 ms, faster than 50.11% of Java online submissions for Pseudo-Palindromic Paths in a Binary Tree.
Memory Usage: 64.9 MB, less than 94.58% of Java online submissions for Pseudo-Palindromic Paths in a Binary Tree.
 */
public class Solution {
    int[] count = new int[10];
    int res = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        count[root.val]++;
        if(root.left!=null) {
            pseudoPalindromicPaths(root.left);
            count[root.left.val]--;
        }
        if(root.right!=null) {
            pseudoPalindromicPaths(root.right);
            count[root.right.val]--;
        }
        if(root.left == null && root.right == null){
            if(check(count)){
                res++;
            }
        }

        return res;
    }

    private boolean check(int[] count) {
        int oddCnt = 0;
        for(int i=1; i<=9; i++){
            if(count[i] % 2 == 1 ){
                oddCnt++;
            }
        }
        return (oddCnt == 0 || oddCnt == 1);
    }


    private static class TreeNode{
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
