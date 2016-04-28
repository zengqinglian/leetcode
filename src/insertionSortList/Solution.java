package insertionSortList;

public class Solution
{
    public ListNode insertionSortList( ListNode head ) {
        if( head == null ) {
            return null;
        }
        ListNode loopNode = head;
        ListNode newHead = head;

        while( loopNode.next != null ) {
            ListNode next = loopNode.next;

            if( next.val < loopNode.val ) {
                loopNode.next = next.next;

                ListNode cursor = newHead;
                if( cursor.val > next.val ) {
                    next.next = cursor;
                    newHead = next;
                } else if( cursor != loopNode ) {
                    while( cursor.next != loopNode ) {
                        if( cursor.next.val > next.val ) {
                            next.next = cursor.next;
                            cursor.next = next;
                            break;
                        } else {
                            cursor = cursor.next;
                        }
                    }
                    if( cursor.next == loopNode ) {
                        cursor.next = next;
                        next.next = loopNode;
                    }
                }

            } else {
                loopNode = loopNode.next;
            }

        }
        return newHead;
    }

    public static void main( String[] args ) {
        Solution s = new Solution();
        ListNode l1 = new ListNode( 5 );
        ListNode l2 = new ListNode( 3 );
        ListNode l3 = new ListNode( 1 );
        ListNode l4 = new ListNode( 4 );
        ListNode l5 = new ListNode( 2 );

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        s.insertionSortList( l1 );

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
