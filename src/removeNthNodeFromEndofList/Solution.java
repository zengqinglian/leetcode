package removeNthNodeFromEndofList;

/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode next; ListNode(int x) { val = x; } }
 */
public class Solution
{
    public ListNode removeNthFromEnd( ListNode head, int n ) {
        if( n == 0 ) {
            return head;
        }

        if( n == 1 && head.next == null ) {
            return null;
        }

        ListNode p1 = head;
        ListNode p2 = head;

        while( n > 0 ) {
            if( p1.next != null ) {
                p1 = p1.next;
                n--;
            } else {
                return p2.next;
            }
        }
        while( p1.next != null ) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;
        return head;

    }

    public static class ListNode
    {
        int val;
        ListNode next;

        ListNode( int x ) {
            val = x;
        }
    }
}
