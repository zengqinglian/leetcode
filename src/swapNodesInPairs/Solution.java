package swapNodesInPairs;

public class Solution
{
    public ListNode swapPairs( ListNode head ) {
        if( head == null ) {
            return null;
        }

        if( head.next == null ) {
            return head;
        }

        if( head.next.next == null ) {
            ListNode temp = head;
            head = head.next;
            head.next = temp;
            temp.next = null;
            return head;
        }

        if( head.next.next.next == null ) {
            ListNode temp = head;
            ListNode nextGroupTemp = head.next.next;
            head = head.next;
            head.next = temp;
            temp.next = nextGroupTemp;
            return head;

        }

        if( head.next.next.next != null ) {
            ListNode node1 = head;
            ListNode node2 = head.next;
            ListNode node3 = head.next.next;
            ListNode node4 = head.next.next.next;
            ListNode newHead = head.next.next.next.next;

            head = node2;
            node2.next = node1;
            node1.next = node4;
            node4.next = node3;
            node3.next = swapPairs( newHead );
        }
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

    public static void main( String[] args ) {
        ListNode node1 = new ListNode( 1 );
        ListNode node2 = new ListNode( 2 );
        ListNode node3 = new ListNode( 3 );
        ListNode node4 = new ListNode( 4 );
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        Solution s = new Solution();

        System.out.print( s.swapPairs( node1 ) );
    }
}
