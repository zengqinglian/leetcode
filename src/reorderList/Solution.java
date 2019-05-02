package reorderList;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    // 6ms solution , beat 10%
    public void reorderList(ListNode head) {
	if (head == null || head.next == null) {
	    return;
	}
	
	Queue<Integer> oddsValues = new LinkedList<>();
	Stack<Integer> evenValues = new Stack<>();
	ListNode cur = head;
	while (cur != null) {
	    oddsValues.add(cur.val);
	    evenValues.push(cur.val);
	    cur = cur.next;
	}

	ListNode cur1 = head;
	while (cur1 != null && cur1.next != null) {
	    cur1.val = oddsValues.poll();
	    cur1.next.val = evenValues.pop();
	    cur1 = cur1.next.next;
	}

	if (cur1 != null) {
	    cur1.val = oddsValues.poll();
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
