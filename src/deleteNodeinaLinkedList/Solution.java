package deleteNodeinaLinkedList;
/*
Runtime
0 ms
Beats
100%
Memory
43.5 MB
Beats
10.41%
 */
public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
