package findElementsInAContaminatedBinaryTree;

//16ms solution , meet avg. beat 50%
public class FindElements {
    boolean[] values = new boolean[1000001];
    public FindElements(TreeNode root) {
        root.val = 0;
        values[0] = true;
        recover(root);
    }

    private void recover(TreeNode root){
        if(root.left != null){
            root.left.val = root.val * 2 + 1;
            if(root.left.val<=1000000) {
                values[root.left.val] = true;
                recover(root.left);
            }
        }
        if(root.right !=null){
            root.right.val = root.val * 2 +2;
            if(root.right.val<=1000000) {
                values[root.right.val] = true;
                recover(root.right);
            }
        }
    }

    public boolean find(int target) {
        return values[target];
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        System.out.println(1<<2);
        System.out.println(2 | 1);
    }
}


