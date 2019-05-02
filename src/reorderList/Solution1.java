package reorderList;

import java.util.Deque;
import java.util.LinkedList;

public class Solution1 {
    // 3ms solution, meet avg speed.
    public void reorderList(ListNode head) {
	if (head == null || head.next == null) {
	    return;
	}

	Deque<Integer> dq = new LinkedList<>();
	ListNode cur = head;
	while (cur != null) {
	    dq.add(cur.val);
	    cur = cur.next;
	}

	ListNode cur1 = head;
	while (cur1 != null && cur1.next != null) {
	    cur1.val = dq.pollFirst();
	    cur1.next.val = dq.pollLast();
	    cur1 = cur1.next.next;
	}

	if (cur1 != null) {
	    cur1.val = dq.poll();
	}
    }

    private static class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	}
    }
}
