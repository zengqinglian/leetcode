package reverseNodesinkGroup;

public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        int i = 1;
        ListNode nextHead = head;
        while (i <= k && nextHead != null) {
            nextHead = nextHead.next;
            i++;
        }

        if (nextHead == null) {
            return reverseK(head, k);
        }

        ListNode newHead = reverseK(head, k);

        i = 1;
        ListNode currentNode = newHead;

        while (i < k) {
            currentNode = currentNode.next;
            i++;
        }

        currentNode.next = reverseKGroup(nextHead, k);

        return newHead;

    }

    private ListNode reverseK(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        if (k == 1) {
            head.next = null;
            return head;
        }

        int i = 1;
        ListNode currentNode = head;

        while (i < k && currentNode.next != null) {
            currentNode = currentNode.next;
            i++;
        }

        if (i == k) {
            ListNode returnHead = currentNode;

            returnHead.next = reverseK(head, i - 1);

            return returnHead;
        } else {
            return head;
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution s = new Solution();
        ListNode head = s.reverseKGroup(node1, 3);
        System.out.println(head.val);
        System.out.println(head.next.val);
        System.out.println(head.next.next.val);
        System.out.println(head.next.next.next.val);
    }
}
