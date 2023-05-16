package removeNodesFromLinkedList;
/*
Runtime 27 ms Beats 40.44% Memory v64.1 MB Beats 68.24%
 */
public class Solution {

    public ListNode removeNodes(ListNode head) {
        ListNode res = head;
        ListNode current = head;
        while (current.next != null) {
            if (current.next.val <= current.val) {
                current = current.next;
            }else {
                if(res.val < current.next.val) {
                    res = current.next;
                    current = current.next;
                }else{
                    ListNode pointer = res;
                    ListNode pre = null;
                    while(pointer.val >= current.next.val) {
                        pre = pointer;
                        pointer = pointer.next;
                    }
                    pre.next = current.next;
                    current = current.next;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        ListNode node1 = new ListNode(5);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(13);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(8);
        node1.next =  node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        s.removeNodes(node1);
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

}
