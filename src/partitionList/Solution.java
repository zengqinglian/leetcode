package partitionList;

public class Solution
{
    public ListNode partition( ListNode head, int x ) {
        if( head == null ) {
            return null;
        }

        ListNode loop = head;
        ListNode largerValPointer = null;
        ListNode previousLargerValPointer = null;
        ListNode previous = null;
        ListNode newHead = head;

        while( loop != null ) {
            if( loop.val < x ) {
                if( largerValPointer != null ) {
                    if( previous == null ) {
                        previous = loop;
                        newHead = loop;
                    } else {
                        previous.next = loop;
                        previous = loop;
                    }
                } else {
                    if( previous == null ) {
                        previous = loop;
                        newHead = loop;
                    } else {
                        previous = loop;
                    }
                }
                if( previousLargerValPointer != null ) {
                    previousLargerValPointer.next = loop.next;
                }

            } else {
                if( largerValPointer == null ) {
                    largerValPointer = loop;
                }

                if( previousLargerValPointer != null ) {
                    previousLargerValPointer.next = loop;

                }
                previousLargerValPointer = loop;
            }
            loop = loop.next;
        }

        if( previous != null )
            previous.next = largerValPointer;

        return newHead;
    }

    public static void main( String[] args ) {
        ListNode l1 = new ListNode( 1 );
        ListNode l2 = new ListNode( 1 );
        // ListNode l3 = new ListNode( 3 );
        // ListNode l4 = new ListNode( 2 );
        // ListNode l5 = new ListNode( 5 );
        // ListNode l6 = new ListNode( 2 );

        l1.next = l2;
        // l2.next = l3;
        // l3.next = l4;
        // l4.next = l5;
        // l5.next = l6;

        Solution s = new Solution();
        s.partition( l1, 2 );

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
