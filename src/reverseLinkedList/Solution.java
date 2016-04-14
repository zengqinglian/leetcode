package reverseLinkedList;

public class Solution
{
    public ListNode reverseList( ListNode head ) {
        ListNode previous = head;
        ListNode current = head.next;
        if( current == null ) {
            return head;
        }
        ListNode next = current.next;
        if( next == null ) {
            current.next = previous;
            previous.next = null;
            return current;
        }

        while( next != null ) {
            if( previous == head ) {
                previous.next = null;
            }
            current.next = previous;
            previous = current;
            current = next;
            next = next.next;
        }

        if( next == null ) {
            current.next = previous;
        }

        return current;
    }

    private static class ListNode
    {
        int val;
        ListNode next;

        ListNode( int x ) {
            val = x;
        }
    }
}
