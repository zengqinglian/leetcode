package addTwoNumbers;

public class Solution
{
    public ListNode addTwoNumbers( ListNode l1, ListNode l2 ) {
        int sum = 0;
        if( l1 == null && l2 == null ) {
            return null;
        } else {
            if( l1 != null ) {
                sum += l1.val;
            }
            if( l2 != null ) {
                sum += l2.val;
            }
        }
        ListNode returnNode = null;
        if( sum >= 10 ) {
            returnNode = new ListNode( sum - 10 );

            if( l1.next != null ) {
                l1.next.val = l1.next.val + 1;

            } else {
                l1.next = new ListNode( 1 );
            }

        } else {
            returnNode = new ListNode( sum );
        }
        ListNode left = l1 == null ? null : l1.next;
        ListNode right = l2 == null ? null : l2.next;
        returnNode.next = addTwoNumbers( left, right );
        return returnNode;
    }

}
