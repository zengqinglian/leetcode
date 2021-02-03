package linkedListinBinaryTree;

public class Solution {
    //1ms solution beat 90%
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(root == null){
            return false;
        }
        return check(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
    }

    private boolean check(ListNode head, TreeNode root) {
        if(root == null){
            return false;
        }
        if(head.val != root.val){
            return false;
        }
        if(head.next==null){
            return true;
        }
        return check(head.next, root.left) || check(head.next, root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
//        TreeNode node5 = new TreeNode(1);
//        TreeNode node6 = new TreeNode(8);
        root.left=node1;
        node1.right =node3;
        //node3.left = node5;
        root.right = node2;
        node2.left = node4;
        //node4.right= node6;
        ListNode head = new ListNode(3);
//        ListNode listNode2 = new ListNode(2);
//        ListNode listNode8 = new ListNode(8);
//        head.next=listNode2;
//        listNode2.next=listNode8;
        Solution s = new Solution();
        s.isSubPath(head,root);
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
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
