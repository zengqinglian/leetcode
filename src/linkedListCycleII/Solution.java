package linkedListCycleII;

import java.util.HashSet;
import java.util.Set;

public class Solution
{
    // first thought
    public ListNode detectCycle( ListNode head ) {
        if( head == null || head.next == null ) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();

        ListNode point = head;
        while( point != null ) {
            if( !set.add( point ) ) {
                return point;
            }
            point = point.next;
        }

        return null;

    }

    private static class ListNode
    {
        int val;
        ListNode next;

        ListNode( int x ) {
            val = x;
            next = null;
        }
    }
}
