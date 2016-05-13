package sortList;

public class Solution
{
    public ListNode sortList( ListNode head ) {
        if( head == null || head.next == null ) {
            return head;
        }

        return mergeSort( head );

    }

    private ListNode mergeSort( ListNode head ) {
        if( head.next == null ) {
            return head;
        } else if( head.next.next == null ) {
            ListNode end = head.next;
            if( head.val > end.val ) {
                end.next = head;
                head.next = null;
                return end;
            } else {
                return head;
            }
        } else {
            ListNode middle = getMiddle( head );
            ListNode nextMiddle = middle.next;

            middle.next = null; // two linked list now
            return merge( mergeSort( head ), mergeSort( nextMiddle ) );

        }

    }

    private ListNode merge( ListNode head1, ListNode head2 ) {
        if( head1 == null ) {
            return head2;
        }
        if( head2 == null ) {
            return head1;
        }

        ListNode loop1 = null;
        ListNode loop2 = null;
        ListNode newHead = null;
        ListNode newLoop = null;

        if( head1.val > head2.val ) {
            loop1 = head1;
            loop2 = head2.next;
            newHead = head2;
            newLoop = head2;
        } else {
            loop1 = head1.next;
            loop2 = head2;
            newHead = head1;
            newLoop = head1;
        }

        while( loop1 != null && loop2 != null ) {
            if( loop1.val > loop2.val ) {
                newLoop.next = loop2;
                newLoop = loop2;
                loop2 = loop2.next;
            } else {
                newLoop.next = loop1;
                newLoop = loop1;
                loop1 = loop1.next;
            }
        }

        if( loop1 == null ) {
            newLoop.next = loop2;
        }
        if( loop2 == null ) {
            newLoop.next = loop1;
        }

        return newHead;
    }

    private ListNode getMiddle( ListNode startNode ) {
        ListNode fast = startNode;
        ListNode slow = startNode;

        while( fast.next != null && fast.next.next != null ) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        ListNode l1 = new ListNode( 2 );
        ListNode l2 = new ListNode( 6 );
        ListNode l3 = new ListNode( 1 );
        ListNode l4 = new ListNode( 5 );
        ListNode l5 = new ListNode( 7 );

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ListNode newList = s.sortList( l1 );
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
