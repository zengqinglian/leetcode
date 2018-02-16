package rotateList;

public class Solution {
    // 17ms solution - meet avg
    public ListNode rotateRight(ListNode head, int k) {
	if(k==0) {
	    return head;
	}
	
	if (head == null) {
	    return head;
	}

	ListNode newHead = head.next;
	ListNode newTail = head;
	ListNode current = head;
	ListNode last = null;
	int count = 1;
	
	while (current.next != null) {
	    count++;
	    current = current.next;

	}
	
	last = current;

	if (count == 1) {
	    return head;
	}

	int move = k % count;
	
	move = count - move;
	
	if (move == count) {
	    return head;
	}

	int cnt = 1;
	while (cnt < move) {
	    newHead = newHead.next;
	    newTail = newTail.next;
	    cnt++;
	}

	last.next = head;
	newTail.next = null;

	return newHead;


    }

    private static class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	}
    }

    public static void main(String[] args) {
	ListNode n1 = new ListNode(1);
	ListNode n2 = new ListNode(2);
	ListNode n3 = new ListNode(3);
	ListNode n4 = new ListNode(4);
	ListNode n5 = new ListNode(5);

	n1.next = n2;
	n2.next = n3;
	n3.next = n4;
	n4.next = n5;

	Solution s = new Solution();
	s.rotateRight(n1, 5);

    }
}
