package addTwoNumbersII;

public class Solution {
    // 2ms solution , beat 99%
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	int len1 = 0;
	ListNode h1 = l1;
	while (h1 != null) {
	    len1++;
	    h1 = h1.next;
	}

	int len2 = 0;
	ListNode h2 = l2;
	while (h2 != null) {
	    len2++;
	    h2 = h2.next;
	}

	int len = Math.max(len1, len2);
	int[] vals = new int[len + 1];
	for (int i = 1; i <= len; i++) {
	    int a = 0;
	    if (len1 > len - i) {
		a = l1.val;
		l1 = l1.next;
	    }
	    int b = 0;
	    if (len2 > len - i) {
		b = l2.val;
		l2 = l2.next;
	    }
	    vals[i] = a + b;
	}
	
	ListNode head = null;
	for (int i = len; i >= 1; i--) {
	    int val = vals[i];
	    if(vals[i]>=10) {
		val = vals[i]-10;
		vals[i-1] = vals[i-1] +1;
	    }
	    ListNode node = new ListNode(val);
	    if (head == null) {
		head = node;
	    } else {
		node.next = head;
		head = node;
	    }
	}
	if (vals[0] > 0) {
	    ListNode node = new ListNode(vals[0]);
	    node.next = head;
	    head = node;
	}

	return head;
    }

    public static void main(String[] args) {

    }


    private static class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
	    val = x;
	}
    }
}
